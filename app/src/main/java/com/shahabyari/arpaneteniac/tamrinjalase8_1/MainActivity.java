package com.shahabyari.arpaneteniac.tamrinjalase8_1;

import android.content.Intent;
import android.graphics.Typeface;
import android.icu.text.DisplayContext;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Intent inte;
    Button btn1;
    Button btn2;
    Button btn3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),"fonts/BTitrBd.ttf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(),"fonts/BBardiya.ttf");
        tv=(TextView) findViewById(R.id.txttitle);
        tv.setTypeface(tf1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setTypeface(tf2);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setTypeface(tf2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setTypeface(tf2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        inte = new Intent(MainActivity.this,gameclass.class);
        switch (view.getId()) {
            case R.id.btn1:
                inte.putExtra("level","1");

                break;
            case R.id.btn2:
                inte.putExtra("level","2");
                break;
            case R.id.btn3:
                inte.putExtra("level","3");
                break;
        }

        startActivity(inte);
    }

}
