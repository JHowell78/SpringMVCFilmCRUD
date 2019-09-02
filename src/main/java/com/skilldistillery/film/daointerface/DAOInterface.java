package com.skilldistillery.film.daointerface;

import java.util.List;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;


	public interface DAOInterface {

		public Film findFilmById(int filmId);

		public Actor findActorById(int actorId);
		
		public Film findCategory(int filmID);

		public List<Actor> findActorsByFilmId(int filmId);

		public List<Film> findFilmByKeyword(String filmTitle);

		public Film createFilm(Film film);
		
		public boolean saveFilm(Film film);
		
		public boolean deleteFilm(Film film); 
		
		
	}
