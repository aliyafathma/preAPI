package com.example.pre_api.network;

import com.example.pre_api.model.UserResponse;
import com.example.pre_api.model.UserkuResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/")

    /*Line 16 untuk nampilin list (sesuai jumlah yang diinginkan) user dari web randomuser.me*/
    Call<UserResponse> getUser(@Query("results") int result);
}
