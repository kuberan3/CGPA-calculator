package com.tectdecod.gpa_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Choose extends AppCompatActivity implements View.OnClickListener{

    Button cgpa_cal_btn, gpa_cal_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //outside from youtube, it is hide the Action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose);

        gpa_cal_btn = findViewById(R.id.gpa_calculate1);
        cgpa_cal_btn = findViewById(R.id.cgpa_calculate2);



        gpa_cal_btn.setOnClickListener(this);
        cgpa_cal_btn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.gpa_calculate1:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Choose.this, GPA_Calculate.class));
                break;
            case R.id.cgpa_calculate2:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Choose.this, CGPA_Calculate.class));
                break;


        }

    }
}
