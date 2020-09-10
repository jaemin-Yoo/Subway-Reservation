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

public class register extends AppCompatActivity {

    private Button reg_button;
    private EditText reg_id, reg_pw, reg_name, reg_birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_id = findViewById(R.id.reg_id);
        reg_pw = findViewById(R.id.reg_pw);
        reg_name = findViewById(R.id.reg_name);
        reg_birth = findViewById(R.id.reg_birth);
        reg_button = findViewById(R.id.reg_button); // 값 찾아주기


        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력된 사용자 정보 받아오기
                String userID = reg_id.getText().toString();
                String userPW = reg_pw.getText().toString();
                String userName = reg_name.getText().toString();
                int userAge = Integer.parseInt(reg_birth.getText().toString()); // int 형으로 형변환

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { // 서버 보낼때 그냥 string으로 못하므로 json 오브젝트로 만들어서 서버로 보내야 함(포장)
                        try {
                            JSONObject jsonObject = new JSONObject(response); // 회원가입 요청을 한다음 결과값을 json 오브젝트로 받음, 성공 여부 알기 위해 함
                            boolean success = jsonObject.getBoolean("success"); // php에 success가 가는데 그걸 받아와서 판단함
                            if(success)
                            {
                                Toast.makeText(getApplicationContext(), "회원 가입 성공~!앙~~기모찌",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(register.this, MainActivity.class);
                                startActivity(intent); // 가입 하고 메인화면 보내주기
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "실패 ㅠㅠ 앙 실망띠", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(userID, userPW, userName, userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(register.this);
                queue.add(registerRequest); // Volley를 이용해서 서버로 요청함
            }
        });
    }
}