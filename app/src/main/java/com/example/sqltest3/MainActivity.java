package com.example.sqltest3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText edtInput;
    private TextView txtData;
    private Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edt_input);
        txtData = findViewById(R.id.txt_data);

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db")
                .allowMainThreadQueries()
                .build();

        txtData.setText(db.todoDao().getAll().toString());

        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Todo tmp = new Todo();
                tmp.setDetectResult("위험");
                tmp.setMessage_type("메시지");
                tmp.setReceiveDate(new Date(System.currentTimeMillis()));
                tmp.setSender("홍길동");
                List<String> tmpList = new ArrayList<String>();
                tmpList.add("abc");
                tmpList.add("bcd");
                tmp.setUrlList(tmpList);
                tmp.setMessageBody(edtInput.getText().toString());

                db.todoDao().insert(tmp);
                txtData.setText(db.todoDao().getAll().toString());
            }
        });

    }
}