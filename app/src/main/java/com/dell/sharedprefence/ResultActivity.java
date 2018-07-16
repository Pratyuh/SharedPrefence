package com.dell.sharedprefence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultdis = (TextView)findViewById(R.id.text);

        SharedPreferences resultpf = getSharedPreferences("MysavedData", Context.MODE_PRIVATE);

        String MyStringValue = resultpf.getString("myvalue","Data Not Found");

        resultdis.setText(MyStringValue);
    }
}
