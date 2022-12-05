package umn.ac.id.uas.project.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import umn.ac.id.uas.project.model.AuthenticationController;

public interface ApiEndpoint {
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("auth/login")
    Call<AuthenticationController> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("register/user")
    Call<AuthenticationController> registerUser(@Field("name") String name, @Field("email") String email, @Field("password") String password);
}
