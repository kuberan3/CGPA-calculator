package com.tectdecod.gpa_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements  View.OnClickListener {

    EditText regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regsterBtn, regToLoginBtn;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //outside from youtube, it is hide the Action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       setContentView(R.layout.activity_sign_up);


        regName = findViewById(R.id.name_reg);
        regUsername = findViewById(R.id.username_reg);
        regEmail = findViewById(R.id.email_reg);
        regPhoneNo = findViewById(R.id.phonNo_reg);
        regPassword = findViewById(R.id.password_reg);
        regsterBtn = findViewById(R.id.signupBtn);
        regToLoginBtn = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.progressBar);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();


        regsterBtn.setOnClickListener(this);
        regToLoginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View V) {
        switch (V.getId()) {

            case R.id.signupBtn:
                registerUser();
                break;

            case R.id.login_btn:
                startActivity(new Intent(this, Login.class));
                break;


        }

    }

    public void registerUser() {

        String name = regName.getText().toString();
        String username = regUsername.getText().toString();
        String email = regEmail.getText().toString();
        String phoneNo = regPhoneNo.getText().toString();
        String password = regPassword.getText().toString();

        if (name.isEmpty()) {
            regName.setError("Name is required!");
            regName.requestFocus();
            return;
        }
        if (username.isEmpty()) {
            regUsername.setError("Username is required!");
            regUsername.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            regEmail.setError("Email is required!");
            regEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            regEmail.setError("Please provide valid email!");
            regEmail.requestFocus();
            return;
        }
        if (phoneNo.isEmpty()) {
            regPhoneNo.setError("PhoneNo is required!");
            regPhoneNo.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            regPassword.setError("Password is required!");
            regPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            regPassword.setError("Min password length should be 6 characters!");
            regPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignUp.this,new OnCompleteListener<AuthResult>() {
                 @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                     if (task.isSuccessful()) {
                         User information = new User(name, username, email, phoneNo, password);
                         db = FirebaseDatabase.getInstance();
                         databaseReference = db.getReference("Users");
                         databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                       /* User information = new User(name, username, email, phoneNo, password);
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {*/
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "User has been SiginUp successfuly", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(SignUp.this,Login.class));
                                progressBar.setVisibility(View.GONE);
                            } else {
                                    Toast.makeText(SignUp.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });


                    }else{
                         Toast.makeText(SignUp.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                         progressBar.setVisibility(View.GONE);
                     }

                }
      });

    }
}


