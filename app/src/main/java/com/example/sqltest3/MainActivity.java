package com.example.sqltest3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sqltest3.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        binding.setViewModel(viewModel);

        findViewById(R.id.btn_insert).setOnClickListener(v -> {
            Todo tmp = new Todo();
            tmp.setDetectResult("위험");
            tmp.setMessage_type("메시지");
            tmp.setReceiveDate(new Date(System.currentTimeMillis()));
            tmp.setSender("홍길동");
            List<String> tmpList = new ArrayList<String>();
            tmpList.add("abc");
            tmpList.add("bcd");
            tmp.setUrlList(tmpList);
            tmp.setMessageBody(binding.edtInput.getText().toString());

            viewModel.insert(tmp);
            binding.edtInput.setText("");
        });

        findViewById(R.id.btn_delete).setOnClickListener(v -> {
            viewModel.deleteALl();
        });
    }

}