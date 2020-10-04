package com.example.reservation_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class choice_chair_num extends AppCompatActivity {

    private ImageButton left_reservation, right_reservation;
    private int hour=listview.res_hour;
    private int min=listview.res_min;
    private String start=reservation_page.str1;
    private String end=reservation_page.str2;

    private Spinner spinner;
    private int block_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_chair_num);

        left_reservation = findViewById(R.id.left_reservation);
        right_reservation = findViewById(R.id.right_reservation);
        spinner=findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                block_num=Integer.parseInt(adapterView.getItemAtPosition(position).toString().substring(0,1));
                Log.d("test","block_num: "+block_num);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response); // 로그인 요청을 한다음 결과값을 json 오브젝트로 받음, 성공 여부 알기 위해 함
                    int cnt = jsonObject.getInt("cnt");
                    int seat_num = jsonObject.getInt("seat_num");

                    if(cnt==1)
                    {
                        if(seat_num==1){
                            left_reservation.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                        else{
                            right_reservation.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        }
                    }
                    else if(cnt==2)
                    {
                        left_reservation.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        right_reservation.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                    else{
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        SeatReservated seatReservated = new SeatReservated(start, end, hour, min, block_num, responseListener);
        RequestQueue queue = Volley.newRequestQueue(choice_chair_num.this);
        queue.add(seatReservated);




        Log.d("test", "start:"+start+" end:"+end+" hour:"+hour+" min:"+min);


        left_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int seat_num = 1;
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response); // 로그인 요청을 한다음 결과값을 json 오브젝트로 받음, 성공 여부 알기 위해 함
                            boolean success = jsonObject.getBoolean("success"); // php에 success가 가는데 그걸 받아와서 판단함

                            if(success)
                            {
                                Toast.makeText(getApplicationContext(), "예약을 완료했습니다.",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(choice_chair_num.this, reservation_page.class);
                                startActivity(intent); // 가입 하고 메인화면 보내주기
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "이미 예약된 좌석입니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                ReservationRequest reservationRequest = new ReservationRequest(start, end, hour, min, block_num, seat_num, responseListener);
                RequestQueue queue = Volley.newRequestQueue(choice_chair_num.this);
                queue.add(reservationRequest);
            }
        });

        right_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int seat_num = 2;
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response); // 로그인 요청을 한다음 결과값을 json 오브젝트로 받음, 성공 여부 알기 위해 함
                            boolean success = jsonObject.getBoolean("success"); // php에 success가 가는데 그걸 받아와서 판단함
                            if(success)
                            {
                                Toast.makeText(getApplicationContext(), "예약을 완료했습니다.",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(choice_chair_num.this, reservation_page.class);
                                startActivity(intent); // 가입 하고 메인화면 보내주기
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "이미 예약된 좌석입니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                ReservationRequest reservationRequest=  new ReservationRequest(start, end, hour, min, block_num, seat_num, responseListener);//blocknum수정(station_num이 int형이였는데 blocknum이 string형이라 type 바꿔줌
                RequestQueue queue = Volley.newRequestQueue(choice_chair_num.this);
                queue.add(reservationRequest);
            }
        });
    }
}