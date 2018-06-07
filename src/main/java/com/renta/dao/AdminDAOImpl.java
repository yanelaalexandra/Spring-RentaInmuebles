package com.renta.dao;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.renta.exception.DAOException;
import com.renta.exception.LoginException;
import com.renta.model.Admin;
import com.renta.retrofit.ApiService;
import com.renta.retrofit.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Response;


@Repository
public class AdminDAOImpl implements AdminDAO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);


	@Override
	public Admin validateLogin(String cod_admin, String pas_admin) throws LoginException, DAOException, IOException {
		 
		 logger.info("validate(): code: " + cod_admin + ", pass: " + pas_admin);
		
		
		 Response<Admin> response = null;
		 Admin admin= null;
		 
		 
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 Call<Admin> call = service.loginAdmin(cod_admin, pas_admin);
		 try {
				response=call.execute();
				logger.info("Esperando Respuesta...");
				
		 } catch (Exception e) {
				logger.info("Error en el servicio...");
				//logger.info("onError: " + response.errorBody().string());
	   						 		
		 }
		 
		//Validar respuesta exitosa
		 if (response.isSuccessful()) { 	
	            admin = response.body();
	            logger.info("Login success!!!");
	            return admin;
	      } else {	    	  
	        	logger.info("onError: " + response.errorBody().string());
	        	return admin;
	      }
		
	}

}
