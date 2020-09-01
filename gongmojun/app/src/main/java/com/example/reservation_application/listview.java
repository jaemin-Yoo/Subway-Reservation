package com.example.reservation_application;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.reservation_application.reservation_page.hour;

public class listview extends Activity implements AdapterView.OnItemClickListener {
    private String[] a_start;
    private TextView start;
    private int hour2= hour;
    private int min2=reservation_page.min;
    private String str2=reservation_page.str1;
    private Integer[] a_hour;
    private Integer[] a_min;
    private String[] choose;
    private int number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        TextView a = (TextView) findViewById(R.id.textView1);
        a.setText("출발역: "+str2);
        Log.d("test", "log_0 :"+str2+" , "+hour2+", "+min2);
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response); // 로그인 요청을 한다음 결과값을 json 오브젝트로 받음, 성공 여부 알기 위해 함
                    boolean success = jsonObject.getBoolean("success"); // php에 success가 가는데 그걸 받아와서 판단함
                    number = jsonObject.getInt("number");
                    a_start = new String[number+1];
                    a_hour = new Integer[number+1];
                    a_min = new Integer[number+1];
                    choose=new String[(number+1)];

                    if(success)
                    {
                        for(int i=0; i<number+1; i++) {
                            a_start[i] = jsonObject.getString("start"+i);
                            a_hour[i]=jsonObject.getInt("hour"+i);
                            a_min[i] = jsonObject.getInt("min"+i);
                            choose[i]="출발  "+a_hour[i]+" : "+a_min[i];
                            Log.d("test", "성공 ! " + a_start[i] + ", " + a_hour[i] + ", " + a_min[i]+" ," +choose[i]);
                        }

                        ListView list = (ListView) findViewById(R.id.listView1);
                        ArrayAdapter<String> adapter;
                        adapter = new ArrayAdapter<String>(list.getContext(),
                                android.R.layout.simple_list_item_1,choose);
                        list.setAdapter(adapter);
                        list.setOnItemClickListener(list.getOnItemClickListener());
                    }
                    else
                    {
                        Log.d("test","실패 !");
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        ScheduleRequest scheduleRequest=  new ScheduleRequest(str2, hour2, min2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(listview.this);
        queue.add(scheduleRequest);


    }
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        // arg1는 현재 리스트에 뿌려지고 있는 정보
        // arg2는 현재 리스트에 뿌려지고 있는 해당 id 값

        // 값 출력을 위해 불러온 도구를 id값을 통해 불러옴


    }

}
