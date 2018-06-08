package com.renta.retrofit;



import java.util.List;
import com.renta.model.Admin;
import com.renta.model.Inmueble;
import com.renta.model.ResponseMessage;
import com.renta.model.User;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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
	    
	    
	   //CREATE USER  
	    @FormUrlEncoded
	    @POST("/api/v1/usuarios")
	    Call<ResponseMessage> createUser(@Field("username")   String username,
	                                     @Field("password")   String password,
	                                     @Field("nombre")     String nombre,
	                                     @Field("apellido")   String apellido,
	                                     @Field("correo")     String correo,
	                                     @Field("genero")     String genero);
	    
	    
	   //PERFIL 
        @GET("/api/v1/usuarios/{idusuario}")
	    Call<User> perfil( @Path("idusuario") int idusuario);
        
        
        //UPDATE USER 
        @FormUrlEncoded
        @PUT("/api/v1/usuarios/{idusuario}")
        Call<ResponseMessage> updateUser(   @Path("idusuario")   int idusuario,
        								    @Field("username")    String username,
        									@Field("nombre")      String nombre,
        									@Field("apellido")    String apellido,
        									@Field("correo")      String correo,
							        		@Field("genero")      String genero,
							        		@Field("descripcion") String descripcion,
							        		@Field("telefono")    int telefono);
    
       		
	    //LISTAR INMUEBLES
		@GET("/api/v1/inmuebles")
		Call<List<Inmueble>> getInmuebles();
		
	    //DETALLES INMUEBLE
		@GET("/api/v1/inmuebles/{idinmueble}")
		Call<Inmueble> getDetailInmueble( @Path("idinmueble")  int idinmueble);
		
		
		//MIS INMUEBLES
		@GET("/api/v1/misinmuebles/{idusuario}")
	    Call<List<Inmueble>> getMisInmuebles( @Path("idusuario") int idusuario);
		
		
		//VER PROPIETARIO DEL INMUEBLE
		@GET("/api/v1/propietario/{idinmueble}")
	    Call<User> getPropietario( @Path("idinmueble") int idinmueble);

		//BORRAR USUARIO
		@DELETE("/api/v1/inmuebles/{idinmueble}")
		Call<ResponseMessage> deleteInmueble(@Path("idinmueble") int idinmueble);
	    
	    


}
