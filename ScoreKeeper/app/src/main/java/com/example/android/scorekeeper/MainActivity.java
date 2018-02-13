package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int TOUCHDOWN = 6;
    static final int EXTRAPOINT = 1;
    static final int FIELDGOAL = 3;
    static final int SAFETY = 2;

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    public void touchdownA(View view) {
        scoreTeamA = scoreTeamA + TOUCHDOWN;
        displayForTeamA(scoreTeamA);
    }

    public void extraPointA(View view) {
        scoreTeamA = scoreTeamA + EXTRAPOINT;
        displayForTeamA(scoreTeamA);
    }

    public void fieldGoalA(View view) {
        scoreTeamA = scoreTeamA + FIELDGOAL;
        displayForTeamA(scoreTeamA);
    }

    public void safetyA(View view) {
        scoreTeamA = scoreTeamA + SAFETY;
        displayForTeamA(scoreTeamA);
    }

    public void touchdownB(View view) {
        scoreTeamB = scoreTeamB + TOUCHDOWN;
        displayForTeamB(scoreTeamB);
    }

    public void extraPointB(View view) {
        scoreTeamB = scoreTeamB + EXTRAPOINT;
        displayForTeamB(scoreTeamB);
    }

    public void fieldGoalB(View view) {
        scoreTeamB = scoreTeamB + FIELDGOAL;
        displayForTeamB(scoreTeamB);
    }

    public void safetyB(View view) {
        scoreTeamB = scoreTeamB + SAFETY;
        displayForTeamB(scoreTeamB);
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

    }

}

