package com.company;

import com.company.api.ApiManager;
import com.company.model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        addUser(new User("Alex", "1987-01-20"));
        addUser(new User("Oleg", "1991-05-04"));
        addUser(new User("Anna", "1990-08-15"));
        addUser(new User("Max", "1983-11-19"));
        addUser(new User("Victor", "1980-02-14"));

        getAllUsers();

        getUser(3);

        getUserByName("Victor");

        getUsersByAge(20, 35);

        updateUser(new User(4, "Andrey", "1989-04-20"));

        removeUser(new User(5, "Victor", "1980-02-14"));
    }

    private static void getAllUsers() {
        ApiManager.getApiService().getAll().enqueue(new Callback<List<User>>() {
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                if (users != null) {
                    System.out.println("users: " + users.size());
                    System.out.println(users);
                }
            }

            public void onFailure(Call<List<User>> call, Throwable throwable) {
                System.out.println("onFailure: " + throwable);
            }
        });
    }

    private static void getUser(int id) {
        ApiManager.getApiService().get(id).enqueue(new Callback<User>() {
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null) {
                    System.out.println(user);
                }
            }

            public void onFailure(Call<User> call, Throwable throwable) {
                System.out.println("onFailure: " + throwable);
            }
        });
    }

    private static void getUserByName(String name) {
        ApiManager.getApiService().getByName(name).enqueue(new Callback<User>() {
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null) {
                    System.out.println(user);
                }
            }

            public void onFailure(Call<User> call, Throwable throwable) {
                System.out.println("onFailure: " + throwable);
            }
        });
    }

    private static void getUsersByAge(int fromAge, int toAge) {
        ApiManager.getApiService().getByAge(fromAge, toAge).enqueue(new Callback<List<User>>() {
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                if (users != null) {
                    System.out.println("users: " + users.size());
                    System.out.println(users);
                }
            }
            public void onFailure(Call<List<User>> call, Throwable throwable) {
                System.out.println("onFailure: " + throwable);
            }
        });
    }


    private static void addUser(User user) {
        try {
            ResponseBody responseBody = ApiManager.getApiService().add(user).execute().body();
            System.out.println(responseBody.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateUser(User user) {
        try {
            ResponseBody responseBody = ApiManager.getApiService().update(user).execute().body();
            System.out.println(responseBody.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeUser(User user) {
        try {
            ResponseBody responseBody = ApiManager.getApiService().remove(user).execute().body();
            System.out.println(responseBody.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
