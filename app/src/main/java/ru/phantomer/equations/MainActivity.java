package ru.phantomer.equations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstInput;
    private EditText secondInput;
    private EditText thirdInput;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstInput = findViewById(R.id.editText2);
        secondInput = findViewById(R.id.editText3);
        thirdInput = findViewById(R.id.editText4);
        output = findViewById(R.id.textView);
    }


    public void calculate(View view) {
        if (firstInput.getText().toString().isEmpty() || secondInput.getText().toString().isEmpty()
                || thirdInput.getText().toString().isEmpty()) {
            output.setText("Введите коэффициенты!");
            return;
        }

        else {
            double a = (Double.parseDouble(firstInput.getText().toString()));
            double b = (Double.parseDouble(secondInput.getText().toString()));
            double bPov = Math.pow(b, 2);
            double c = (Double.parseDouble(thirdInput.getText().toString()));
            double D = bPov - 4 * a * c;

             if (a == 0 & b == 0 & c == 0) {
                 output.setText("Введите коэффициенты!");
                 return;
             }
              else if (a==0 & b!=0 & c!=0) {
                     double x11 = (-1 * c / b);
                     output.setText("x1= " + x11);
                 }

              else if (a!=0 & b==0 & c==0)
                    output.setText ("x1=0");

             else if (a!=0 & b!=0 & c!=0 & D < 0) {
                output.setText("D<0, дальнейшие вычисления невозможны");
                return;
            }
            else if (a!=0 & b!=0 & c!=0 & D > 0){
                double dKoren = Math.sqrt(D);
                double x1 = ((-1*b) + dKoren)/(2*a);
                double x2 = ((-1*b) - 1*dKoren)/(2*a);
                output.setText("x1= " + x1 +"\n"+"x2= " + x2);
            }
        }
    }

}
