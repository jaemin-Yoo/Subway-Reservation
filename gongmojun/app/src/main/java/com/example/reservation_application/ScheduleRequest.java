package com.example.reservation_application;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ScheduleRequest extends StringRequest {

    // 서버 URL 설정(서버랑 연결)
    final static private String URL = "http://rhehd002.dothome.co.kr/Schedule.php"; // 심어놓은 php 파일 연동
    private Map<String, String> map;


    public ScheduleRequest(String str1, int hour, int min, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);


        map = new HashMap<>();
        map.put("str1", str1); // 키값
        map.put("hour", hour+"");
        map.put("min", min+"");

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
