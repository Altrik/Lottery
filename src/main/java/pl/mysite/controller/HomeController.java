package pl.mysite.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.mysite.entity.User;
import pl.mysite.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/indexR")
	public String home () {
		return "indexC";
	}
	
	@RequestMapping(value="/userUIPage", method=RequestMethod.POST)
	public String UI () {
		return "userUIPage";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public void login (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		if (!(sess.isNew())) {
			if ((Boolean)sess.getAttribute("logged")==true) {
				request.getRequestDispatcher("/userUIPage").forward(request, response); //userUI to g³owny panel u¿ytkownika, dodaæ tam checki czy jest admninem
			}
		}
		//sess.setAttribute("logged", false);	
		request.getRequestDispatcher("/indexR").forward(request, response);
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public void signIn (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		/*if (!(sess.isNew())) {
			if ((Boolean)sess.getAttribute("logged")==true) {
				request.getRequestDispatcher("Lottery/userUI").forward(request, response); //userUI to g³owny panel u¿ytkownika, dodaæ tam checki czy jest admninem
			}
		}*/
		sess.setAttribute("login", request.getParameter("login"));
		sess.setAttribute("password", request.getParameter("password"));
		sess.setAttribute("logged", false);
		User user = userRepo.findByLogin((String)sess.getAttribute("login"));
		if (user != null) {
			if (user.getPassword().equals(sess.getAttribute("password"))) {//Dodaæ zasolenie has³a
				sess.setAttribute("logged", true);
				request.getRequestDispatcher("/userUIPage").forward(request, response);
			} else {
				 request.getRequestDispatcher("/indexR").forward(request, response); //dodaæ error invalid login dynamicznie
			}
		}
		request.getRequestDispatcher("/indexR").forward(request, response);
	}
	
}
