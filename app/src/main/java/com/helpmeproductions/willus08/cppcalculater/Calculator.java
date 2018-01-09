package com.helpmeproductions.willus08.cppcalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    String displayedNumber = "";
    boolean operationUsed = false;
    String currentOperation= "";
    int savedNumber;
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
    public native int sumFromJNI(int a, int b);
    public native int diffFromJNI(int a, int b);
    public native int prodFromJNI(int a, int b);
    public native int quoteFromJNI(int a, int b);

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
                savedNumber = Integer.parseInt(displayedNumber);
                displayedNumber ="";
                operationUsed = true;
                currentOperation = "Add";
                break;
            case R.id.btnCalculatorDiff:
                equalbuttonPressed();
                savedNumber = Integer.parseInt(displayedNumber);
                displayedNumber ="";
                operationUsed = true;
                currentOperation = "Sub";
                break;
            case R.id.btnCalculatorMult:
                equalbuttonPressed();
                if(!displayedNumber.equals("")){
                savedNumber = Integer.parseInt(displayedNumber);
                displayedNumber ="";
                }
                operationUsed = true;
                currentOperation = "Mult";
                break;
            case R.id.btnCalculatorDiv:
                equalbuttonPressed();
                if(!displayedNumber.equals("")) {
                    savedNumber = Integer.parseInt(displayedNumber);
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
            int temp = 0;
            if(!displayedNumber.equals("")){
                switch (currentOperation) {
                    case "Add":
                        temp = sumFromJNI(savedNumber, Integer.parseInt(displayedNumber));
                        break;
                    case "Sub":
                        temp = diffFromJNI(savedNumber, Integer.parseInt(displayedNumber));
                        break;
                    case "Mult":
                        temp = prodFromJNI(savedNumber, Integer.parseInt(displayedNumber));
                        break;
                    case "Div":
                        if (Integer.parseInt(displayedNumber) == 0) {
                            displayedNumber = "error! division by zero";
                        } else {
                            temp = quoteFromJNI(savedNumber, Integer.parseInt(displayedNumber));
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
