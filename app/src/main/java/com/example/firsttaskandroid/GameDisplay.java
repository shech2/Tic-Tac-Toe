package com.example.firsttaskandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);
        Button playAgainButton = findViewById(R.id.homeBTN);
        Button homeBTN = findViewById(R.id.playAgainBTN);
        TextView playerTurn = findViewById(R.id.playerDisplay);

        playAgainButton.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        String[] playerNames = getIntent().getStringArrayExtra("Player names");

        if(playerNames != null)
        {
            playerTurn.setText((playerNames[0] + "'s turn"));
        }
        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainButton, homeBTN, playerTurn, playerNames);

    }

    public void playAgainButtonClick(View view)
    {
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();

    }

    public void homeButtonClick(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}