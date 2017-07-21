package pl.lukaszkolacz.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextInput = (EditText) findViewById(R.id.editTextImput);
        Button buttonToUsd = (Button) findViewById(R.id.buttonToUsd);
        Button buttonToPln = (Button) findViewById(R.id.buttonToPln);
        final TextView textViewResult = (TextView) findViewById(R.id.textViewResult);

        buttonToUsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "USD was clicked!", Toast.LENGTH_SHORT).show();
                double input = Double.parseDouble(editTextInput.getText().toString());
                input /= 3.61;
                textViewResult.setText("Result: " + round(input, 2) + " PLN");
            }
        });

        buttonToPln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "PLN was clicked!", Toast.LENGTH_SHORT).show();
                double input = Double.parseDouble(editTextInput.getText().toString());
                input *= 3.61;
                textViewResult.setText("Result: " + round(input, 2) + " USD");
            }
        });
    }

    public String round(double numb, int precision) {
        return Double.toString(Math.round(numb * Math.pow(10, precision)) / Math.pow(10, precision));
    }
}
