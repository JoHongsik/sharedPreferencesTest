package com.example.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textview1;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.edit1);
        textview1 = (TextView) findViewById(R.id.resultText1);

        SharedPreferences sf = getSharedPreferences("testFile",MODE_PRIVATE);

        String text = sf.getString("text","");
        textview1.setText(text);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences("testFile",MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String text = editText1.getText().toString();
        editor.putString("text",text);

        editor.commit();
    }
}
