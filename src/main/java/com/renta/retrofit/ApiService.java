package com.renta.retrofit;


import com.renta.model.Admin;
import com.renta.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
	
	 String API_BASE_URL = "https://proyecto-inmuebles-synms.cs50.io";
	 
	    @FormUrlEncoded
	    @POST("/api/v1/login")
	    Call<User> login( @Field("username") String username,
	                      @Field("password") String password);
	    
	    @FormUrlEncoded
	    @POST("/api/v1/login_admin")
	    Call<Admin> loginAdmin( @Field("cod_admin") String cod_admin,
	    					    @Field("pas_admin") String pas_admin);

}
