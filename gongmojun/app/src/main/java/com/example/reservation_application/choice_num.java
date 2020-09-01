package com.example.reservation_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class choice_num extends AppCompatActivity {

    private ImageButton train1,train2,train3,train4,train5,train6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_num);

        train1 = findViewById(R.id.train1);
        train2 = findViewById(R.id.train2);
        train3 = findViewById(R.id.train3);
        train4 = findViewById(R.id.train4);
        train5 = findViewById(R.id.train5);
        train6 = findViewById(R.id.train6);

        train1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
            }
        });

        train2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
            }
        });

        train3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
            }
        });

        train4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
            }
        });

        train5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
            }
        });


        train6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
            }
        });
    }
}