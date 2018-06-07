package com.renta.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.renta.services.InmuebleService;
import com.renta.services.UserService;

@Controller
public class AdminController {
	
private static final Logger LOGGER = LogManager.getLogger(LoginController.class.getName());
	
	public static int current_id_user;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private InmuebleService inmuebleService;

	@Autowired
	private ApplicationContext context;
	
	
	
	@GetMapping("/admin/home")
	public String menuAdmin() {
		return "/admin/menu_admin";
	}
	
	@GetMapping("/admin/menu")
	public String menuAdminInmuebles() {
		return "/admin/menu_inmuebles";
	}
	
	@GetMapping("/admin/usuarios")
	public String menuAdminUsuarios() {
		return "/admin/menu_usuarios";
	}
	
	

}
