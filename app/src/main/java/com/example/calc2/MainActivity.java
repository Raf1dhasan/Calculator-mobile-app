package com.example.calc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    Button buttonAdd ,buttonSub, buttonMul, buttonDiv, buttonMod, buttonPercentage, buttonPow, buttonClear;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd=findViewById(R.id.btn_add);
        buttonSub=findViewById(R.id.btn_sub);
        buttonMul=findViewById(R.id.btn_mul);
        buttonDiv=findViewById(R.id.btn_div);
        buttonMod=findViewById(R.id.btn_mod);
        buttonPercentage=findViewById(R.id.btn_percent);
        buttonPow=findViewById(R.id.btn_pow);
        buttonClear=findViewById(R.id.btn_Clear);
        editTextN1=findViewById(R.id.number1);
        editTextN2=findViewById(R.id.number2);
        textView=findViewById(R.id.answer);
        
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMod.setOnClickListener(this);
        buttonPercentage.setOnClickListener(this);
        buttonPow.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

        
    }
    public float getFloatFromEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
            return 0.0f; // Return a default value (0.0) for an empty input
        } else {
            try {
                return Float.parseFloat(editText.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
                return 0.0f; // Return a default value (0.0) for invalid input
            }
        }
    }
    @Override
    public void onClick(View view) {
        float num1 = getFloatFromEditText(editTextN1);
        float num2 = getFloatFromEditText(editTextN2);

        if (view.getId() == R.id.btn_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (view.getId() == R.id.btn_sub) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (view.getId() == R.id.btn_mul) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (view.getId() == R.id.btn_div) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText("Answer = " + ((float) num1 / (float) num2));
            }
        } else if (view.getId() == R.id.btn_mod) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot calculate modulus with zero divisor", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText("Answer = " + (num1 % num2));
            }
        } else if (view.getId() == R.id.btn_percent) {
            textView.setText("Answer = " + (num1 * num2 / 100));
        } else if (view.getId() == R.id.btn_pow) {
            double result = Math.pow(num1, num2);
            textView.setText("Answer = " + result);
        } else if (view.getId() == R.id.btn_Clear) {
            // Clear input fields and result
            editTextN1.setText("");
            editTextN2.setText("");
            textView.setText("");
        }
    }

}

