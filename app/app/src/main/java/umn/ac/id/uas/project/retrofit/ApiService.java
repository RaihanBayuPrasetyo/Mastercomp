package umn.ac.id.uas.project.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    public static ApiEndpoint endpoint() {
//        Local "http://10.0.2.2:8000/api/"
//        Production "https://mastercomp.atras.my.id/api/"
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiEndpoint.class);
    }
}
