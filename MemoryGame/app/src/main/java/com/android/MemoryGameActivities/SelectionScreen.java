package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.BackEnd.Learner;
import com.android.BackEnd.Sector;
import com.android.Database.Player;
import com.memory_game.app.R;
import com.android.Database.DBHandler;
import com.android.Database.Player;

import java.io.Serializable;

public class SelectionScreen extends AppCompatActivity {
    private Learner learner;
    private int currentPlayer;
    private int numberOfPlayers;
    private int gameMode;
    private DBHandler db;
    private Player player;
    private String player1name;
    private String player2name;
    private boolean player2AIState;
    EditText playerName=findViewById(R.id.playerName);



    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        CharSequence playerNameText= playerName.getText();
        outState.putCharSequence("playerName",playerNameText);
        boolean AIState = learner.isAI();
        outState.putBoolean("AIState",AIState);
        Sector difficulty = learner.getSector();
        outState.putSerializable("difficulty",difficulty);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
        learner = new Learner();
        currentPlayer = 1;
        TextView tv = findViewById(R.id.playerOptions);
        Button previous = findViewById(R.id.previousButton);
        Button next= findViewById(R.id.nextButton);
        tv.setText("Player " + currentPlayer + ":");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            gameMode = extras.getInt("gameMode");
        }
        numberOfPlayers = 2;
        db = new DBHandler(this, null, null, 1);
        if(savedInstanceState!=null){
            CharSequence player= savedInstanceState.getCharSequence("playerName");
            boolean AIState=savedInstanceState.getBoolean("AIState");
            Serializable difficulty= savedInstanceState.getSerializable("difficulty");
            Sector playerDifficulty= (Sector) difficulty;
            playerName.setText(player);
            learner.setAI(AIState);
            learner.setSector(playerDifficulty);


        } else{
            playerName.setText("");
            learner.setAI(false);
            learner.setSector(Sector.e);
        }
    }

    public void checkBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        RadioButton rb1 = findViewById(R.id.radio_beginner);
        RadioButton rb2 = findViewById(R.id.radio_novice);
        RadioButton rb3 = findViewById(R.id.radio_expert);

        CharSequence message = "";
        if (checked) {
            message = "Player is AI";
            rb1.setClickable(true);
            rb2.setClickable(true);
            rb3.setClickable(true);
        } else {
            rb1.setClickable(false);
            rb2.setClickable(false);
            rb3.setClickable(false);

        }

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, message, duration);
        toast.show();
    }

    public void radioButtonClicked(View view) {
        RadioGroup difficulty = findViewById(R.id.difficulty_group);
        int rbid = difficulty.getCheckedRadioButtonId();
        CharSequence message = "";

        switch (rbid) {
            case R.id.radio_beginner:
                learner.setSector(Sector.e);
                message = "Beginner";
                break;
            case R.id.radio_novice:
                learner.setSector(Sector.n);
                message = "Novice";
                break;
            case R.id.radio_expert:
                learner.setSector(Sector.h);
                message = "Expert";
                break;
        }
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, message, duration);
        toast.show();

    }

    public void previousActivity(View view) {
        if (currentPlayer == 1) {
            onBackPressed();
        } else {
            EditText playerName = findViewById(R.id.playerName);
            CheckBox AICheck = findViewById(R.id.AICheckBox);
            RadioGroup difficulty = findViewById(R.id.difficulty_group);
            learner.setName(playerName.getText().toString());
            learner.setAI(AICheck.isChecked());
            player = db.findPlayer(playerName.getText().toString());
            if (player == null) {
                db.addNewPlayer(playerName.getText().toString());
            } else {
                player2name=playerName.getText().toString();
                if(!learner.isAI())
                    player2AIState=false;
                else player2AIState=true;

            }
            playerName.setText("");
            AICheck.setChecked(false);
            difficulty.clearCheck();
            currentPlayer--;


        }
    }
        public void nextActivity (View view){
            if (currentPlayer == numberOfPlayers) {
                switch (gameMode) {
                    case 1:
                        //Intent i = new Intent(this, PairsOfTwoCardsActivity.class);
                        //eisagwgi paiktwn
                        //startActivity(i);
                    case 2:
                        //code goes here
                        break;
                    case 3:
                        //code goes here
                        break;
                }
            } else {
                EditText playerName = findViewById(R.id.playerName);
                CheckBox AICheck = findViewById(R.id.AICheckBox);
                RadioGroup difficulty = findViewById(R.id.difficulty_group);
                learner.setName(playerName.getText().toString());
                learner.setAI(AICheck.isChecked());
                int rbid = difficulty.getCheckedRadioButtonId();
                switch (rbid) {
                    case R.id.radio_beginner:
                        learner.setSector(Sector.e);
                        break;
                    case R.id.radio_novice:
                        learner.setSector(Sector.n);
                        break;
                    case R.id.radio_expert:
                        learner.setSector(Sector.h);
                        break;
                }
                player = db.findPlayer(playerName.getText().toString());
                if (player == null) {
                    db.addNewPlayer(playerName.getText().toString());
                }
                else{
                    player1name=playerName.getText().toString();
                    if(!learner.isAI())
                        player2AIState=false;
                    else player2AIState=true;
                }
                playerName.setText("");
                AICheck.setChecked(false);
                difficulty.clearCheck();
                currentPlayer++;
            }

        }

    }