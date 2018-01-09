package com.helpmeproductions.willus08.cppcalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    String displayedNumber = "";
    boolean operationUsed = false;
    String currentOperation= "";
    double savedNumber;
    TextView display;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        display = (TextView) findViewById(R.id.tvCScreen);
        // Example of a call to a nat

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native double sumFromJNI(double a, double b);
    public native double diffFromJNI(double a, double b);
    public native double prodFromJNI(double a, double b);
    public native double quoteFromJNI(double a, double b);

    public void buttonPressed(View view) {
        switch (view.getId()){
            case R.id.btnCalculator0:
                displayedNumber += 0;
                break;
            case R.id.btnCalculator1:
                displayedNumber +=1;
                break;
            case R.id.btnCalculator2:
                displayedNumber += 2;
                break;
            case R.id.btnCalculator3:
                displayedNumber += 3;
                break;
            case R.id.btnCalculator4:
                displayedNumber += 4;
                break;
            case R.id.btnCalculator5:
                displayedNumber +=5;
                break;
            case R.id.btnCalculator6:
                displayedNumber += 6;
                break;
            case R.id.btnCalculator7:
                displayedNumber += 7;
                break;
            case R.id.btnCalculator8:
                displayedNumber += 8;
                break;
            case R.id.btnCalculator9:
                displayedNumber += 9;
                break;
            case R.id.btnCalculatorEqual:
                equalbuttonPressed();
                break;
            case R.id.btnCalculatorAdd:
                equalbuttonPressed();
                savedNumber = Double.parseDouble(displayedNumber);
                displayedNumber ="";
                operationUsed = true;
                currentOperation = "Add";
                break;
            case R.id.btnCalculatorDiff:
                equalbuttonPressed();
                savedNumber = Double.parseDouble(displayedNumber);
                displayedNumber ="";
                operationUsed = true;
                currentOperation = "Sub";
                break;
            case R.id.btnCalculatorMult:
                equalbuttonPressed();
                if(!displayedNumber.equals("")){
                savedNumber = Double.parseDouble(displayedNumber);
                displayedNumber ="";
                }
                operationUsed = true;
                currentOperation = "Mult";
                break;
            case R.id.btnCalculatorDiv:
                equalbuttonPressed();
                if(!displayedNumber.equals("")) {
                    savedNumber = Double.parseDouble(displayedNumber);
                    displayedNumber = "";
                }
                operationUsed = true;
                currentOperation = "Div";
                break;
            case R.id.btnCalculatorClear:
                savedNumber = 0;
                displayedNumber = "";
                currentOperation = "";
                operationUsed = false;
        }

        display.setText(displayedNumber);

    }

    private void equalbuttonPressed() {
        if (operationUsed) {
            double temp = 0;
            if(!displayedNumber.equals("")){
                switch (currentOperation) {
                    case "Add":
                        temp = sumFromJNI(savedNumber, Double.parseDouble(displayedNumber));
                        break;
                    case "Sub":
                        temp = diffFromJNI(savedNumber, Double.parseDouble(displayedNumber));
                        break;
                    case "Mult":
                        temp = prodFromJNI(savedNumber, Double.parseDouble(displayedNumber));
                        break;
                    case "Div":
                        if (Double.parseDouble(displayedNumber) == 0) {
                            displayedNumber = "error! division by zero";
                        } else {
                            temp = quoteFromJNI(savedNumber, Double.parseDouble(displayedNumber));
                        }
                        break;
                }
                displayedNumber = "" + temp;
                operationUsed = false;
                currentOperation = "";
            }
        }
    }
}
