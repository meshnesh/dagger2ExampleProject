package com.main.myapplication.network.auth;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AuthApi {

    @GET("fake")
    Call<ResponseBody> getFakeStuff();
}
