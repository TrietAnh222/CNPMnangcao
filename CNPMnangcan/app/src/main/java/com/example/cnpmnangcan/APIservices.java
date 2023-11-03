package com.example.cnpmnangcan;

import com.example.cnpmnangcan.Models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIservices {
    @GET("get-all")
    Call <List<Product>> fetchData();
}
