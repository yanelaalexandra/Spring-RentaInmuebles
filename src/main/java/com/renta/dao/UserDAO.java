package com.renta.dao;
import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;
import com.renta.model.User;
public class UserDAO {
	
	Employee findUser(int id) throws DAOException, EmptyResultException;

	void create(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	void update(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	User validate(String idUser, String password) throws LoginException, DAOException;

}
