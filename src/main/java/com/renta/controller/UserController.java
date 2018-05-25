package com.renta.controller;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.renta.model.User;
import com.renta.services.UserService;
   
/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
private static final Logger logger = Logger.getLogger(UserController.class);
	
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class.getName());
	
	public static int current_id_user;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private HttpSession httpSession;
	
	
	@GetMapping("/admin/menu")
	public String menu() {
		
		User usr = new User();
		return "/admin/menu";
	}
	
	
	
	@GetMapping("/admin/usr/perfil")
	public String perfil(ModelMap model) {

		User user = (User)httpSession.getAttribute("user");
		LOGGER.info("user:" + user);
		System.out.println("user: " + user);
		
		model.addAttribute("user", user);
		
		return "/admin/usr/perfil";
	}
	
	
	
	@GetMapping("/admin/usr/list")
	public String list(@ModelAttribute("SpringWeb") User user, ModelMap model) {

		try {
			model.addAttribute("user", userService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/usr/list";
	}
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{idusuario}")
	public ModelAndView home(@PathVariable int idusuario, ModelMap model) {

		ModelAndView modelAndView = null;
		User usr = new User();
		try {
			usr = userService.find(idusuario);
			logger.info(usr.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", usr);

		return modelAndView;
	}
	
	//---------------------------------------------------------------------------------------------------------------
	// Editar Usuario -- agregar boton o ruta
	
	@GetMapping("/admin/usr/editform")
	public ModelAndView form(@PathVariable int idusuario, ModelMap model) {
		idusuario = current_id_user;
		//logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			User usr = userService.find(idusuario);
			logger.info(usr.toString());
			modelAndView = new ModelAndView("admin/usr/editform", "command", usr);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/usr/editform", "command", new User());
		}

		return modelAndView;
	}
	
	@PostMapping("/admin/usr/editsave")
	public ModelAndView editsave(@ModelAttribute("SpringWeb") User usr, ModelMap model) {

		
		logger.info("usr = " + usr);
		
		ModelAndView modelAndView = null;

		try {
			userService.update(usr.getUsername(), usr.getPassword(), usr.getNombre(), usr.getApellido(),
					usr.getCorreo(),usr.getGenero(), usr.getDescripcion(), usr.getTipo_documento(), usr.getNumero_documento(),
					usr.getTelefono(), usr.getFoto());

			modelAndView = new ModelAndView("redirect:/admin/menu");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/menu");
		}

		return modelAndView;
	}
	

	//---------------------------------------------------------------------------------------------------------------
	// Crear Usuario
	
	
	@GetMapping("/admin/usr/createform")
	public String formCreate() {
		return "/admin/usr/createform";
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView createform(User usr, ModelMap model) {

				
		ModelAndView modelAndView = null;

		try {
			userService.create(usr.getUsername(), usr.getPassword(), usr.getNombre(), usr.getApellido(),
					usr.getCorreo(),usr.getGenero());

			modelAndView = new ModelAndView("redirect:/");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/");
		}

		return modelAndView;
	}
	
	
	
	
	
}


