package com.skilldistillery.film.filmController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.*;
import com.skilldistillery.film.daointerface.DAOInterface;
import com.skilldistillery.film.entities.*;

@Controller
public class FilmController {
	
	@Autowired
	private DAOInterface dao;
	
//	public DAOInterface getDao() {
//		return dao; 
//	}
//	
//	public void setDao(DAOInterface dao) {
//		this.dao = dao;
//	}
	
	@RequestMapping(path = "getFilmsID.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmByID(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.findFilmById(id);
		mv.addObject("filmById", film);
		mv.setViewName("WEB-INF/FindByID.jsp");
		return mv;
	}
	
	@RequestMapping(path = "getFilmsKeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(@RequestParam String keyword) {
		ModelAndView mv = new ModelAndView();
		List <Film> films = dao.findFilmByKeyword(keyword);
		mv.addObject("filmByKeyword", films);
		mv.setViewName("WEB-INF/FilmKeywordResult.jsp");
		return mv;
	}
	
	@RequestMapping(path = "ADDFILM.do", method = RequestMethod.POST)
	public String addFilm(Film film, RedirectAttributes redir) {
		dao.createFilm(film);
		redir.addFlashAttribute("filmAdd", film);
		return "redirect:ADDFILM.do"; 
	}
	
	
	@RequestMapping(path = "filmAdded.do", method = RequestMethod.GET)
	public ModelAndView filmAdded() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/DisplayYourNewFilm.jsp");
		return mv;
	}
}

//	GET      POST    PUT    DELETE       ---- PUT UPDATES

