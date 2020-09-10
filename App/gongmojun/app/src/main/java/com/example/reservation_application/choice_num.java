package com.example.reservation_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class choice_num extends AppCompatActivity {

    private ImageButton train1,train2,train3,train4,train5,train6;
    private Button back;
    private TextView subway;
    private int hour=reservation_page.hour;
    private int min=reservation_page.min;
    private String str=reservation_page.str1;
    public static String station_num;

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
        back =findViewById(R.id.back);
        subway = findViewById(R.id.subway);

        subway.setText(str);

        train1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
                station_num="1호차";
            }
        });

        train2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
                station_num="2호차";
            }
        });

        train3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
                station_num="3호차";
            }
        });

        train4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
                station_num="4호차";
            }
        });

        train5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
                station_num="5호차";
            }
        });


        train6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,choice_chair_num.class);
                startActivity(intent);
                station_num="6호차";
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_num.this,reservation_page.class);
                startActivity(intent);
            }
        });



    }
}