package com.renta.retrofit;



import java.util.List;
import com.renta.model.Admin;
import com.renta.model.Inmueble;
import com.renta.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
	
	 String API_BASE_URL = "https://proyecto-inmuebles-synms.cs50.io";
	 
	 //LOGIN USER
	    @FormUrlEncoded
	    @POST("/api/v1/login")
	    Call<User> login( @Field("username") String username,
	                      @Field("password") String password);
	    
	  //LOGIN ADMIN  
	    @FormUrlEncoded
	    @POST("/api/v1/login_admin")
	    Call<Admin> loginAdmin( @Field("cod_admin") String cod_admin,
	    					    @Field("pas_admin") String pas_admin);
	    
	  //LISTAR INMUEBLES
	    @GET("/api/v1/inmuebles")
	    Call<List<Inmueble>> getInmuebles();
	    
	    
	    

}
