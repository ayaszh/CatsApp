package com.example.wooppaytask1.mvp.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("fact")
    Call<String> getFact();
}
