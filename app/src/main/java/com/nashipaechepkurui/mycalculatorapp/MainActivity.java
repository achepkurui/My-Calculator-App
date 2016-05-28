package com.nashipaechepkurui.mycalculatorapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText etFirstNumber;
    private EditText etSecondNumber;
    private int operationType;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
        etFirstNumber = (EditText) findViewById(R.id.eT1);
        etSecondNumber = (EditText) findViewById(R.id.eT2);

        tvResult = (TextView) findViewById(R.id.tvResult);

        final TextView tvResult = (TextView) findViewById(R.id.tvResult);

        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);

        RadioButton Addition = (RadioButton) findViewById(R.id.rbAddition);
        Addition.setOnCheckedChangeListener(this);

        RadioButton Subtraction = (RadioButton) findViewById(R.id.rbSubtraction);
        Subtraction.setOnCheckedChangeListener(this);

        RadioButton Multiplication = (RadioButton) findViewById(R.id.rbMultiplication);
        Multiplication.setOnCheckedChangeListener(this);


        btnCalculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculate) {
            String strNumberOne = etFirstNumber.getText().toString();
            String strNumberTwo = etSecondNumber.getText().toString();

            //change string to integer
            int NumberOne = Integer.parseInt(strNumberOne);
            int NumberTwo = Integer.parseInt(strNumberTwo);

            //check which radiobutton has been selected

            if (operationType == 1) {
                //perform addiction and display result
                int answer = Addition(NumberOne, NumberTwo);
                tvResult.setText("Answer is:" + answer);


            } else if (operationType == 2) {
                //perform subtraction and display the result
                int answer = Subtraction(NumberOne, NumberTwo);
                tvResult.setText("Answer is:" + answer);
            }

            if (operationType == 3) {
                //perform multiplication and display result
                int answer = Multiplication(NumberOne, NumberTwo);
                tvResult.setText("Answer is:" + answer);


            }

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.rbAddition:
                operationType = 1;
                break;
            case R.id.rbSubtraction:
                operationType = 2;
                break;
            case R.id.rbMultiplication:
                operationType = 3;
                break;

        }
    }


    public static int Addition(int a, int b) {
        return a + b;

    }

    public static int Multiplication(int c, int d) {
        return c * d;
    }

    public static int Subtraction(int x, int y) {
        return x - y;
    }
}












