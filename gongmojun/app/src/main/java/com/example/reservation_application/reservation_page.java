package com.example.reservation_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;


import com.google.android.material.snackbar.Snackbar;

import java.util.Scanner;

class Station{
    Station(String nm, int num)
    {
        nm = this.name;
        num = this.st_number;
    }
    private String name;
    private int st_number;

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(int number){
        this.st_number = number;
    }

    public String getName() {return this.name;}

    public int getSt_number() {return this.st_number;}
};

public class reservation_page extends AppCompatActivity {
    
    int Station_n = 28; // 초기화할때 필요한 역 개수 = 29개
    int flag = 1; //출발지, 도착지 팝업 알림할때 쓰는 변수

    Station[] station = new Station[Station_n];
    String[] station_name = {"문양", "다사", "대실", "강창", "계명대", "성서산업단지", "이곡", "용산", "죽전", "감삼", "두류", "내당", "반고개", "청라언덕", "반월당", "경대병원", "대구은행", "범어", "수성구청", "만촌", "담티", "연호", "대공원", "고산", "신매", "사월", "정평", "임당", "영남대"};

    Calendar cal = Calendar.getInstance();

    int c_hour = cal.get(Calendar.HOUR_OF_DAY);
    int c_min = cal.get(Calendar.MINUTE);
    int hour,min;
    private Button back;
    private Button check; // 출발, 도착지 확인 버튼
    private Button time;
    private TextView start;
    private TextView dest;
    private String str1; // 출발정보
    private String str2; // 도착정보
    private Button[] st_button = new Button[Station_n];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_page);

        back = findViewById(R.id.back);
        start = findViewById(R.id.start);
        dest = findViewById(R.id.destination);
        check = findViewById(R.id.check);
        time=findViewById(R.id.timebox);

        time.setText(c_hour +":"+ c_min);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(reservation_page.this, MainActivity.class);

                startActivity(intent);
            }
        });
time.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view){
        TimePickerDialog dialog = new TimePickerDialog(reservation_page.this,
                android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute)
            {
                hour=hourOfDay;
                min=minute;
                time.setText(hour+":"+min);
            }
        },c_hour,c_min,false);
        dialog.show(); //시간 선택하기
    }
});

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = start.getText().toString(); // 출발지 정보 받아옴
                str2 = dest.getText().toString(); // 도착지 정보 받아옴

                final Snackbar snackbar = Snackbar.make(view, "출발지 : "+str1+"\n도착지 : "+str2, Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("확인", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
               // Snackbar.make(view, "출발지 : "+str1+" 도착지 : "+str2,Toast.LENGTH_LONG).show();

               /* Intent start_s = getIntent();
                Intent dest_s = getIntent();
                start_s.putExtra("str_start", str1);
                dest_s.putExtra("str_dest", str2);


                str1 = start_s.getStringExtra("str1");
                str2 = dest_s.getStringExtra("str2");


                 start.setText(str1);
                 dest.setText(str2);*/
            }
        });

        /*for(int i = 0; i<station.length;i++)
        {
            int k = getResources().getIdentifier("button"+i, "id", getPackageName());

            station[i].setName(station_name[i]);
            station[i].setNumber(i);

            st_button[i] = findViewById(k);
            final int finalI = i;
            st_button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag == 1) {
                        AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                        ad.setIcon(R.drawable.icon_subway);
                        ad.setTitle("출발역은" + station[finalI].getName() + "입니다!");

                        ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                flag = -1;
                                start.setText(station[finalI].getName());
                                dialogInterface.dismiss();
                            }
                        });

                        ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                flag = 1;
                                dialogInterface.dismiss();
                            }
                        });
                        ad.show();
                    }
                    else{
                        AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                        ad.setIcon(R.drawable.icon_subway);
                        ad.setTitle("도착역은" + station[finalI].getName() + "입니다!");

                        ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                              flag = 1;
                              dest.setText(station[finalI].getName());
                              dialogInterface.dismiss();
                            }
                        });

                        ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                flag = -1;
                                dialogInterface.dismiss();
                            }
                        });
                        ad.show();
                    }
                }
            });
        }*/
    }
    private TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {

        @Override

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Toast.makeText(getApplicationContext(), hourOfDay + "시 " + minute + "분", Toast.LENGTH_SHORT).show();
        }

    }; //확인 눌렀을때 나오는 시계에 사용되는 함수
}