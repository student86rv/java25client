package com.company.api;

import com.akadatsky.model.Post;
import com.company.model.SendPostResult;
import com.company.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface ApiService {

    @GET("get_all")
    Call<List<User>> getPosts();

    @POST("add")
    Call<String> sendPost(@Body User user);

}
