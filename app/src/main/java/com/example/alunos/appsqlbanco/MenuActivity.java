package com.example.alunos.appsqlbanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    ImageView addUser;
    ImageView users;
    ImageView alterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        addUser = (ImageView) findViewById(R.id.imageView);
        users = (ImageView) findViewById(R.id.imageView2);
        alterUser =(ImageView) findViewById(R.id.imageView3);
    }
            public void btnClickMoreUsers (View v){
            Intent i = new Intent(this, UserActivity.class);
            startActivity(i);
        }

        public void btnClickMoreaddUsers (View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }



}

