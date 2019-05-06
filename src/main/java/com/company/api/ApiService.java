package com.company.api;

import com.company.model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ApiService {

    @GET("get_all")
    Call<List<User>> getAll();

    @GET("get/{id}")
    Call<User> get(@Path("id") int id);

    @GET("get_by_name/{name}")
    Call<User> getByName(@Path("name") String name);

    @GET("get_by_age/{from_age}/{to_age}")
    Call<List<User>> getByAge(@Path("from_age") int fromAge, @Path("to_age") int toAge);

    @POST("add")
    Call<ResponseBody> add(@Body User user);

    @PUT("update")
    Call<ResponseBody> update(@Body User user);

    @PUT("remove")
    Call<ResponseBody> remove(@Body User user);
}
