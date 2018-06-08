package com.renta.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.User;
import com.renta.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	
	public User find(int idusuario) throws DAOException, EmptyResultException, IOException {
		User usr = userDAO.findUser(idusuario);
		return usr;
	}
	
	
	public List<User> findAll() throws DAOException, EmptyResultException {
		List<User> usrs = userDAO.findAllUsers();

		return usrs;
	}


	public void update(String username, String nombre, String apellido, String correo, String genero, String descripcion, int telefono)
			throws DAOException, IOException {
	userDAO.update( username,  nombre, apellido, correo, genero, descripcion,telefono);
		
	}


	public void create(String username, String password, String nombre, String apellido, String correo, String genero)
			throws DAOException, IOException {
	userDAO.create( username, password, nombre, apellido, correo, genero);
		
	}

}
