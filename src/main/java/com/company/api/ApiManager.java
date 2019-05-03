package com.company.api;

import com.company.Const;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(Const.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
