package com.tectdecod.gpa_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ForgetPassword extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    Button resetpass;
    EditText emailEditText;
    ProgressBar progressBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //outside from youtube, it is hide the Action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forget_password);


        progressBar = findViewById(R.id.progressBar);
        resetpass = findViewById(R.id.reset_pass);
        emailEditText = findViewById(R.id.useremail);

        firebaseAuth = FirebaseAuth.getInstance();

        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();

            }
        });
    }

        public void resetPassword(){

            String useremail = emailEditText.getText().toString();

            if (useremail.isEmpty()){
                emailEditText.setError("Email is required!");
                emailEditText.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()){
                emailEditText.setError("Please provide valid email!");
                emailEditText.requestFocus();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(ForgetPassword.this, "Check your email to reset your password!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                        startActivity(new Intent(ForgetPassword.this,Login.class));
                    }else{
                        Toast.makeText(ForgetPassword.this, "Try again! Something wrong happened !", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

}