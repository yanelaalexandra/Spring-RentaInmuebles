package com.renta.controller;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.renta.model.Inmueble;
import com.renta.model.User;
import com.renta.services.InmuebleService;
import com.renta.services.UserService;
   
/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private InmuebleService inmuebleService;
	
	
	@GetMapping("/admin/menu")
	public String menu() {

		return "/admin/menu";
	}
	
	
	@GetMapping("/admin/usr/list")
	public String list(@ModelAttribute("SpringWeb") Inmueble inmueble, ModelMap model) {

		try {
			model.addAttribute("inmueble", inmuebleService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/usr/list";
	}
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{user_id}")
	public ModelAndView home(@PathVariable int idinmueble, ModelMap model) {

		ModelAndView modelAndView = null;
		Inmueble inm = new Inmueble();
		try {
			inm = inmuebleService.find(idinmueble);
			logger.info(inm.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", inm);

		return modelAndView;
	}
	
	@GetMapping("/admin/usr/{action}/{user_id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int idinmueble, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Inmueble inm = inmuebleService.find(idinmueble);
			logger.info(inm.toString());
			modelAndView = new ModelAndView("admin/usr/" + action, "command", inm);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/usr/" + action, "command", new Inmueble());
		}

		return modelAndView;
	}
	
	@PostMapping("/admin/usr/editsave")
	public ModelAndView editsave(@ModelAttribute("SpringWeb") Inmueble inm, ModelMap model) {

		
		logger.info("inm = " + inm);
		
		ModelAndView modelAndView = null;

		try {
			inmuebleService.update(inm.getDireccion(), inm.getCoordenadas_dic(), inm.getFoto(), inm.getDescripcion(),
					inm.getTipo_costo(),inm.getCosto(), inm.getCapacidad_max(), inm.getTipo_inmueble(), inm.getEstado(),
					inm.getUsuarios_idusuario(), inm.getRanking_idranking());

			modelAndView = new ModelAndView("redirect:/admin/usr/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/usr/list");
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
	public ModelAndView createform(Inmueble inm, ModelMap model) {

				
		ModelAndView modelAndView = null;

		try {
			inmuebleService.create(inm.getDireccion(), inm.getCoordenadas_dic(), inm.getFoto(), inm.getDescripcion(),
					inm.getTipo_costo(),inm.getCosto(), inm.getCapacidad_max(), inm.getTipo_inmueble(), inm.getEstado(),
					inm.getUsuarios_idusuario(), inm.getRanking_idranking());

			modelAndView = new ModelAndView("redirect:/");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/");
		}

		return modelAndView;
	}
	
}


