package com.huy.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random r = new Random();
    int low = 1;
    int high = 100;
    int value1 = r.nextInt(high-low) + low;
    int value2 = r.nextInt(high-low) + low;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Number1 = findViewById(R.id.Number1);
        Number1.setText(""+value1);
        TextView Number2 = findViewById(R.id.Number2);
        Number2.setText(""+value2);
    }

    public void onSubmitClick (View view){
        TextView Answer = findViewById(R.id.Answer);
        EditText Attempt = findViewById(R.id.Attempt);
        int userAnswer = Integer.parseInt(Attempt.getText().toString());
        if(userAnswer == value1+value2) {
            Answer.setText("Correct!");

        } else {
            Answer.setText("Wrong, the correct answer was: " + (value1+value2));
        }
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception ignored) {
        }

        updateValues();
    }

    public void updateValues() {
        value1 = r.nextInt(high-low) + low;
        TextView Number1 = findViewById(R.id.Number1);
        Number1.setText(""+value1);

        value2 = r.nextInt(high-low) + low;
        TextView Number2 = findViewById(R.id.Number2);
        Number2.setText(""+value2);
    }

}