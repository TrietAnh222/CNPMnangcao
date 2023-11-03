package com.example.cnpmnangcan.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cnpmnangcan.APIservices;
import com.example.cnpmnangcan.Adapter.ProductAdapter;
import com.example.cnpmnangcan.Models.Product;
import com.example.cnpmnangcan.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManHinhChinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gọi retrofit
        //E/RecyclerView: No adapter attached; skipping layout còn lỗi này
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3001/api/product/").addConverterFactory(GsonConverterFactory.create())
                        .build();
        // Khởi tạo Retrofit Service
        APIservices myapi= retrofit.create(APIservices.class);
        // Thực hiện cuộc gọi API
        Call<List<Product>> call = myapi.fetchData();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.isSuccessful()){
                    List<Product> productList =response.body();
                    //gọi adapter
                    ProductAdapter adapter = new ProductAdapter(productList,MainActivity.this);
                    recyclerViewManHinhChinh.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
        KhaiBao();
        ActionBar();
        ActionViewFilpper();
    }
    //chi tiết về glide Ae có thể tham khảo ở đây
    //https://github.com/bumptech/glide/blob/master/README.md
    //xài anim để có hiệu ứng chút nhá
    private void ActionViewFilpper(){
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://intphcm.com/data/upload/banner-la-gi.jpg");
        mangquangcao.add("https://intphcm.com/data/upload/mau-banner-noi-bat.jpg");
        mangquangcao.add("https://intphcm.com/data/upload/mau-banner-logo-dep.jpg");
        for (int i=0;i<mangquangcao.size();i++){
            ImageView imageView =new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }
    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void KhaiBao(){
        toolbar = findViewById(R.id.Toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.ViewFlipper);
        recyclerViewManHinhChinh = findViewById(R.id.RecyclerView);
        navigationView = findViewById(R.id.navigationview);
        listViewmanhinhchinh = findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerLayout);
    }
}