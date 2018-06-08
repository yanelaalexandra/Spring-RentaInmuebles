package com.renta.dao;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.renta.dao.UserDAOImpl;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.ErrorAPI;
import com.renta.exception.LoginException;
import com.renta.maper.UserMapper;
import com.renta.model.Admin;
import com.renta.model.ResponseMessage;
import com.renta.model.User;
import com.renta.retrofit.ApiService;
import com.renta.retrofit.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	static ErrorAPI error = new ErrorAPI();
	
	
	@Autowired
	private HttpSession httpSession;
	
	//======================================================================================================================================-
	//======================================================================================================================================
		// Login User Retrofit
	//======================================================================================================================================
    //======================================================================================================================================
	
	public User validate(String username, String password) throws LoginException, DAOException, IOException {
		
		logger.info("validate(): login: " + username + ", clave: " + password);
		
			
		 Response<User> response = null;
		 User user = null;
		 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<User> call = service.login(username, password);
		 try {
				response=call.execute();
				logger.info("Esperando Respuesta...");
				
		 } catch (Exception e) {
				logger.info("Error en el servicio...");
				logger.info("onError: " + response.errorBody().string());
	   						 		
		 }
		 
		 //Validar respuesta exitosa
		 if (response.isSuccessful()) { 	
	            user = response.body();
	            logger.info("Login success!!!");
	            return user;
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());
	        	error.setMessage(response.errorBody().string());
	        	return user;
	      }
		 
			 
		 
	}
	
	
	//======================================================================================================================================-
	//======================================================================================================================================
		// Encontrar Usuario por ID
	//======================================================================================================================================
    //======================================================================================================================================
	
	public User findUser(int idusuario) throws DAOException, EmptyResultException, IOException {
				
		 Response<User> response = null;
		 User user = null;
		 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<User> call = service.perfil(idusuario);
		 try {
				response=call.execute();
				logger.info("Esperando Respuesta...");
				
		 } catch (Exception e) {
				logger.info("Error en el servicio...");
				logger.info("onError: " + response.errorBody().string());
	   						 		
		 }
		 
		 //Validar respuesta exitosa
		 if (response.isSuccessful()) { 	
	            user = response.body();
	            logger.info("Find User success!!!");
	            return user;
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());
	        	error.setMessage(response.errorBody().string());
	        	return user;
	      }
		
	}

	//======================================================================================================================================-
	//======================================================================================================================================
		// Creando nuevo Usuario 
	//======================================================================================================================================
	//======================================================================================================================================

	public void create(String username, String password, String nombre, String apellido, String correo, String genero) throws DAOException, IOException {
			
		 Response<ResponseMessage> response = null;
		 ResponseMessage responseMessage= null;
		 	 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<ResponseMessage> call = service.createUser(username, password, nombre, apellido, correo, genero);
		 
		 try {
				response=call.execute();
				logger.info("Esperando Respuesta...");
				
		 } catch (Exception e) {
				logger.info("Error en el servicio...");
				logger.info("onError: " + response.errorBody().string());
	   						 		
		 }
		 
		//Validar respuesta exitosa
		 if (response.isSuccessful()) { 	
	            responseMessage = response.body();
	            logger.info("Create success!!!");
	            logger.info("Message: "+responseMessage);
	           
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());

	     }
		

	}
	
	//======================================================================================================================================-
	//======================================================================================================================================
		// Actualizando info Usuario 
	//======================================================================================================================================
	//======================================================================================================================================	
	
	public void update(String username, String nombre, String apellido, String correo, String genero,
			String descripcion, int telefono) throws DAOException, IOException {

		 Response<ResponseMessage> response = null;
		 ResponseMessage responseMessage= null;
		 	 
		 
		 User usr = (User)httpSession.getAttribute("user");
		 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<ResponseMessage> call = service.updateUser(usr.getIdusuario(), username, nombre, apellido, correo, genero, descripcion, telefono);
		 
		 try {
				response=call.execute();
				logger.info("Esperando Respuesta...");
				
		 } catch (Exception e) {
				logger.info("Error en el servicio...");
				logger.info("onError: " + response.errorBody().string());
	   						 		
		 }
		 
		//Validar respuesta exitosa
		 if (response.isSuccessful()) { 	
	            responseMessage = response.body();
	            logger.info("Update success!!!");
	            logger.info("Message: "+responseMessage);
	           
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());

	      }
	}
	
	
	
	
	
	
	
	
	
	
	


	public void delete(String username) throws DAOException {

		String query = "DELETE FROM  usuarios WHERE username = ? ";

		Object[] params = new Object[] { username};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	
	public User finUserByUsername(String username, String password) throws DAOException, EmptyResultException {
		String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero "
				+ " FROM usuarios WHERE username = ? ";

		Object[] params = new Object[] { username, password};

		try {

			User user = jdbcTemplate.queryForObject(query, params, new UserMapper());
			//
			return user;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	
	public List<User> findAllUsers() throws DAOException, EmptyResultException {

		String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero FROM usuarios ";

		try {

			List<User> users = jdbcTemplate.query(query, new UserMapper());
			//
			return users;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	

	public List<User> findUserByNombre(String nombre) throws DAOException, EmptyResultException {
		
		String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero "
					+ " FROM usuarios WHERE upper(nombre) like upper(?) ";
	
			Object[] params = new Object[] { "%" + nombre + "%" };
	
			try {
	
				List<User> users = jdbcTemplate.query(query, params, new UserMapper());
				//
				return users;
	
			} catch (EmptyResultDataAccessException e) {
				throw new EmptyResultException();
			} catch (Exception e) {
				logger.info("Error: " + e.getMessage());
				throw new DAOException(e.getMessage());
			}
	}



	public User ConsultaUser(String username, String password) throws DAOException,EmptyResultException {
		String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero "
				+ " FROM usuarios WHERE username = ? AND password =? ";

		Object[] params = new Object[] { username, password};

		try {

			User user = jdbcTemplate.queryForObject(query, params, new UserMapper());
			//
			return user;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}


	


}
