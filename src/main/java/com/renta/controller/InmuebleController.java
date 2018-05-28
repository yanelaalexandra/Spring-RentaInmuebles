package com.renta.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.renta.exception.DAOException;
import com.renta.model.Inmueble;
import com.renta.services.InmuebleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class InmuebleController {

	private static final Logger logger = LoggerFactory.getLogger(InmuebleController.class);

	@Autowired
	private InmuebleService inmuebleService;

	@Autowired
	private ApplicationContext context;

/*
	@GetMapping("/admin/usr/list")
	public String list(@ModelAttribute("inmueble") Inmueble inmueble, ModelMap model) { //list.jsp

		try {
			model.addAttribute("inmuebles", inmuebleService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/usr/list";
	}
*/
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{idinmueble}")
	public ModelAndView home(@PathVariable int idinmueble, ModelMap model) { //home.jsp

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

	//////////////////////////////////////////////////////////////////////////////////////
	// SHOW EDIT FORM OR DELETE FORM//
	//////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/admin/emp/{action}/{idinmueble}")
	public ModelAndView form(@PathVariable String action, @PathVariable int idinmueble, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Inmueble inm = inmuebleService.find(idinmueble);
			logger.info(inm.toString());
			modelAndView = new ModelAndView("admin/emp/" + action, "inmueble", inm);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/emp/" + action, "inmueble", new Inmueble());
		}

		return modelAndView;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// UPDATE //
	//////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/admin/emp/editsave")
	public ModelAndView editsave(@ModelAttribute("inmueble") @Valid Inmueble inm, BindingResult result,
			ModelMap model) {

		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			modelAndView = new ModelAndView("admin/emp/editform","inmueble", inm);
		} else {
			try {
				inmuebleService.update(inm.getDireccion(), inm.getCoordenadas(), inm.getImagen(), inm.getDescripcion(), inm.getTipo_costo(), inm.getCosto(), inm.getCapacidad_max(), inm.getTipo_inmueble(), inm.getEstado(), inm.getLatitud(), inm.getLongitud());
				modelAndView = new ModelAndView("redirect:/admin/usr/list");
				
			} catch (Exception e) {
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/emp/editform","inmueble", inm);
			}

		}

		return modelAndView;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// DELETE //
	//////////////////////////////////////////////////////////////////////////////////////

	@PostMapping("/admin/emp/delete")
	public ModelAndView delete(@ModelAttribute("inmueble") @Valid Inmueble inm, BindingResult result, ModelMap model) {

		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			modelAndView = new ModelAndView("admin/emp/deleteform/" + inm.getIdinmueble(), "inmueble", inm);
		} else {
			try {
				inmuebleService.delete(inm.getIdinmueble());
				modelAndView = new ModelAndView("redirect:/admin/usr/list");
			} catch (Exception e) {
				// model.addAttribute("message", e.getMessage());
				// modelAndView = new ModelAndView("redirect:/admin/emp/list");
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/emp/deleteform", "inmueble", inm);
			}
		}

		return modelAndView;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// CREATION //
	//////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/admin/emp/createform")
	public ModelAndView createform() {

		Inmueble inm = new Inmueble();

		ModelAndView modelAndView = new ModelAndView("admin/emp/createform", "inmueble", inm);

		return modelAndView;
	}

	@PostMapping("/admin/emp/create")
	public ModelAndView create(@ModelAttribute("inmueble") @Valid Inmueble inm, BindingResult result, ModelMap model) {


		ModelAndView modelAndView = null;

		if (result.hasErrors()) {

			logger.info("result.getAllErrors();= " + result.getAllErrors());

			for (ObjectError error : result.getAllErrors()) {
				String theMessage = context.getMessage(error.getCode(), error.getArguments(), Locale.US);
				logger.info(error.getCode() + " = " + theMessage);
			}

			modelAndView = new ModelAndView("admin/emp/createform", "inmueble", inm);

		} else {
			try {
				inmuebleService.create(inm.getDireccion(), inm.getCoordenadas(), inm.getImagen(), inm.getDescripcion(), inm.getTipo_costo(), inm.getCosto(), inm.getCapacidad_max(), inm.getTipo_inmueble(), inm.getEstado(), inm.getUsuarios_idusuarios(), inm.getRanking_idranking(), inm.getLatitud(), inm.getLongitud());
				logger.info("new Inmueble login = " + inm.getIdinmueble());
				modelAndView = new ModelAndView("redirect:/admin/usr/list");

			} catch (DAOException e) {
				logger.error(e.getMessage());
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/emp/createform", "inmueble", inm);
			}
		}
		//
		return modelAndView;
	}

}
