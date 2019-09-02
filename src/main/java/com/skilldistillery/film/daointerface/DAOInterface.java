package com.skilldistillery.film.daointerface;

import java.sql.SQLException;
import java.util.List;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;


    public interface DAOInterface {

        public Film findFilmById(int filmId);

<<<<<<< HEAD
		public Actor findActorById(int actorId);
		
		public List<Actor> findActorsByFilmId(int filmId);

		public List<Film> findFilmByKeyword(String filmTitle);

		public Film createFilm(Film film);
		
		public boolean saveFilm(Film film);
		
		public boolean deleteFilm(Film film); 
		
		public String findCat(int filmId) throws SQLException;
		
		public String languageFromFilmID(int filmId) throws SQLException;
		
		
	}
=======
        public Actor findActorById(int actorId);
        
        public List<Actor> findActorsByFilmId(int filmId);

        public List<Film> findFilmByKeyword(String filmTitle);

        public Film createFilm(Film film);
        
        public boolean saveFilm(Film film);
        
        public boolean deleteFilm(Film film); 
        
        public String findCat(int filmId) throws SQLException;
        
        public String languageFromFilmID(int filmId) throws SQLException;
        
        
    }
>>>>>>> 27bb113b7dde2d03af1838afcc1c7faadbaf5e9f
