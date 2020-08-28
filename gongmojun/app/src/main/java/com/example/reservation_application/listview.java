package com.example.reservation_application;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class listview extends Activity implements AdapterView.OnItemClickListener {
    String[] age = new String[] { "10대", "20대", "30대", "40대", "50대" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView list = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, age);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        // arg1는 현재 리스트에 뿌려지고 있는 정보
        // arg2는 현재 리스트에 뿌려지고 있는 해당 id 값

        // 값 출력을 위해 불러온 도구를 id값을 통해 불러옴
        TextView a = (TextView) findViewById(R.id.textView1);

        // 현재 리스트뷰에 있는 해당 값을 보기
        TextView tv = (TextView) arg1;

        // 현재 리스트뷰에 나오는 문자열과 해당 라인의 id값을 확인
        a.setText("선택된 값 : " + tv.getText() + "\n선택된 id값: " + arg2);

    }

}
