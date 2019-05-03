package com.company;

import com.company.api.ApiManager;
import com.akadatsky.model.Post;
import com.company.model.SendPostResult;
import com.company.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        requestPosts();
        sendPost();
    }

    private static void requestPosts() {
        ApiManager.getApiService().getPosts().enqueue(new Callback<List<User>>() {
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                if (users != null) {
                    System.out.println("posts.size: " + users.size());
                    System.out.println(users);
                }
            }

            public void onFailure(Call<List<User>> call, Throwable throwable) {
                System.out.println("onFailure: " + throwable);
            }
        });
    }

    private static void sendPost() {

        //Post post = new Post(1,1, "test title", "test body");
        User user = new User("Victor", "2000-01-01");
        System.out.println("User:" + user);

        try {
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            String result = ApiManager.getApiService().sendPost(user).execute().body();
            System.out.println("result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
