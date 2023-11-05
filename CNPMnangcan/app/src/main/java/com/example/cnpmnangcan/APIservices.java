package com.example.cnpmnangcan;

import com.example.cnpmnangcan.Models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIservices {
    //goi retrofit
    //lưu ý tìm ip wifi của chính mình r gắn đuôi localhost vô mới chạy được nhen
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.103:3000").addConverterFactory(GsonConverterFactory.create())
            .build();
    // Khởi tạo Retrofit Service
    APIservices myapi= retrofit.create(APIservices.class);
    @GET("api/product/get-all")
    Call<List<Product>> Fetchdata();
}
