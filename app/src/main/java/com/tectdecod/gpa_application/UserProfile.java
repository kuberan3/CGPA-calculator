package com.tectdecod.gpa_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class UserProfile extends AppCompatActivity implements View.OnClickListener{

     FirebaseUser information;
     DatabaseReference databaseReference;
     Button logout , summaries, gpa_cal;
     String userID;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //outside from youtube, it is hide the Action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_profile);



        gpa_cal = findViewById(R.id.gpa_calculate);
        summaries = findViewById(R.id.summaries_level);
        logout = findViewById(R.id.logout_user);
        progressBar = findViewById(R.id.progressBar);

        gpa_cal.setOnClickListener(this);
        summaries.setOnClickListener(this);
        logout.setOnClickListener(this);




        information = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userID = information.getUid();

        final TextView fullNnameTextView =findViewById(R.id.full_name);
        final TextView UserNameTextView =findViewById(R.id.username);

        final EditText UserFullNameEditText =findViewById(R.id.fullname_user);
        final EditText UserNameEditText =findViewById(R.id.user_name);
        final EditText UserEmailEditText  =findViewById(R.id.email_user);
        final EditText UserPhoneNoEditText =findViewById(R.id.phoneNum_user);
        final EditText UserPasswordEditText  =findViewById(R.id.password_user);



        databaseReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null){
                    String name = userProfile.name;
                    String username = userProfile.username;
                    String email = userProfile.email;
                    String phoneNo = userProfile.phoneNo;
                    String password = userProfile.password;

                    fullNnameTextView.setText(name);
                    UserNameTextView.setText(username);
                    UserFullNameEditText.setText(name);
                    UserNameEditText.setText(username);
                    UserEmailEditText.setText(email);
                    UserPhoneNoEditText.setText(phoneNo);
                    UserPasswordEditText.setText(password);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(UserProfile.this,"Something wrong happened !", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.gpa_calculate:
                startActivity(new Intent(UserProfile.this, Choose.class));
                break;
            case R.id.summaries_level:
                startActivity(new Intent(UserProfile.this, SummariesLevels.class));
                break;
            case R.id.logout_user:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfile.this, Login.class));
                break;

        }

    }
}