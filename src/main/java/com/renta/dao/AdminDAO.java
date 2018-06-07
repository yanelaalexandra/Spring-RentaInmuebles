package com.renta.dao;

import java.io.IOException;

import com.renta.exception.DAOException;
import com.renta.exception.LoginException;
import com.renta.model.Admin;

public interface AdminDAO {
	
	//LOGIN Administrador
	Admin validateLogin(String cod_admin, String pas_admin) throws LoginException, DAOException, IOException;

}
