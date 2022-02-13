package com.hagedorn.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnCalculate;
    private TextView txtTotalBillRes, txtTotalPerPersonRes, txtTotalTip, txtTipPerPersonRes;
    private EditText editTextCheckAmount, editTextNumberOfPeople, editTextTipPercentage;
    private double checkAmount, numberOfPeople, tipPercentage, totalBill, totalPerPerson, totalTip, tipPerPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        txtTotalBillRes = (TextView) findViewById(R.id.txtTotalBillRes);
        txtTotalPerPersonRes = (TextView) findViewById(R.id.txtTotalPerPersonRes);
        txtTotalTip = (TextView) findViewById(R.id.txtTotalTipRes);
        txtTipPerPersonRes = (TextView) findViewById(R.id.txtTipPerPersonRes);

        editTextCheckAmount = (EditText) findViewById(R.id.editTextCheckAmount);
        editTextNumberOfPeople = (EditText) findViewById(R.id.editTextNumberOfPeople);
        editTextTipPercentage = (EditText) findViewById(R.id.editTextTipPercentage);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Program
                //TotalBill
                checkAmount = Double.parseDouble(editTextCheckAmount.getText().toString());
                numberOfPeople = Double.parseDouble(editTextNumberOfPeople.getText().toString());
                tipPercentage = Double.parseDouble(editTextTipPercentage.getText().toString())/100;

                totalBill = checkAmount*(1+tipPercentage);
                totalPerPerson = totalBill/numberOfPeople;
                totalTip = checkAmount*tipPercentage;
                tipPerPerson = totalTip/numberOfPeople;

                txtTotalBillRes.setText(String.valueOf(Math.round(totalBill)));
                txtTotalPerPersonRes.setText(String.valueOf(Math.round(totalPerPerson)));
                txtTotalTip.setText(String.valueOf(Math.round(totalTip)));
                txtTipPerPersonRes.setText(String.valueOf(Math.round(tipPerPerson)));

                //Round to 2 decimal places
                //Hide keyboard after calculate button is pressed


            }



        });

    }


}