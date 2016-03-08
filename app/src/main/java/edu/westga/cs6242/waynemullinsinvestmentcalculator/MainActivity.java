package edu.westga.cs6242.waynemullinsinvestmentcalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.westga.cs6242.waynemullinsinvestmentcalculator.model.*;

public class MainActivity extends AppCompatActivity {

    private InvestmentCalculator model;
    private EditText txtPayment = null;
    private EditText txtRate = null;
    private EditText txtPeriods = null;
    private EditText txtValue = null;
    private TextView lblError = null;
    private String errorMessage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.model = new InvestmentCalculator();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnCalculate_onClick(View view) {
        this.errorMessage = "";
        if (!validate()) {
            lblError.setText(this.errorMessage);
            return;
        }
        findViewById(R.id.btnCalculate).setBackgroundColor(Color.RED);
        double payment = Double.parseDouble(txtPayment.getText().toString());
        double rate = Double.parseDouble(txtRate.getText().toString());
        int periods = Integer.parseInt(txtPeriods.getText().toString());
        lblError.setText(this.errorMessage);
    }

    public boolean validate() {
        if (txtPayment == null) {
            txtPayment = (EditText) findViewById(R.id.txtPayment);
            txtRate = (EditText) findViewById(R.id.txtRate);
            txtPeriods = (EditText) findViewById(R.id.txtPeriods);
            txtValue = (EditText) findViewById(R.id.txtValue);
            lblError = (TextView) findViewById(R.id.lblError);
        }

        if ( !validateRequired(txtPayment) ||
             !validateRequired(txtRate) ||
             !validateRequired(txtPeriods) ||
             !validateDouble(txtPayment)||
             !validateDouble(txtRate) ||
             !validateInteger(txtPeriods) )
            return false;
        return true;
    }//validate()

    private boolean validateRequired(EditText view) {
        if (view.getText().toString().trim().length()  > 0)
            return true;
        this.errorMessage = view.getTag() + " is a required value!";
        return false;
    }//validateRequired()

    private boolean validateInteger(EditText view) {
        try {
            Integer.parseInt(view.getText().toString().trim());
            return true;
        } catch (NumberFormatException e) {
            this.errorMessage = view.getTag() + " is not an Integer value!";
            return false;
        }

    }//validateInteger()

    private boolean validateDouble(EditText view) {
        try {
            Double.parseDouble(view.getText().toString().trim());
            return true;
        } catch (NumberFormatException e) {
            this.errorMessage = view.getTag() + " is not a valid decimal value!";
            return false;
        }

    }//validateInteger()

}
