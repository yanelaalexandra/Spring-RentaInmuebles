package com.renta.services;

import java.io.IOException;

import com.renta.exception.DAOException;
import com.renta.exception.LoginException;
import com.renta.model.Admin;
import com.renta.model.User;

public interface SecurityService {
	
	User validate(String username, String password) throws LoginException, DAOException, IOException;
	
	Admin validateAdmin(String cod_admin, String pas_admin) throws LoginException, DAOException, IOException;
}
