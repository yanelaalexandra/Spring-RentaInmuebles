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

import com.renta.dao.AdminDAO;
import com.renta.dao.UserDAO;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;
import com.renta.model.Admin;
import com.renta.model.User;
import com.renta.services.SecurityService;


@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	private static final Logger LOGGER = LogManager.getLogger(LoginController.class.getName());
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	
	
	@Autowired
	private HttpSession httpSession;
	
	
	@GetMapping(value={"/", "home"})
	public String home() {		
		return "/home";
	}
	
	@GetMapping("/menu")
	public String menu() {		
		return "/menu";
	}
	
	@GetMapping("/login-type")
	public String prelogin() {		
		return "/logins/pre-login";
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------
	//LOGIN USUARIO	
	@GetMapping("/login-user")
	public ModelAndView LoginUser() {	
		User usr = new User();
		return new ModelAndView("/logins/login-user", "command", usr);
	}
	//--------------------------------------------------------------------------------------------------------------------------------------
		@PostMapping("/login-user")
		public ModelAndView login(@ModelAttribute("SpringWeb") User user, ModelMap model, HttpServletRequest request) {

			
			logger.info("login()");
			logger.info(user.toString());

			ModelAndView modelAndView = null;

			try {
							
				User usr = userDAO.validate(user.getUsername(), user.getPassword());
				if(usr != null) {
					httpSession.setAttribute("user", usr);			
					modelAndView = new ModelAndView("redirect:/user/home", "command", usr);
				}else {
					model.addAttribute("message", "Usuario y/o clave incorrectos");
					modelAndView = new ModelAndView("logins/login-user", "command", new User());
				}
				
							
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				model.addAttribute("message", "Usuario y/o clave incorrectos");
				modelAndView = new ModelAndView("redirect:/user/login-user", "command", new User());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("redirect:/user/login-user", "command", new User());
			} catch (Throwable e) {
				logger.error(e, e);
				model.addAttribute("message", "Usuario y/o clave incorrectos");
				modelAndView = new ModelAndView("redirect:/user/login-user", "command", new User());
			}

			return modelAndView;
		}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------
	//LOGIN ADMINISTRADOR
	@GetMapping("/login-admin")
	public ModelAndView preAdmin() {	
		Admin admin = new Admin();
		return new ModelAndView("/logins/login-admin", "command", admin);
	}

	
	//--------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping("/login-admin")
	public ModelAndView loginAdmin(@ModelAttribute("SpringWeb") Admin admin, ModelMap model, HttpServletRequest request) {

		
		logger.info("loginAdmin()");
		logger.info(admin.toString());

		ModelAndView modelAndView = null;

		try {
						
			Admin adm = adminDAO.validateLogin(admin.getCod_admin(), admin.getPas_admin());
			if(adm != null) {
				httpSession.setAttribute("admin", adm);			
				modelAndView = new ModelAndView("redirect:/admin/home", "command", adm);
			}else {
				model.addAttribute("message", "Usuario y/o clave incorrectos");
				modelAndView = new ModelAndView("logins/login-admin", "command", new Admin());
			}
			
		
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "Usuario y/o clave incorrectos");
			modelAndView = new ModelAndView("logins/login-admin", "command", new Admin());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "Usuario y/o clave incorrectos");
			modelAndView = new ModelAndView("logins/login-admin", "command", new Admin());
		} catch (Throwable e) {
			logger.error(e, e);
			model.addAttribute("message", "Usuario y/o clave incorrectos");
			modelAndView = new ModelAndView("logins/login-admin", "command", new Admin());
		}

		return modelAndView;
	}
	
	
	
	

	//--------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------
	// Crear Usuario
	
	@GetMapping("/register")
	public ModelAndView register() {
		User usr = new User();
		return new ModelAndView("/admin/usr/createform", "command", usr);
	}
	
	
	

}
