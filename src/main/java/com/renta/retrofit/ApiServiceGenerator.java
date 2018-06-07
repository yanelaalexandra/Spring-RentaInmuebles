package com.renta.retrofit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGenerator {
	
	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiService.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit;


    public static <S> S createService(Class<S> serviceClass) {
        if(retrofit == null) {
            retrofit = builder.client(httpClient.build()).build();
            //Debug
            HttpLoggingInterceptor Logging = new HttpLoggingInterceptor();
            Logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(Logging);
        }
        return retrofit.create(serviceClass);
    }
	
	

}
