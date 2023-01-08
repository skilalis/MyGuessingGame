package com.example.myguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button checkButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextId);
        checkButton = findViewById(R.id.checkButtonId);
        resultTextView = findViewById(R.id.resultTextViewId);

        checkButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String guessString = editText.getText().toString();


        if (guessString.isEmpty()) {
            errorMessage();
        }else {
            int guess = Integer.parseInt(guessString);
            if (guess>5){

                errorMessage();
            }


            Random random = new Random();
            int randomNumber = random.nextInt(5)+1;
            if (randomNumber==guess)
            {
                resultTextView.setText("Congrats !!! You have own");
            }else
            {
                resultTextView.setText("Sorry !!! you have lost. Randon number was "+randomNumber);
            }
            
        }

        
    }
    void errorMessage(){
        editText.setError("please enter an valid input");
        editText.requestFocus();
        return;
    }
}