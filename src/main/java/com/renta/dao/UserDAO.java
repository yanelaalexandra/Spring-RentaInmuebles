package com.renta.dao;

import java.io.IOException;
import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;
import com.renta.model.Admin;
import com.renta.model.User;

public interface UserDAO {
	
	
	//LOGIN - Retrofit 
	User validate(String username, String password) throws LoginException, DAOException, IOException;
	
	//FIND ID - Retrofit
	User findUser(int idusuario) throws DAOException, EmptyResultException, IOException;
	
	//CREATE - Retrofit
	void create(String username, String password, String nombre, String apellido, String correo, String genero) throws DAOException, IOException;

	//UPDATE - Retrofit
	void update(String username, String nombre, String apellido, String correo, String genero, String descripcion, int telefono) throws DAOException, IOException;	
	
	
	
	
	
	void delete(String username) throws DAOException;

	
	User finUserByUsername(String Username, String password) throws DAOException, EmptyResultException;

	List<User> findAllUsers() throws DAOException, EmptyResultException;

	List<User> findUserByNombre(String nombre) throws DAOException, EmptyResultException;

	
	
	User ConsultaUser(String username, String password) throws  DAOException, EmptyResultException;

	}
