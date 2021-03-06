package com.example.reservation_application;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SeatReservated extends StringRequest {

    // 서버 URL 설정(서버랑 연결)
    final static private String URL = "http://220.122.46.204:8000/res_seat.php"; // 심어놓은 php 파일 연동
    private Map<String, String> map;


    public SeatReservated(String start, String end, int hour, int min, int block_num, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("start", start); // 키값
        map.put("end", end);
        map.put("hour", hour+"");
        map.put("min", min+"");
        map.put("block_num", block_num+"");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
