package com.luciarigoni.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHeight;
    private SeekBar seekBarWeight;
    private TextView textViewWeight;
    private TextView textViewResult;

    private double weight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        seekBarWeight = findViewById(R.id.seekBarWeight);
        textViewWeight = findViewById(R.id.textViewWeight);
        textViewResult = findViewById(R.id.textViewResult);



        seekBarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weight = progress;
                textViewWeight.setText(Math.round(weight) + " kg");
                calculateBMI();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calculateBMI(){
        String text = editTextHeight.getText().toString();
        if(text == null || text.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro!", Toast.LENGTH_LONG);
        } else {
            double valorDigitado = Double.parseDouble(text);

            double bmi = weight / (valorDigitado * valorDigitado);
            textViewResult.setText(" " + Math.round(bmi));
        }
    }
}