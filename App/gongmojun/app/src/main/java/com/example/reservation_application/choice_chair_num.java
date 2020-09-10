package com.example.reservation_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class choice_chair_num extends AppCompatActivity {

    private Button back;
    private ImageButton left_reservation, right_reservation;
    private int hour=reservation_page.hour;
    private int min=reservation_page.min;
    private String start=reservation_page.str1;
    private String end=reservation_page.str2;
    private String station_num=choice_num.station_num;

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



                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response); // 로그인 요청을 한다음 결과값을 json 오브젝트로 받음, 성공 여부 알기 위해 함
                            boolean success = jsonObject.getBoolean("success"); // php에 success가 가는데 그걸 받아와서 판단함
                            if(success)
                            {
                                String userID = jsonObject.getString("userID"); // ID랑 PW 검사
                                String userPW = jsonObject.getString("userPassword");


                                Toast.makeText(getApplicationContext(), "예약을 완료했습니다.",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(choice_chair_num.this, reservation_page.class);

                                intent.putExtra("userID", userID);
                                intent.putExtra("userPW", userPW);

                                startActivity(intent); // 가입 하고 메인화면 보내주기
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "실패 ㅠㅠ 앙 아쉽띠!ㅠ", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest=  new LoginRequest(station,  responseListener);
                RequestQueue queue = Volley.newRequestQueue(choice_chair_num.this);
                queue.add(loginRequest);
            }
        });

        right_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response); // 로그인 요청을 한다음 결과값을 json 오브젝트로 받음, 성공 여부 알기 위해 함
                            boolean success = jsonObject.getBoolean("success"); // php에 success가 가는데 그걸 받아와서 판단함
                            if(success)
                            {
                                String userID = jsonObject.getString("userID"); // ID랑 PW 검사
                                String userPW = jsonObject.getString("userPassword");


                                Toast.makeText(getApplicationContext(), "예약을 완료했습니다.",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(choice_chair_num.this, reservation_page.class);

                                intent.putExtra("userID", userID);
                                intent.putExtra("userPW", userPW);

                                startActivity(intent); // 가입 하고 메인화면 보내주기
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "실패 ㅠㅠ 앙 아쉽띠!ㅠ", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest=  new LoginRequest(userID, userPW, responseListener);
                RequestQueue queue = Volley.newRequestQueue(choice_chair_num.this);
                queue.add(loginRequest);
            }
        });
    }
}