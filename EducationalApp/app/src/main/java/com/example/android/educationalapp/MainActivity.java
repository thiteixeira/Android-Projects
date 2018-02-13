package com.example.android.educationalapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    int finalScore = 0;
    String emailBody = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void grade(View view) {

        /**
         *  Radio Button Questions
         */

        RadioButton questionOneRB = (RadioButton) findViewById(R.id.question1);
        Boolean isQuestionOneRight = questionOneRB.isChecked();

        if (isQuestionOneRight)
            finalScore += 1;

        RadioButton questionTwoRB = (RadioButton) findViewById(R.id.question2);
        Boolean isQuestionTwoRight = questionTwoRB.isChecked();

        if (isQuestionTwoRight)
            finalScore += 1;

        RadioButton questionThreeRB = (RadioButton) findViewById(R.id.question3);
        Boolean isQuestionThreeRight = questionThreeRB.isChecked();

        if (isQuestionThreeRight)
            finalScore += 1;

        RadioButton questionFourRB = (RadioButton) findViewById(R.id.question4);
        Boolean isQuestionFourRight = questionFourRB.isChecked();

        if (isQuestionFourRight)
            finalScore += 1;

        /**
         *  Checkbox Question
         */
        CheckBox champagne = (CheckBox) findViewById(R.id.champagne);
        Boolean isChampagneChecked = champagne.isChecked();

        CheckBox bordeaux = (CheckBox) findViewById(R.id.bordeaux);
        Boolean isBordeauxChecked = bordeaux.isChecked();

        CheckBox burgundy = (CheckBox) findViewById(R.id.burgundy);
        Boolean isBurgundyChecked = burgundy.isChecked();

        if (isChampagneChecked && isBordeauxChecked && isBurgundyChecked)
            finalScore += 1;

        /**
         *  EditText Question
         */
        EditText whiteWine = (EditText) findViewById(R.id.answer_6);
        String answerSix = whiteWine.getText().toString();

        if (answerSix.equals("Chardonnay") || answerSix.equals("chardonnay"))
            finalScore += 1;

        printGrade();
        constructMessage(finalScore);

        finalScore = 0; // This resets the global variable after the score is shown

    }

    public void printGrade(){
        if (finalScore == 6)
            Toast.makeText(this, getResources().getString(R.string.highScore) + finalScore, Toast.LENGTH_LONG).show();
        else if (finalScore == 4 || finalScore == 5)
            Toast.makeText(this, getResources().getString(R.string.goodScore) + finalScore, Toast.LENGTH_LONG).show();
        else if (finalScore == 2 || finalScore == 3)
            Toast.makeText(this, getResources().getString(R.string.averageScore) + finalScore, Toast.LENGTH_LONG).show();
        else if (finalScore == 1)
            Toast.makeText(this, getResources().getString(R.string.poorScore) + finalScore, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, getResources().getString(R.string.badScore) + finalScore, Toast.LENGTH_LONG).show();
    }

    public void constructMessage(int score){
        emailBody = "Your total score is: " + score + "\n";

    }

    public void submitScore(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your score for the Wine Quiz!");
        intent.putExtra(Intent.EXTRA_TEXT, emailBody);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }
}
