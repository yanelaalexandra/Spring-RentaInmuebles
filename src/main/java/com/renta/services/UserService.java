package com.renta.services;

import java.io.IOException;
import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.User;

public interface UserService {

	User find(int idusuario) throws DAOException, EmptyResultException, IOException;
	List<User> findAll() throws DAOException, EmptyResultException;
	
	void update(String username, String nombre, String apellido, String correo, String genero, String descripcion, int telefono)
	throws DAOException, IOException;
	
	void create(String username, String password, String nombre, String apellido, String correo, String genero)
	throws DAOException, IOException;
		
	
	
	
}
