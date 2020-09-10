package com.example.reservation_application;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ReservationRequest extends StringRequest {

    // 서버 URL 설정(서버랑 연결)
    final static private String URL = "http://192.168.0.7/reservation.php"; // 심어놓은 php 파일 연동
    private Map<String, String> map;


    public ReservationRequest(String userID, String userPassword, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID); // 키값
        map.put("userPassword", userPassword);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
