package com.example.www.jokeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JokeActivity extends AppCompatActivity {
    TextView joketextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        joketextView=(TextView) findViewById(R.id.tv_joke);

        if(getIntent()!=null){
            joketextView.setText(getIntent().getStringExtra("joke"));
        }
    }
}
