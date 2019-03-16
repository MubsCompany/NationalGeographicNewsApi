package com.example.apiex;

import com.example.apiex.from.generate.ResponseApi;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiService {

    @GET("top-headlines?sources=national-geographic&apiKey=0af9e39d1c0f41fb9709e8de8af33ff3")
    Call<ResponseApi> getDataApi();
}
