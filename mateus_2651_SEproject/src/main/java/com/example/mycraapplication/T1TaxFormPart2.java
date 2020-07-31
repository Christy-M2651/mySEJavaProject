package com.example.mycraapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class T1TaxFormPart2 extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1_tax_form_part2);

        // Create object and editor of SharedPreferences.
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = sharedPref.edit();

        final EditText t1EmpIncome = findViewById(R.id.t1EmploymentIncome);

        Button next = findViewById(R.id.t1Part2btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userIncome = t1EmpIncome.getText().toString();

                editor.putString("userIncome", userIncome);
                editor.apply();

                startActivity(new Intent(getApplicationContext(), T1TaxFormPart3.class));
            }
        });

    }

}