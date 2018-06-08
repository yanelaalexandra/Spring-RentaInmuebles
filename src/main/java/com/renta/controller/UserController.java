package com.renta.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.renta.dao.InmuebleDAO;
import com.renta.dao.UserDAO;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.Admin;
import com.renta.model.Inmueble;
import com.renta.model.ResponseMessage;
import com.renta.model.User;
import com.renta.retrofit.ApiService;
import com.renta.retrofit.ApiServiceGenerator;
import com.renta.services.InmuebleService;
import com.renta.services.UserService;

import retrofit2.Call;
import retrofit2.Response;
   
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
	private UserDAO userDAO;
	
	@Autowired
	private InmuebleDAO inmuebleDAO;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private InmuebleService inmuebleService;

	@Autowired
	private ApplicationContext context;
	
	
	
	@GetMapping("/user/home")
	public String menuUser(ModelMap model) {
		return "/user/menu_user";
	}
	
	
	//======================================================================================================================================-
	//======================================================================================================================================
		// Usuario All Inmuebles
	//======================================================================================================================================
	//======================================================================================================================================	

		@GetMapping("/user/menu")
		public String UserlistInmuebles(@ModelAttribute("SpringWeb") Inmueble inmueble, ModelMap model) {
					
			try {				
				model.addAttribute("inmuebles", inmuebleDAO.findAllInmuebles());
				
			} catch (DAOException | EmptyResultException | IOException e) {
				
				e.printStackTrace();
			}
			 	
			return "/user/menu_inmuebles";
		}
	
	
	//======================================================================================================================================-
	//======================================================================================================================================
		// Listar Mis Inmuebles
	//======================================================================================================================================
	//======================================================================================================================================	

		@GetMapping("/user/menu-inmuebles")
		public String listInmuebles(@ModelAttribute("SpringWeb") Inmueble inmueble, ModelMap model) {
					
			try {
				User user = (User)httpSession.getAttribute("user");
				int id = user.getIdusuario();
				
				model.addAttribute("MisInmuebles", inmuebleDAO.findUserInmuebles(id));
				
			} catch (DAOException | EmptyResultException | IOException e) {
				
				e.printStackTrace();
			}
			 	
			return "/user/menu_mis_inmuebles";
		}
	

		
	//======================================================================================================================================-
	//======================================================================================================================================
		// Ver Perfil
	//======================================================================================================================================
	//======================================================================================================================================	
	
		@GetMapping("/user/perfil")
		public String perfil(ModelMap model) throws Exception {
	
			User user = (User)httpSession.getAttribute("user");
			int id = user.getIdusuario();
			
			User usr = userDAO.findUser(id);
			
			LOGGER.info("user:" + user);
			System.out.println("user: " + usr);
			
			model.addAttribute("user", usr);
			
			return "/user/menu_perfil";
		}
	

	//======================================================================================================================================-
	//======================================================================================================================================
		// Editar Usuario
	//======================================================================================================================================
	//======================================================================================================================================
		
		@GetMapping("/usuario/editar")
		public ModelAndView form(ModelMap model) {		
			//logger.info("action = " + action);
			ModelAndView modelAndView = null;
				
			try {
				
				User user = (User)httpSession.getAttribute("user");
				User usr = userDAO.findUser(user.getIdusuario());				
				logger.info(usr.toString());
				
				modelAndView = new ModelAndView("user/menu_perfil_editar", "command", usr);
			} catch (Exception e) {
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/usr/editform", "command", new User());
			}

			return modelAndView;
		}
		
		
		
		@RequestMapping(value = "/editsave", method = RequestMethod.POST)
		public ModelAndView editsave(@ModelAttribute("SpringWeb") User usr, ModelMap model) throws DAOException, EmptyResultException, IOException {
		
			ModelAndView modelAndView = null;
			
		
			
			try {
				userDAO.update(usr.getUsername(), usr.getNombre(), usr.getApellido(),
								   usr.getCorreo(), usr.getGenero(), usr.getDescripcion(), 
								   usr.getTelefono());
				
				User usrActual = userDAO.findUser(usr.getIdusuario());			
				httpSession.setAttribute("user", usrActual);				
				model.addAttribute("user", usrActual);		
				
				modelAndView = new ModelAndView("redirect:/user/home");
							
			} catch (Exception e) {
				
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("redirect:/usuario/editar");
			}

			return modelAndView;
		}
	


	//======================================================================================================================================-
	//======================================================================================================================================
		// Crear Usuario
	//======================================================================================================================================
	//======================================================================================================================================
	
			@GetMapping("user/register")
			public ModelAndView register() {
				User usr = new User();
				return new ModelAndView("/user/menu_crear", "command", usr);
				
			}
			
					
			@RequestMapping(value = "user/save", method = RequestMethod.POST)
			public ModelAndView createform(User usr, ModelMap model) {
									 
				ModelAndView modelAndView = null;
		
				try {
							
					userService.create(usr.getUsername(), usr.getPassword(), usr.getNombre(), usr.getApellido(),
							           usr.getCorreo(),usr.getGenero());
		
					modelAndView = new ModelAndView("redirect:/login-user");
				} catch (Exception e) {
					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("redirect:/login-user");
				}
		
				return modelAndView;
										
			}
		
		
		
		//======================================================================================================================================	
		
		/*@GetMapping("/user/perfil")
		public String perfilAdmin(ModelMap model) throws Exception {
			User usr = new User();
			return "/user/forms/perfil";
		}*/
		
		@GetMapping("/admin/usr/list")
		public String list(@ModelAttribute("inmueble") Inmueble inmueble, ModelMap model) {

			try {
				model.addAttribute("inmuebles", inmuebleService.findAll());
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
		
		
		
		

	
	
	
	
}


