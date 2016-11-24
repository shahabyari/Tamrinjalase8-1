package com.shahabyari.arpaneteniac.tamrinjalase8_1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Administrator on 23/11/2016.
 */

public class gameclass extends AppCompatActivity implements View.OnClickListener {

    Intent inte;
    Random rm;
    TextView text1;
    EditText txtinput;
    TextView txtError;
    int intrmnuber;
    Button btnselect;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelayout);
        inte = getIntent();
        String level = inte.getStringExtra("level");
        config();
        showLevel(level);
        setrmd(level);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btngo :
                if (!txtinput.getText().toString().equals(""))
                {
                    int inputnumber = Integer.parseInt(txtinput.getText().toString());
                    if(inputnumber == intrmnuber){ txtError.setText("تبریک ، حدس شما درست است");}
                    if(inputnumber > intrmnuber){ txtError.setText("زیاد است");}
                    if(inputnumber < intrmnuber){ txtError.setText("کم است");}
                } else
                {
                    txtError.setText("لطفا مقداری را وارد نمایید");
                }
                break;
            case R.id.btnback :
                Intent a = new Intent(gameclass.this,MainActivity.class);
                startActivity(a);
                break;

        }



    }

    private void config() {
        text1 = (TextView) findViewById(R.id.txtlevelshow);
        txtinput = (EditText) findViewById(R.id.txtinput);
        txtError = (TextView) findViewById(R.id.txtError);
        btnselect = (Button) findViewById(R.id.btngo);
        btnselect.setOnClickListener(this);
        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(this);
        rm = new Random();
    }

    private void showLevel(String a) {
        switch (a) {
            case "1":
                text1.setText("ساده");
                break;
            case "2":
                text1.setText("متوسط");
                break;
            case "3":
                text1.setText("پیشرفته");
                break;
        }

    }

    private void setrmd(String a) {
        switch (a) {
            case "1":
                intrmnuber= rm.nextInt(100);
                break;
            case "2":
                intrmnuber= rm.nextInt(1000);
                break;
            case "3":
                intrmnuber= rm.nextInt(10000);
                break;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}