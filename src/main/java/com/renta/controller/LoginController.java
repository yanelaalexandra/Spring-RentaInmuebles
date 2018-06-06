package com.renta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.renta.dao.UserDAO;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;
import com.renta.model.User;
import com.renta.services.SecurityService;


/**
 *  Login para usuario
 */
@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	private static final Logger LOGGER = LogManager.getLogger(LoginController.class.getName());
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private HttpSession httpSession;
	

/*	
	@GetMapping("/")
	public String menu() {

		return "/login";
	}
*/
	
	//@GetMapping("/login")
	
	@GetMapping(value={"/", "home"})
	public String home() {		
		return "/home";
	}
	
	
	@GetMapping("/login")
	public ModelAndView preLogin() {
		logger.info("preLogin()");
		LOGGER.info("preLogin()");
		
		User usr = new User();
		return new ModelAndView("login", "command", usr);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("SpringWeb") User user, ModelMap model, HttpServletRequest request) {

		
		logger.info("login()");
		logger.info(user.toString());

		ModelAndView modelAndView = null;

		try {
			User usr = securityService.validate(user.getUsername(), user.getPassword());
			logger.info(usr.toString());
			logger.info("mesasge");
			logger.info(httpSession);
			
			httpSession.setAttribute("user", usr);
			LOGGER.info("user 2" + usr);
			
			modelAndView = new ModelAndView("redirect:/admin/menu", "command", usr);
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "Usuario y/o clave incorrectos");
			modelAndView = new ModelAndView("login", "command", new User());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("login", "command", new User());
		} catch (Throwable e) {
			logger.error(e, e);
		}

		return modelAndView;
	}
	//---------------------------------------------------------------------------------------------------------------
	// Crear Usuario
	
	@GetMapping("/register")
	public ModelAndView register() {
		User usr = new User();
		return new ModelAndView("/admin/usr/createform", "command", usr);
	}
	
	
	

}
