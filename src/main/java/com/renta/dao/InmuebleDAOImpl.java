package com.renta.dao;

import java.io.IOException;
import java.util.List;

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
import com.renta.retrofit.ApiService;
import com.renta.retrofit.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Response;

@Repository
public class InmuebleDAOImpl implements InmuebleDAO {

	private static final Logger logger = LoggerFactory.getLogger(InmuebleDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
		
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
	            logger.info("List Success!!!");
	            
	            return inmueble;
	            
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());
	        	return inmueble;
	      }
		
		
		

		/*try {

			List<Inmueble> inmuebles = ;
			//
			return inmuebles;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Inmueble findInmueble(int idinmueble) throws DAOException, EmptyResultException {
		String query = "SELECT idinmueble, direccion, coordenadas, imagen, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking, latitud, longitud "
				+ " FROM inmuebles WHERE idinmueble = ?" ;

		Object[] params = new Object[] { idinmueble };

		try {
			Inmueble inm = (Inmueble) jdbcTemplate.queryForObject(query, params, new InmuebleMapper());
			return inm;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
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
	public void delete(int idinmueble) throws DAOException {
		String query = "DELETE FROM  inmuebles WHERE idinmueble = ? ";

		Object[] params = new Object[] { idinmueble };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
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