package com.renta.dao;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.maper.InmuebleMapper;
import com.renta.model.Admin;
import com.renta.model.Inmueble;
import com.renta.model.ResponseMessage;
import com.renta.model.User;
import com.renta.retrofit.ApiService;
import com.renta.retrofit.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Response;

@Repository
public class InmuebleDAOImpl implements InmuebleDAO {

	private static final Logger logger = LoggerFactory.getLogger(InmuebleDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
		
	//======================================================================================================================================-
     //======================================================================================================================================
		// Listar Inmuebles
	//======================================================================================================================================
	//======================================================================================================================================
	@Override
	public List<Inmueble> findAllInmuebles() throws DAOException, EmptyResultException, IOException {
		
		 Response<List<Inmueble>> response = null;
		 List<Inmueble> inmueble= null;
	 		 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<List<Inmueble>> call = service.getInmuebles();
		 
		 try {
				response=call.execute();
				logger.info("Esperando Respuesta...");
				
		 } catch (Exception e) {
				logger.info("Error en el servicio...");
				logger.info("onError: " + response.errorBody().string());
	   						 		
		 }
		 
		//Validar respuesta exitosa
		 if (response.isSuccessful()) { 
			 
	            inmueble = response.body();
	            logger.info("Inmuebles List Success!!!");
	            
	            return inmueble;
	            
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());
	        	return inmueble;
	      }
	
	}
	
	//======================================================================================================================================-
	//======================================================================================================================================
		// Listar Mis Inmuebles
	//======================================================================================================================================
	//======================================================================================================================================
	
	@Override
	public List<Inmueble> findUserInmuebles(int idusuario) throws DAOException, EmptyResultException, IOException {
		
		 Response<List<Inmueble>> response = null;
		 List<Inmueble> inmueble= null;
	 		 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<List<Inmueble>> call = service.getMisInmuebles(idusuario);
		 
		 try {
				response=call.execute();
				logger.info("Esperando Respuesta...");
				
		 } catch (Exception e) {
				logger.info("Error en el servicio...");
				logger.info("onError: " + response.errorBody().string());
	   						 		
		 }
		 
		//Validar respuesta exitosa
		 if (response.isSuccessful()) { 
			 
	            inmueble = response.body();
	            logger.info("My Inmuebles List Success!!!");
	            
	            return inmueble;
	            
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());
	        	return inmueble;
	      }
	}

	
	//======================================================================================================================================-
	//======================================================================================================================================
		// Detalles
	//======================================================================================================================================
	//======================================================================================================================================	
	
		
	@Override
	public Inmueble findInmueble(int idinmueble) throws DAOException, EmptyResultException, IOException {

		 Response<Inmueble> response = null;
		 Inmueble inmueble= null;
	 		 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<Inmueble> call = service.getDetailInmueble(idinmueble);
		 
		 try {
				response=call.execute();
				logger.info("Esperando Respuesta...");
				
		 } catch (Exception e) {
				logger.info("Error en el servicio...");
				logger.info("onError: " + response.errorBody().string());	   						 		
		 }
		 
		//Validar respuesta exitosa
		 if (response.isSuccessful()) { 
			 
	            inmueble = response.body();
	            logger.info("Detalles List Success!!!");
	            
	            return inmueble;
	            
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());
	        	return inmueble;
	      }
		
	}
	
	//======================================================================================================================================-
	//======================================================================================================================================
		// Propietario
	//======================================================================================================================================
	//======================================================================================================================================	
	
	
	@Override
	public User findPropietario(int idinmueble) throws DAOException, EmptyResultException, IOException {
		
		 Response<User> response = null;
		 User user = null;
		 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<User> call = service.getPropietario(idinmueble);
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
	            logger.info("Find Owner success!!!");
	            return user;
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());	        	
	        	return user;
	      }
	}
	
	
	//======================================================================================================================================-
	//======================================================================================================================================
		// DELETE
	//======================================================================================================================================
	//======================================================================================================================================	
	
	@Override
	public void delete(int idinmueble) throws DAOException, IOException {
		
		 Response<ResponseMessage> response = null;
		 ResponseMessage responseMessage;	 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<ResponseMessage> call = service.deleteInmueble(idinmueble);
		 
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
	            logger.info("Delete Inmueble success!!!");
	            
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());	        	
	 
	      }
		
	}
	
	
	
	
	
	
	
	
	

	
	//======================================================================================================================================-

	
	
	
	@Override	
	public void create(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo,
			double costo, String capacidad_max, String tipo_inmueble, int estado, int usuarios_idusuarios, int ranking_idranking,
			String latitud, String longitud)
			throws DAOException {

		String query = "INSERT INTO inmuebles (direccion, coordenadas, imagen, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking, latitud, longitud)  VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,? )";

		Object[] params = new Object[] { direccion, coordenadas, imagen, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking, latitud, longitud };

		
		try {
			// create
			jdbcTemplate.update(query, params);

		} catch (Exception e) {
			//logger.error("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	
	

	
	
	@Override
	public void update(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo,
			double costo, String capacidad_max, String tipo_inmueble, int estado, String latitud, String longitud)
			throws DAOException {
		String query = "UPDATE inmuebles SET direccion = ?, coordenadas =?, imagen = ?, descripcion = ?, tipo_costo = ?, costo = ?, capacidad_max = ?, tipo_inmueble = ?, estado = ?, latitud = ?, longitud = ? WHERE direccion = ?";

		Object[] params = new Object[] { direccion, coordenadas, imagen, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, latitud, longitud };

		
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}
	
	@Override
	public Inmueble findInmuebleByDireccion(String direccion) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		String query = "SELECT idinmueble, direccion, coordenadas, imagen, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking, latitud, longitud "
				+ " FROM inmuebles WHERE direccion = ? ";

		Object[] params = new Object[] { direccion };

		try {

			Inmueble inmueble = jdbcTemplate.queryForObject(query, params, new InmuebleMapper());
			//
			return inmueble;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	























	
	


}