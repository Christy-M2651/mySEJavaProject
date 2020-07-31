package com.example.mycraapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class T1TaxForm extends AppCompatActivity {

    private TextView DOB;

    Calendar cal = Calendar.getInstance();

    // Format the date
    DateFormat fmtDate = DateFormat.getDateInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1_tax_form);

        // Create object and editor of SharedPreferences.
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = sharedPref.edit();

        final EditText FName = findViewById(R.id.t1FName);
        final EditText LName = findViewById(R.id.t1LName);
        final EditText SIN = findViewById(R.id.t1SIN);
        DOB = findViewById(R.id.t1DOB);

        final Button selectDOB = findViewById(R.id.btnDate);

        selectDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(T1TaxForm.this, date,
                        2000, 0, 1).show();
            }
        });

        Button next = findViewById(R.id.t1Part1btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String userFName = FName.getText().toString();
                final String userLName = LName.getText().toString();
                final String userSIN = SIN.getText().toString();
                final String userDOB = DOB.getText().toString();

                if(isDigit(userFName)){
                    Toast.makeText(getApplicationContext(), "Invalid First Name", Toast.LENGTH_SHORT).show();
                    FName.requestFocus(1);
                } else if (isDigit(userLName)) {
                    Toast.makeText(getApplicationContext(), "Invalid Last Name", Toast.LENGTH_SHORT).show();
                    LName.requestFocus(1);
                } else if (userSIN.length() != 9) {
                    Toast.makeText(getApplicationContext(), "Invalid Social Insurance Number", Toast.LENGTH_SHORT).show();
                    SIN.requestFocus(1);
                } else if (userDOB.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Date of Birth is required", Toast.LENGTH_SHORT).show();
                    selectDOB.requestFocus(1);
                }
                else {
                    editor.putString("userFName", userFName);
                    editor.putString("userLName", userLName);
                    editor.putString("userSIN", userSIN);
                    editor.putString("userDOB", userDOB);

                    editor.apply();

                        startActivity(new Intent(getApplicationContext(), T1TaxFormPart2.class));
                    }
                }
        });

    }

    // Adding date set
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            // to set the desired date
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            // Display the selected date in the TextView Object
            DOB.setText(fmtDate.format(cal.getTime()));
        }
    };

    public boolean isDigit(String str) {
        boolean isValid = true;

        // Check each string for digit
        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                isValid = false;
            }
            else {
                isValid = true;
            }
        }
        return isValid;
    }

}