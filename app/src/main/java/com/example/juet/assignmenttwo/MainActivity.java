package com.example.juet.assignmenttwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int intMinimum = 1;
    private int intMaximum = 100;

    private TextView tvResult = null;
    private TextView tvMinimum = null;
    private TextView tvMaximum = null;
    private Button btnGenerate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvResult= (TextView)findViewById(R.id.tvResult);
        this.tvMinimum = (TextView)findViewById(R.id.tvMinimum);
        this.tvMaximum = (TextView)findViewById(R.id.tvMaximum);

        setDefaultMinMax();

        this.btnGenerate = (Button) findViewById(R.id.btnGenerate);
        this.btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMinMax();
                Log.d("intMim", Integer.toString(intMinimum));
                Log.d("intMax", Integer.toString(intMaximum));
                tvResult.setText(Integer.toString(generateRandomNumber(intMinimum, intMaximum)));
            }
        });
    }

    private void setDefaultMinMax(){
        tvMinimum.setText(Integer.toString(intMinimum));
        tvMaximum.setText(Integer.toString(intMaximum));
    }

    private void getMinMax(){
        this.intMinimum = Integer.parseInt(tvMinimum.getText().toString());
        this.intMaximum = Integer.parseInt(tvMaximum.getText().toString());
    }

    private int generateRandomNumber(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
