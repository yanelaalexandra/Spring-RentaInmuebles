package com.renta.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renta.dao.AdminDAO;
import com.renta.dao.UserDAO;
import com.renta.exception.DAOException;
import com.renta.exception.LoginException;
import com.renta.model.Admin;
import com.renta.model.User;


@Service
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	public User validate(String username, String password) throws LoginException, DAOException, IOException {
		User usr = userDAO.validate(username, password);
		return usr;
	}

	@Override
	public Admin validateAdmin(String cod_admin, String pas_admin) throws LoginException, DAOException, IOException {
		Admin adm = adminDAO.validateLogin(cod_admin, pas_admin);
		return adm;
	}

}
