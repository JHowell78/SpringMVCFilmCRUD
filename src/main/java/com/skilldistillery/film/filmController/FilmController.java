package com.skilldistillery.film.filmController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.daointerface.DAOInterface;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	public DAOInterface dao;

	@RequestMapping(path = "removeFilm.do", method = RequestMethod.POST)
	public String removeFilm(Film film, RedirectAttributes redir) {
		dao.deleteFilm(film);
		redir.addFlashAttribute("filmDelete", film);
		return "redirect:filmDeleteAdded.do";
	}

	@RequestMapping(path = "filmDeleteAdded.do", method = RequestMethod.GET)
	public ModelAndView filmDeleteAdded() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/DeleteFilm.jsp");
		return mv;
	}

//    @RequestMapping(path = "removeFilm.do", method = RequestMethod.POST)
//	public ModelAndView removeFilm(@RequestParam Film film) {
//		ModelAndView mv = new ModelAndView();
//		boolean filmRemoved = dao.deleteFilm(film);
//		if (filmRemoved) {
//			mv.setViewName("WEB-INF/DeleteFilm.jsp");
//		}
////		else {
////		mv.setViewName("WEB-INF/errorDeleted.jsp");
////	}
//	return mv;
//}
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
		List<Film> films = dao.findFilmByKeyword(keyword);
		mv.addObject("filmByKeyword", films);
		mv.setViewName("WEB-INF/FilmKeywordResult.jsp");
		return mv;
	}

	@RequestMapping(path = "ADDFILM.do", method = RequestMethod.POST)
	public String addFilm(Film film, RedirectAttributes redir) {
		dao.createFilm(film);
		redir.addFlashAttribute("filmAdd", film);
		return "redirect:filmAdded.do";
	}

	@RequestMapping(path = "filmAdded.do", method = RequestMethod.GET)
	public ModelAndView addFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/AddFilm.jsp");
		return mv;
	}
<<<<<<< HEAD

	@RequestMapping(path = "ModFilm.do", method = RequestMethod.POST)
	public String updateFilm(Film film, RedirectAttributes redir) {
		System.out.println(film);
		System.out.println(dao.saveFilm(film));
		film = dao.findFilmById(film.getId());
		redir.addFlashAttribute("filmAdd", film);
		return "redirect:filmEdit.do";
	}

	@RequestMapping(path = "filmEdit.do", method = RequestMethod.GET)
	public ModelAndView filmEdit() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/filmAddedjsp");
=======
	
	@RequestMapping(path = "editedFilm.do", method = RequestMethod.POST)
	public String updateFilm(Film film, RedirectAttributes redir) {
		dao.saveFilm(film);
		redir.addFlashAttribute("filmAdd", film);
		return "redirect:filmAdded.do";
	}
	
//	@RequestMapping(path = "filmEditAdded.do", method = RequestMethod.GET)
//	public ModelAndView filmEditAdded() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("WEB-INF/FilmAdded.jsp");
//		return mv;
//	}
	
	@RequestMapping(path = "UPDATEFILM.do", method = RequestMethod.GET)
	public ModelAndView filmUpdated(Film film) {
		ModelAndView mv = new ModelAndView();
		film = dao.findFilmById(film.getId());
//		mv.addObject("allRatings", allRatings);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/ModifyFilm.jsp");
>>>>>>> c13012e5fc69df1df18fedeb18e15eed21c1c8af
		return mv;
	}
}
	
	
	
	
	
	
	
//	@RequestMapping(path = "filmEdit.do", method = RequestMethod.GET)
//	public ModelAndView filmEdit() { 
//	    ModelAndView mv = new ModelAndView();
//	    mv.setViewName("WEB-INF/filmAddedjsp");
//	    return mv;
//	}
//}
//
//
//@RequestMapping(path = "filmEditAdded.do", method = RequestMethod.GET)
//public ModelAndView filmEditAdded() {
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("WEB-INF/FilmAdded.jsp");
//    return mv;
//}
//
//@RequestMapping(path = "UPDATEFILM.do", method = RequestMethod.GET)
//public ModelAndView filmUpdated(Film film) {
//    ModelAndView mv = new ModelAndView();
//    film = dao.findFilmById(film.getId());
//    mv.addObject("film", film);
//    mv.setViewName("WEB-INF/CRUD.jsp");
//    return mv;

//	GET      POST    PUT    DELETE       ---- PUT UPDATES
