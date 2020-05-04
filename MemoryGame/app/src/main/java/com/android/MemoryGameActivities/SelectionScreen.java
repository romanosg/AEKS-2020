package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.BackEnd.Learner;
import com.android.BackEnd.Mode_Sector;
import com.android.BackEnd.Sector;
import com.memory_game.app.R;

public class SelectionScreen extends AppCompatActivity {
    private Learner learner;
    private int currentPlayer;
    private int numberOfPlayers;
    private CharSequence gameMode;
    private CharSequence playerNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
        learner = new Learner();
        currentPlayer=1;
        TextView tv = findViewById(R.id.playerOptions);
        tv.setText("Player " + currentPlayer +":");

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            gameMode=  extras.getCharSequence("gameMode");
            playerNumber= extras.getCharSequence("playerNumber");
        }
        if(playerNumber=="TWO_PLAYERS")
            numberOfPlayers=2;
        else if(playerNumber=="THREE_PLAYERS")
            numberOfPlayers=3;
        else if(playerNumber=="FOUR_PLAYERS")
            numberOfPlayers=4;
    }

    public void checkBoxClicked(View view){
        boolean checked=((CheckBox) view).isChecked();
        RadioButton rb1=findViewById(R.id.radio_beginner);
        RadioButton rb2=findViewById(R.id.radio_novice);
        RadioButton rb3=findViewById(R.id.radio_expert);

        CharSequence message="";
        if(checked) {
            message = "Player is AI";
            rb1.setClickable(true);
            rb2.setClickable(true);
            rb3.setClickable(true);
        }
        else{
            rb1.setClickable(false);
            rb2.setClickable(false);
            rb3.setClickable(false);

        }

        int duration= Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(this,message,duration);
        toast.show();
    }
    public void radioButtonClicked(View view){
        RadioGroup difficulty = findViewById(R.id.difficulty_group);
        int rbid= difficulty.getCheckedRadioButtonId();
        CharSequence message="";

        switch(rbid){
            case R.id.radio_beginner:
                learner.setSector(Sector.BEGINNER);
                message="Beginner";
                break;
            case R.id.radio_novice:
                learner.setSector(Sector.NOVICE);
                message="Novice";
                break;
            case R.id.radio_expert:
                learner.setSector(Sector.EXPERT);
                message="Expert";
                break;
        }
        int duration= Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(this,message,duration);
        toast.show();

    }
    public void previousActivity(View view){
        if(currentPlayer==1){
            onBackPressed();
        } else{
            EditText playerName= findViewById(R.id.playerName);
            CheckBox AICheck=findViewById(R.id.AICheckBox);
            RadioGroup difficulty=findViewById(R.id.difficulty_group);
            learner.setName(playerName.getText().toString());
            learner.setAI(AICheck.isChecked());
            int rbid= difficulty.getCheckedRadioButtonId();

            switch(rbid){
                case R.id.radio_beginner:
                    learner.setSector(Sector.BEGINNER);
                    break;
                case R.id.radio_novice:
                    learner.setSector(Sector.NOVICE);
                    break;
                case R.id.radio_expert:
                    learner.setSector(Sector.EXPERT);
                    break;
            }
            //apothikeusi paikti stin BD
            playerName.setText("");
            AICheck.setChecked(false);
            difficulty.clearCheck();
            currentPlayer--;

        }
    }
    public void nextActivity(View view){
        if(currentPlayer==numberOfPlayers){
            //metavasi sto game
        } else{
            EditText playerName= findViewById(R.id.playerName);
            CheckBox AICheck=findViewById(R.id.AICheckBox);
            RadioGroup difficulty=findViewById(R.id.difficulty_group);
            learner.setName(playerName.getText().toString());
            learner.setAI(AICheck.isChecked());
            int rbid= difficulty.getCheckedRadioButtonId();

            switch(rbid){
                case R.id.radio_beginner:
                    learner.setSector(Sector.BEGINNER);
                    break;
                case R.id.radio_novice:
                    learner.setSector(Sector.NOVICE);
                    break;
                case R.id.radio_expert:
                    learner.setSector(Sector.EXPERT);
                    break;
            }
            //apothikeusi paikti stin BD
            playerName.setText("");
            AICheck.setChecked(false);
            difficulty.clearCheck();
            currentPlayer++;
        }

    }
}
