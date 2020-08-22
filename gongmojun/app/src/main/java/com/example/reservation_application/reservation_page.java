package com.example.reservation_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Scanner;

/*class Station{
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
};*/ // station 클래스

public class reservation_page extends AppCompatActivity {
    
    int Station_n = 29; // 초기화할때 필요한 역 개수 = 29개
    int flag = 1; //출발지, 도착지 팝업 알림할때 쓰는 변수

    //Station[] station = new Station[Station_n];

    String[] station_name = {"문양", "다사", "대실", "강창", "계명대", "성서산업단지", "이곡", "용산", "죽전", "감삼", "두류", "내당", "반고개", "청라언덕", "반월당", "경대병원", "대구은행", "범어", "수성구청", "만촌", "담티", "연호", "대공원", "고산", "신매", "사월", "정평", "임당", "영남대"};


    private Button back;
    private Button check; // 출발, 도착지 확인 버튼
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(reservation_page.this, MainActivity.class);

                startActivity(intent);
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
            }
        });

        for(int i = 0; i<Station_n;i++)
        {
            int k = getResources().getIdentifier("button"+i, "id", getPackageName());

           // station[i].setName(station_name[i]);
           // station[i].setNumber(i);

            st_button[i] = findViewById(k);
            final int finalI = i;
            st_button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (finalI) {
                        case 0:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 1:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 2:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 3:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 4:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 5:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 6:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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

                        case 7:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 8:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 9:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 10:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 11:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 12:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 13:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 14:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 15:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 16:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 17:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 18:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 19:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 20:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 21:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 22:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 23:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 24:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 25:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 26:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 27:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                        case 28:
                            if (flag == 1) {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("출발역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = -1;
                                        start.setText(station_name[finalI]);
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
                                break;
                            } else {
                                AlertDialog.Builder ad = new AlertDialog.Builder((reservation_page.this));
                                ad.setIcon(R.drawable.icon_subway);
                                ad.setTitle("도착역은" + station_name[finalI] + "입니다!\n");

                                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        flag = 1;
                                        dest.setText(station_name[finalI]);
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
                                break;
                            }
                    } // 이거 switch case 문으로 노가다 한거

                }

            });
        }
    }
}