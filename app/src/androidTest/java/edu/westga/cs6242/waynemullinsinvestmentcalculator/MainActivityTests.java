package edu.westga.cs6242.waynemullinsinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {


    private EditText txtPayment;
    private EditText txtRate;
    private EditText txtPeriods;
    private EditText txtValue;
    private Button btnCalculate;
    private TextView lblError;

    public MainActivityTests() {
        super(MainActivity.class);
    }//constructor


    private MainActivity testSetup() {
        MainActivity activity = getActivity();

        txtPayment = (EditText)activity.findViewById(R.id.txtPayment);
        txtRate = (EditText)activity.findViewById(R.id.txtRate);
        txtPeriods = (EditText)activity.findViewById(R.id.txtPeriods);
        txtValue = (EditText)activity.findViewById(R.id.txtValue);
        btnCalculate = (Button)activity.findViewById(R.id.btnCalculate);
        lblError = (TextView)activity.findViewById(R.id.lblError);

        final EditText txtPayment = (EditText)activity.findViewById(R.id.txtPayment);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                txtPayment.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        return activity;
    }//testSetup()

    //TEST 1, verify that the MainActivity exists
    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull("Test Activity Exists", activity);
    }//testActivityExists()

    //TEST 2, verify that Payment is a required field
    public void testPaymentIsRequired() {
        MainActivity activity = testSetup();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                txtRate.setText("2");
                txtPeriods.setText("5");
            }
        });
        TouchUtils.clickView(this, btnCalculate);
        getInstrumentation().waitForIdleSync();
        assertEquals("Payment is a required value!", lblError.getText());
    }//testPaymentIsRequired()

    //TEST 3, verify that Rate is a required field
    public void testRateIsRequired() {
        MainActivity activity = testSetup();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                txtPayment.setText("5000.00");
                txtPeriods.setText("5");
            }
        });
        TouchUtils.clickView(this, btnCalculate);
        getInstrumentation().waitForIdleSync();
        assertEquals("Rate is a required value!", lblError.getText());
    }//testRateIsRequired()

    //TEST 3, verify that Rate is a required field
    public void testPeriodsIsRequired() {
        MainActivity activity = testSetup();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                txtPayment.setText("5000.00");
                txtRate.setText("2");
            }
        });
        TouchUtils.clickView(this, btnCalculate);
        getInstrumentation().waitForIdleSync();
        assertEquals("Periods is a required value!", lblError.getText());
    }//testPeriodsIsRequired()

    public void testRateForZero() {
        MainActivity activity = testSetup();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                txtPayment.setText("5000.00");
                txtRate.setText("0");
                txtPeriods.setText("5");
            }
        });
        TouchUtils.clickView(this, btnCalculate);
        getInstrumentation().waitForIdleSync();
        assertEquals("$25,000.00", txtValue.getText().toString());
    }

    public void testValueForValidParameters() {
        MainActivity activity = testSetup();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                txtPayment.setText("1000.00");
                txtRate.setText("2");
                txtPeriods.setText("5");
            }
        });
        TouchUtils.clickView(this, btnCalculate);
        getInstrumentation().waitForIdleSync();
        assertEquals("$5,204.04", txtValue.getText().toString());
    }
}
