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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity implements View.OnClickListener {


    Button regToSignUpBtn , regSignIn , forgetpass;
    EditText  signInUserEmail , signInPassword;
    ProgressBar progressBar ;
    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //outside from youtube, it is hide the Action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        regToSignUpBtn = findViewById(R.id.sign_up);
        regSignIn = findViewById(R.id.sign_in);
        forgetpass = findViewById(R.id.forgetpass);
        signInPassword = findViewById(R.id.password);
        signInUserEmail = findViewById(R.id.useremail);
        progressBar=findViewById(R.id.progressBar);
        forgetpass.setOnClickListener(this);

        regSignIn.setOnClickListener(this);
        regToSignUpBtn.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        //databaseReference = FirebaseDatabase.getInstance().getReference("Users");



    }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.sign_in:
                      signInUser();
                    break;

                case R.id.sign_up:
                    startActivity(new Intent(this, SignUp.class));
                    break;

                case R.id.forgetpass:
                    startActivity(new Intent(this, ForgetPassword.class));
                    break;
            }
        }

        public void signInUser( ){
            String useremail = signInUserEmail.getText().toString();
            String password = signInPassword.getText().toString();

            if (useremail.isEmpty()){
                signInUserEmail.setError("Email is required!");
                signInUserEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()){
                signInUserEmail.setError("Please provide valid email!");
                signInUserEmail.requestFocus();
                return;
            }
            if (password.isEmpty()){
                signInPassword.setError("Password is required!");
                signInPassword.requestFocus();
                    return;
                }
            if (password.length()<6){
                signInPassword.setError("Min password length should be 6 characters!");
                 signInPassword.requestFocus();
                 return;
              }

            progressBar.setVisibility(View.VISIBLE);

            firebaseAuth.signInWithEmailAndPassword(useremail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        FirebaseUser information = FirebaseAuth.getInstance().getCurrentUser();
                        if (information.isEmailVerified()) {
                            Toast.makeText(Login.this, "Login  successfuly", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Login.this, UserProfile.class));
                            // progressBar.setVisibility(View.GONE);
                        }else {
                            information.sendEmailVerification();
                            Toast.makeText(Login.this,"Check your email to verify your account!", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(Login.this,"Failed to Login! Try again!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                }
            });
        }
}
