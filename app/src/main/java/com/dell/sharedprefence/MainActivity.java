package com.dell.sharedprefence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button saveBt = (Button)findViewById(R.id.button);
        Button loadBt = (Button)findViewById(R.id.button2);
        Button go = (Button)findViewById(R.id.button3);
        final EditText value = (EditText)findViewById(R.id.editText);
        final TextView result = (TextView)findViewById(R.id.textView);


        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences = getSharedPreferences("MysavedData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("myvalue",value.getText().toString());
                editor.apply();


            }
        });

        loadBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result.setText(sharedPreferences.getString("myvalue","Data not found"));

            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

    }
}
