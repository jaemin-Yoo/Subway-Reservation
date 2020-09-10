package com.example.reservation_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class choice_chair_num extends AppCompatActivity {

    private Button back;
    private ImageButton left_reservation, right_reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_chair_num);

        back = findViewById(R.id.back);
        left_reservation = findViewById(R.id.left_reservation);
        right_reservation = findViewById(R.id.right_reservation);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_chair_num.this,choice_num.class);
                startActivity(intent);
            }
        });

        left_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_chair_num.this,reservation_page.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "예약이 완료되었습니다.",Toast.LENGTH_LONG).show();
            }
        });

        right_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice_chair_num.this,reservation_page.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "예약이 완료되었습니다.",Toast.LENGTH_LONG).show();
            }
        });
    }
}