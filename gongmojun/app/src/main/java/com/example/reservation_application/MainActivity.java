package com.example.reservation_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button register;
    private EditText reg_id, reg_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        reg_id = findViewById(R.id.reg_id);
        reg_pw = findViewById(R.id.reg_pw);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 로그인 눌렀을 때

                String userID = reg_id.getText().toString();
                String userPW = reg_pw.getText().toString();

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


                                Toast.makeText(getApplicationContext(), "로그인 성공~앙 ~기분조아~!",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, reservation_page.class);

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
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
        });

        register.setOnClickListener(new View.OnClickListener() { // 회원가입 버튼 눌렀을 때
            @Override
            public void onClick(View view) {
                Intent register_intent = new Intent(MainActivity.this, register.class);
                startActivity(register_intent);
            }
        }); // 회원가입 페이지 이동


    }
}