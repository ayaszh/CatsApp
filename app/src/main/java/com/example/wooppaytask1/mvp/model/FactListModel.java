package com.example.wooppaytask1.mvp.model;

import androidx.annotation.NonNull;

import com.example.wooppaytask1.mvp.contract.MvpContract;
import com.example.wooppaytask1.mvp.network.ApiClient;
import com.example.wooppaytask1.mvp.network.ApiInterface;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactListModel implements MvpContract.Model {

    @Override
    public void asyncGetFactRequest(final ModelListener modelListener) {

        Gson gson = new Gson();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<String> call = apiService.getFact();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                assert response.body() != null;
                String factJson = response.body().toString();

                Facts fact = gson.fromJson(factJson, Facts.class);
                modelListener.onFinished(fact.getFact());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                modelListener.onFailure(t);
            }
        });
    }
}

