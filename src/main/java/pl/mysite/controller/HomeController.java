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

import pl.mysite.entity.User;
import pl.mysite.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home () {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login () {
		return "login";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public void signIn (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		if ((Boolean)sess.getAttribute("logged")==true) {
			request.getRequestDispatcher("/userUI").forward(request, response); //userUI to g�owny panel u�ytkownika, doda� tam checki czy jest admninem
		}
		if (sess.isNew()) {
			sess.setAttribute("login", request.getParameter("login"));
			sess.setAttribute("password", request.getParameter("password"));
			sess.setAttribute("logged", false);
		}		
		User user = userRepo.findByLogin((String)sess.getAttribute("login"));
		if (user != null) {
			if (user.getPassword().equals(sess.getAttribute("password"))) {//Doda� zasolenie has�a
				sess.setAttribute("logged", true);
				request.getRequestDispatcher("/userUI").forward(request, response);
			} else {
				 request.getRequestDispatcher("/login").forward(request, response); //doda� error invalid login dynamicznie
			}
		}
	}
	
}
