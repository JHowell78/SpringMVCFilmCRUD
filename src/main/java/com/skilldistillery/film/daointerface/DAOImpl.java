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
    public Film findFilmById(int filmId) { // FIND FILM BY ID - ACCESSES THE DATABASE AND RETURNS FILM //// USER STORY 1
        Film film = null;
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            String sql = "SELECT * FROM film WHERE film.id = ?";
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
                film.setLanguage(languageFromFilmID(film.getId()));
                film.setRentalDuration(filmResult.getInt("rental_duration"));
                film.setRental_rate(filmResult.getDouble("rental_rate"));
                film.setLength(filmResult.getInt("length"));
                film.setReplacement_cost(filmResult.getDouble("replacement_cost"));
                film.setRating(filmResult.getString("rating"));
                film.setSpecialFeatures(filmResult.getString("special_features"));
                film.setCategory(findCat(film.getId())); 
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
    public String findCat(int filmId) throws SQLException { 
        String cat = "";
        try { 
            Connection conn = DriverManager.getConnection(url, userName, password);
            String sql = "SELECT name FROM category JOIN film_category ON id = film_category.category_id JOIN film ON film_category.film_id = film.id WHERE film.id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, filmId);
            ResultSet catFromId = stmt.executeQuery();
            while (catFromId.next()) {
                cat = catFromId.getString("category.name");
            }
            conn.close();
            stmt.close();
            catFromId.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
            
            return cat;
    }
    public String languageFromFilmID(int filmId) throws SQLException {
        String language = "";
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            String sql = " SELECT film.language_id, language.name FROM film  JOIN language on film.language_id = language.id WHERE film.id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, filmId);
            ResultSet langFromId = stmt.executeQuery();
            while (langFromId.next()) {
                language = langFromId.getString("language.name");
            }
            conn.close();
            stmt.close();
            langFromId.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return language;
    }
    @Override
    public List<Film> findFilmByKeyword(String filmTitle) { // // FINDS A FILM BY KEYWORD - ACCESSES THE DATABASE AND
                                                            // RETURNS FILM USER STORY 5, THEN ROUTE TO UPDATE OR DELETE
        List<Film> films = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            String sql = "SELECT * FROM film WHERE description LIKE ? OR title LIKE ?";
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
                film.setLanguageId(filmResult.getInt("language_id"));
                film.setLanguage(languageFromFilmID(film.getId()));
                film.setRentalDuration(filmResult.getInt("rental_duration"));
                film.setRental_rate(filmResult.getDouble("rental_rate"));
                film.setLength(filmResult.getInt("length"));
                film.setReplacement_cost(filmResult.getDouble("replacement_cost"));
                film.setRating(filmResult.getString("rating"));
                film.setSpecialFeatures(filmResult.getString("special_features"));
                film.setCategory(findCat(film.getId())); 
                film.setActor(findActorsByFilmId(film.getId()));
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
    public List<Actor> findActorsByFilmId(int filmId) { // // FINDS ACTORS BY FILM - ACCESSES THE DATABASE AND RETURNS
                                                        // ACTORS BY FILM //USER STORY 6
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
    public Film createFilm(Film film) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
            conn.setAutoCommit(false); // START TRANSACTION
            String sql = "INSERT INTO film (title, " + "description, " + "release_year, " + "language_id, "
                    + "rental_duration, " + "rental_rate, " + "length, " + "replacement_cost, " + "rating, "
                    + "special_features) " + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleasYear());
            stmt.setInt(4, film.getLanguageId());
            stmt.setInt(5, film.getRentalDuration());
            stmt.setDouble(6, film.getRental_rate());
            stmt.setInt(7, film.getLength());
            stmt.setDouble(8, film.getReplacement_cost());
            stmt.setString(9, film.getRating());
            stmt.setString(10, film.getSpecialFeatures());
            int updateCount = stmt.executeUpdate();
            System.out.println(film);
            if (updateCount == 1) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    int newFilmId = keys.getInt(1);
                    film.setId(newFilmId);
                    updateCount = stmt.executeUpdate();
                }
            } else {
                film = null;
            }
            conn.commit(); // COMMIT TRANSACTION
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                }
                catch (SQLException sqle2) {
                    System.err.println("Error trying to rollback");
                }
            }
            throw new RuntimeException("Error inserting film " + film);
        }
        return film;
    }
    @Override
    public Actor findActorById(int actorId) {
        return null;
    }
    @Override
    public boolean saveFilm(Film film) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
            conn.setAutoCommit(false); // START TRANSACTION
            String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, rental_duration=?, "
                    + "rental_rate=?, length=?, replacement_cost=?, rating=?, " + " special_features=?, WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleasYear());
            stmt.setInt(4, film.getLanguageId());
            stmt.setInt(5, film.getRentalDuration());
            stmt.setDouble(6, film.getRental_rate());
            stmt.setInt(7, film.getLength());
            stmt.setDouble(8, film.getReplacement_cost());
            stmt.setString(9, film.getRating());
            stmt.setString(10, film.getSpecialFeatures());
            stmt.setInt(11, film.getId());
            int updateCount = stmt.executeUpdate();
            System.out.println("end of update code");
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, film.getId());
            updateCount = stmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } // ROLLBACK TRANSACTION ON ERROR
                catch (SQLException sqle2) {
                    System.err.println("Error trying to rollback");
                }
            }
            return false;
        } finally {
            try {
                conn.commit();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean deleteFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			int updateCount = stmt.executeUpdate();
			sql = "DELETE FROM film_category WHERE film_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();
			sql = "DELETE FROM film WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		} finally {
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
