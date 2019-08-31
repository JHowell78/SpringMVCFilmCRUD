package com.skilldistillery.film.daointerface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class DAOImpl implements DAOInterface {
	
	private static final String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private final String userName = "student";
	private final String password = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {     // FIND FILM BY ID - ACCESSES THE DATABASE AND RETURNS FILM      //// USER STORY 1 
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, rental_rate, "
					+ "length, replacement_cost, special_features, rating, name FROM film JOIN language "
					+ "ON language.id = film.language_id WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film();
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleasYear(filmResult.getInt("release_Year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setLanguage(filmResult.getString("name"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRental_rate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacement_cost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
				film.setCategory(findCategory(filmId).getCategory());
				
				film.setActor(findActorsByFilmId(filmId));  
			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	public Film findCategory(int filmId) {     // FINDS A FILM CATEGORY - ACCESSES THE DATABASE AND RETURNS FILM CATEGORIES    /// USER STORY 6
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "SELECT name FROM category JOIN film_category ON category_id = film_category.category_id "
					+ "JOIN film ON film_category.film_id = film.id WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film();
				film.setCategory(filmResult.getNString("name"));
			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public List<Film> findFilmByKeyword(String filmTitle) {     // // FINDS A FILM BY KEYWORD - ACCESSES THE DATABASE AND RETURNS FILM     USER STORY 5, THEN ROUTE TO UPDATE OR DELETE
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			String sql = "SELECT id, title, description, release_year, rating FROM film WHERE description LIKE ? OR title LIKE ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "%" + filmTitle + "%");
			stmt.setString(2, "%" + filmTitle + "%");

			ResultSet filmResult = stmt.executeQuery();

			while (filmResult.next()) {
				Film film = new Film();
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleasYear(filmResult.getInt("release_Year"));
				film.setRating(filmResult.getString("rating"));
				films.add(film);

			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {   // // FINDS ACTORS BY FILM - ACCESSES THE DATABASE AND RETURNS ACTORS BY FILM     //USER STORY 6
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name " + "FROM actor "
					+ "JOIN film_actor ON film_actor.actor_id = actor.id "
					+ "JOIN film ON film_actor.film_id = film.id " + "WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorResult = stmt.executeQuery();

			while (actorResult.next()) {
				Actor actor = new Actor();
				actor.setId(actorResult.getInt(1));
				actor.setFirstName(actorResult.getNString(2));
				actor.setLastName(actorResult.getNString(3));
				actors.add(actor);
			}

			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}
}

//	@Override
//	public Actor findActorById(int actorId) {   // NOT USED YET - CAN RETRIEVE FROM LAST WEEK'S GIT HUB
//		return null;
//	}
	
//	INSERT METHOD  --- MODIFY TO FIT PROJECT      CREATE ACTOR      /// MODIFY TO ADD FILM WITH ALL CATEGORIES    // USER STORY 4
	
//	public Actor createActor(Actor actor) {
//		  Connection conn = null;
//		  try {
//		    conn = DriverManager.getConnection(url, user, pass);
//		    conn.setAutoCommit(false); // START TRANSACTION
//		    String sql = "INSERT INTO actor (first_name, last_name) "
//		                     + " VALUES (?,?)";
//		    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//		    stmt.setString(1, actor.getFirstName());
//		    stmt.setString(2, actor.getLastName());
//		    int updateCount = stmt.executeUpdate();
//		    if (updateCount == 1) {
//		      ResultSet keys = stmt.getGeneratedKeys();
//		      if (keys.next()) {
//		        int newActorId = keys.getInt(1);
//		        actor.setId(newActorId);
//		        if (actor.getFilms() != null && actor.getFilms().size() > 0) {
//		          sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
//		          stmt = conn.prepareStatement(sql);
//		          for (Film film : actor.getFilms()) {
//		            stmt.setInt(1, film.getId());
//		            stmt.setInt(2, newActorId);
//		            updateCount = stmt.executeUpdate();
//		          }
//		        }
//		      }
//		    } else {
//		      actor = null;
//		    }
//		    conn.commit(); // COMMIT TRANSACTION
//		  } catch (SQLException sqle) {
//		    sqle.printStackTrace();
//		    if (conn != null) {
//		      try { conn.rollback(); }
//		      catch (SQLException sqle2) {
//		        System.err.println("Error trying to rollback");
//		      }
//		    }
//		    throw new RuntimeException("Error inserting actor " + actor);
//		  }
//		  return actor;
//		}
//
//	
//	
//	
////  UPDATE METHOD OR WHERE THE EDITING CAN HAPPEN  --- MODIFY TO FIT PROJECT - THIS ONE IS FOR ACTOR    NEED ONE FOR FILMS   /// USER STORY 4 & 5 
//	public boolean saveActor(Actor actor) {
//		  Connection conn = null;
//		  try {
//		    conn = DriverManager.getConnection(url, user, pass);
//		    conn.setAutoCommit(false); // START TRANSACTION
//		    String sql = "UPDATE actor SET first_name=?, last_name=? "
//		               + " WHERE id=?";
//		    PreparedStatement stmt = conn.prepareStatement(sql);
//		    stmt.setString(1, actor.getFirstName());
//		    stmt.setString(2, actor.getLastName());
//		    stmt.setInt(3, actor.getId());
//		    int updateCount = stmt.executeUpdate();
//		    if (updateCount == 1) {
//		      // Replace actor's film list
//		      sql = "DELETE FROM film_actor WHERE actor_id = ?";
//		      stmt = conn.prepareStatement(sql);
//		      stmt.setInt(1, actor.getId());
//		      updateCount = stmt.executeUpdate();
//		      sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
//		      stmt = conn.prepareStatement(sql);
//		      for (Film film : actor.getFilms()) {
//		        stmt.setInt(1, film.getId());
//		        stmt.setInt(2, actor.getId());
//		        updateCount = stmt.executeUpdate();
//		      }
//		      conn.commit();           // COMMIT TRANSACTION
//		    }
//		  } catch (SQLException sqle) {
//		    sqle.printStackTrace();
//		    if (conn != null) {
//		      try { conn.rollback(); } // ROLLBACK TRANSACTION ON ERROR
//		      catch (SQLException sqle2) {
//		        System.err.println("Error trying to rollback");
//		      }
//		    }
//		    return false;
//		  }
//		  return true;
//		}
//	
////  DELETE METHOD --- MODIFY TO FIT PROJECT          DO FOR 'FILMS'  SO THEY CAN DELETE -  BUT REMEBER THEY CAN ONLY DELETE FILES THEY ADDED    //// STORY  1/3 & 5
//	public boolean deleteActor(Actor actor) {
//		  Connection conn = null;
//		  try {
//		    conn = DriverManager.getConnection(url, user, pass);
//		    conn.setAutoCommit(false); // START TRANSACTION
//		    String sql = "DELETE FROM film_actor WHERE actor_id = ?";
//		    PreparedStatement stmt = conn.prepareStatement(sql);
//		    stmt.setInt(1, actor.getId());
//		    int updateCount = stmt.executeUpdate();
//		    sql = "DELETE FROM actor WHERE id = ?";
//		    stmt = conn.prepareStatement(sql);
//		    stmt.setInt(1, actor.getId());
//		    updateCount = stmt.executeUpdate();
//		    conn.commit();             // COMMIT TRANSACTION
//		  }
//		  catch (SQLException sqle) {
//		    sqle.printStackTrace();
//		    if (conn != null) {
//		      try { conn.rollback(); }
//		      catch (SQLException sqle2) {
//		        System.err.println("Error trying to rollback");
//		      }
//		    }
//		    return false;
//		  }
//		  return true;
//		}
//	
//	
	
//}


