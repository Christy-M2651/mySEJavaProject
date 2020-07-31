package com.example.mycraapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class T1Review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1_review);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String userFName = sharedPref.getString("userFName", "");
        String userLName = sharedPref.getString("userLName", "");
        String userSIN = sharedPref.getString("userSIN", "");
        String userDOB = sharedPref.getString("userDOB", "");
        String userIncome =  sharedPref.getString("userIncome", "");

        TextView taxProfile = findViewById(R.id.reviewTaxProfile);
        TextView totalIncome = findViewById(R.id.reviewTotalIncome);
        TextView SIN = findViewById(R.id.reviewSIN);
        TextView fullName = findViewById(R.id.reviewFullName);
        TextView DOB = findViewById(R.id.reviewDOB);

        Double userIncomeDouble = Double.parseDouble(userIncome);
        final DecimalFormat currency = new DecimalFormat(("$###,###.##"));
        String userTotalIncome = currency.format(userIncomeDouble);

        taxProfile.setText(String.format("%s's Tax Profile", userFName));
        totalIncome.setText(userTotalIncome);
        SIN.setText(userSIN);
        fullName.setText(String.format("%s %s", userFName, userLName));
        DOB.setText(userDOB);

        Button submit = findViewById(R.id.t1btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ThankYou.class));
            }
        });

    }
}