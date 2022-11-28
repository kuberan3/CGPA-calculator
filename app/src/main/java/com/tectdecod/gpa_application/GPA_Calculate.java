package com.tectdecod.gpa_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

public class GPA_Calculate extends AppCompatActivity {

            Spinner spinner;
            Spinner spinner1;
            Spinner spinner2 ,spinner3;
            double gradesValue  ,gradesValue2;
            double result ,result1 ;
            EditText creditNum,creditNum33 ,creditNum44;
            EditText creditNum22;
            TextView result511;
            Button ButtonResult ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //outside from youtube, it is hide the Action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_g_p_a__calculate);

                creditNum= (EditText) findViewById(R.id.creditNum);
                creditNum22=(EditText) findViewById(R.id.creditNum2);
                creditNum33=(EditText) findViewById(R.id.creditNum3);
                creditNum44=(EditText) findViewById(R.id.creditNum4);

                ButtonResult = (Button) findViewById(R.id.button);
                result511 = (TextView) findViewById(R.id.Result5_1);
                // creditNum0=(EditText) findViewById(R.id.creditNum3);
                spinner = (Spinner) findViewById(R.id.spinner5_);
                spinner1 = (Spinner) findViewById(R.id.spinner5_2);
                spinner2 = (Spinner) findViewById(R.id.spinner5_3);
                spinner3 = (Spinner) findViewById(R.id.spinner5_4);
                final String[] grades = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, grades);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedGrade = (String) parent.getItemAtPosition(position);

                        if(selectedGrade.equals("A+")){

                            gradesValue = 5.00; }

                        else if (selectedGrade.equals("A")){
                            gradesValue = 4.75; }

                        else if (selectedGrade.equals("B+")){
                            gradesValue = 4.50;}

                        else if (selectedGrade.equals("B")){
                            gradesValue = 4.00;}

                        else if(selectedGrade.equals("C+")){
                            gradesValue = 3.50;}
                        else if (selectedGrade.equals("C")){
                            gradesValue = 3.00;}
                        else if (selectedGrade.equals("D+")){
                            gradesValue = 2.50;}
                        else if(selectedGrade.equals("D")){
                            gradesValue = 2.00;}
                        else if (selectedGrade.equals("F")){
                            gradesValue = 1;}

                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                final String[] grades1 = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};

                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, grades1);
                spinner1.setAdapter(adapter1);
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String selectedGrade = (String) parent.getItemAtPosition(position);

                        if(selectedGrade.equals("A+")){

                            gradesValue2= 5.00; }

                        else if (selectedGrade.equals("A")){
                            gradesValue2 = 4.75; }

                        else if (selectedGrade.equals("B+")){
                            gradesValue2 = 4.50;}

                        else if (selectedGrade.equals("B")){
                            gradesValue2 = 4.00;}

                        else if(selectedGrade.equals("C+")){
                            gradesValue2 = 3.50;}
                        else if (selectedGrade.equals("C")){
                            gradesValue2 = 3.00;}
                        else if (selectedGrade.equals("D+")){
                            gradesValue2= 2.50;}
                        else if(selectedGrade.equals("D")){
                            gradesValue2 = 2.00;}
                        else if (selectedGrade.equals("F")){
                            gradesValue2 = 1;}





                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }




                });


                final String[] grades2 = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};

                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, grades2);
                spinner2.setAdapter(adapter2);
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String selectedGrade = (String) parent.getItemAtPosition(position);

                        if(selectedGrade.equals("A+")){

                            gradesValue = 5.00; }

                        else if (selectedGrade.equals("A")){
                            gradesValue = 4.75; }

                        else if (selectedGrade.equals("B+")){
                            gradesValue = 4.50;}

                        else if (selectedGrade.equals("B")){
                            gradesValue = 4.00;}

                        else if(selectedGrade.equals("C+")){
                            gradesValue = 3.50;}
                        else if (selectedGrade.equals("C")){
                            gradesValue = 3.00;}
                        else if (selectedGrade.equals("D+")){
                            gradesValue = 2.50;}
                        else if(selectedGrade.equals("D")){
                            gradesValue= 2.00;}
                        else if (selectedGrade.equals("F")){
                            gradesValue = 1;}



                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {


                    }  });
                final String[] grades3 = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};

                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, grades3);
                spinner3.setAdapter(adapter3);

                spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String selectedGrade = (String) parent.getItemAtPosition(position);

                        if(selectedGrade.equals("A+")){

                            gradesValue = 5.00; }

                        else if (selectedGrade.equals("A")){
                            gradesValue = 4.75; }

                        else if (selectedGrade.equals("B+")){
                            gradesValue = 4.50;}

                        else if (selectedGrade.equals("B")){
                            gradesValue = 4.00;}

                        else if(selectedGrade.equals("C+")){
                            gradesValue = 3.50;}
                        else if (selectedGrade.equals("C")){
                            gradesValue = 3.00;}
                        else if (selectedGrade.equals("D+")){
                            gradesValue = 2.50;}
                        else if(selectedGrade.equals("D")){
                            gradesValue= 2.00;}
                        else if (selectedGrade.equals("F")){
                            gradesValue = 1;}



                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }});

                ButtonResult.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        String creditNumber22 = creditNum22.getText().toString();
                        int numberOfCredit2 = Integer.parseInt(creditNumber22);
                        result = (gradesValue * numberOfCredit2   / numberOfCredit2);


                    }});


                ButtonResult.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        String creditNumber3 = creditNum33.getText().toString();
                        int numberOfCredit3 = Integer.parseInt(creditNumber3);
                        result1 = (gradesValue2 * numberOfCredit3 / numberOfCredit3);
                        result511.setText(String.valueOf(result + result1));
                    }});
            }
        }
