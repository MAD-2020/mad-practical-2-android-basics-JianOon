package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private TextView Scores;
    private int ran;
    private int score;
    private static final String TAG = "ButtonActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Whack-A-Mole");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonLeft = (Button) findViewById(R.id.LeftButton);
        ButtonRight = (Button) findViewById(R.id.RightButton);
        ButtonMiddle = (Button) findViewById(R.id.MiddleButton);
        Scores = (TextView) findViewById(R.id.scores);
        score = 0;
        ran = setNewMole();
        Scores.setText(Integer.toString(score));
        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG,"Left Button Clicked!");
                if(ran == 0){
                    score = score +1;
                    Log.v(TAG,"Hit, score added!");
                }
                else{
                    score = score -1;
                    Log.v(TAG, "Missed, score deducted!");
                }
                Scores.setText(Integer.toString(score));
                ran = setNewMole();

            }
        });
        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG,"Middle Button Clicked!");
                if(ran == 1){
                    score = score +1;
                    Log.v(TAG,"Hit, score added!");
                }
                else{
                    score = score -1;
                    Log.v(TAG, "Missed, score deducted!");
                }
                Scores.setText(Integer.toString(score));
                ran = setNewMole();
            }
        });
        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG,"Right Button Clicked!");
                if(ran == 2){
                    score = score +1;
                    Log.v(TAG,"Hit, score added!");
                }
                else{
                    score = score -1;
                    Log.v(TAG, "Missed, score deducted!");
                }
                Scores.setText(Integer.toString(score));
                ran = setNewMole();

            }
        });
    }
    public int setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if(randomLocation == 0){
            ButtonLeft.setText("*");
            ButtonMiddle.setText("O");
            ButtonRight.setText("O");
        }
        else if(randomLocation == 1){
            ButtonMiddle.setText("*");
            ButtonLeft.setText("O");
            ButtonRight.setText("O");
        }
        else{
            ButtonRight.setText("*");
            ButtonMiddle.setText("O");
            ButtonLeft.setText("O");
        }
        return randomLocation;

    }


}
