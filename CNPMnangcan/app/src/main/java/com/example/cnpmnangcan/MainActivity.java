package com.example.cnpmnangcan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;


public class MainActivity extends AppCompatActivity {
    String Appid = "data-nhbur";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        App app = new App(new AppConfiguration.Builder(Appid).build());
    }
}