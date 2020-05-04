package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.BackEnd.Learner;
import com.android.BackEnd.Mode_Sector;
import com.android.BackEnd.Player_Sector;
import com.android.BackEnd.Sector;
import com.memory_game.app.R;

public class ModeSelection extends AppCompatActivity {
    private Learner learner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);
        learner = new Learner();
    }


    public void chooseGameMode(View view){
        RadioGroup modes = findViewById(R.id.mode_group);
        RadioButton rb1=findViewById(R.id.radio_3_players);
        RadioButton rb2=findViewById(R.id.radio_4_players);
        int rbid= modes.getCheckedRadioButtonId();
        CharSequence message="";
        switch(rbid){
            case R.id.radio_po2:
                message="Pairs Of 2";
                learner.setMode_sector(Mode_Sector.PAIRS_OF_2);
                rb1.setClickable(true);
                rb2.setClickable(true);
                break;
            case R.id.radio_po3:
                learner.setMode_sector(Mode_Sector.PAIRS_OF_3);
                message="Pairs Of 3";
                rb1.setClickable(true);
                rb2.setClickable(true);
                break;
            case R.id.radio_battle:
                learner.setMode_sector(Mode_Sector.BATTLE);
                message="1v1 Battle";
                rb1.setClickable(false);
                rb2.setClickable(false);
                break;
        }
        int duration= Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(this,message,duration);
        toast.show();
    }

    public void choosePlayers(View view){
        RadioGroup players = findViewById(R.id.player_group);
        int rbid= players.getCheckedRadioButtonId();
        CharSequence message="";

        switch(rbid){
            case R.id.radio_2_players:
                learner.setPlayer_sector(Player_Sector.TWO_PLAYERS);
                message="2 Players";
                break;
            case R.id.radio_3_players:
                learner.setPlayer_sector(Player_Sector.THREE_PLAYERS);
                message="3 Players";
                break;
            case R.id.radio_4_players:
                learner.setPlayer_sector(Player_Sector.FOUR_PLAYERS);
                message="4 Players";
                break;
        }
        int duration= Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(this,message,duration);
        toast.show();
    }
    public void submitSelections(View view){
        RadioGroup modes = findViewById(R.id.mode_group);
        RadioGroup players = findViewById(R.id.player_group);
        int rbid= modes.getCheckedRadioButtonId();
        switch(rbid){
            case R.id.radio_po2:
                learner.setMode_sector(Mode_Sector.PAIRS_OF_2);
                break;
            case R.id.radio_po3:
                learner.setMode_sector(Mode_Sector.PAIRS_OF_3);
                break;
            case R.id.radio_battle:
                learner.setMode_sector(Mode_Sector.BATTLE);
                break;
        }
        rbid=players.getCheckedRadioButtonId();
        switch(rbid){
            case R.id.radio_2_players:
                learner.setPlayer_sector(Player_Sector.TWO_PLAYERS);
                break;
            case R.id.radio_3_players:
                learner.setPlayer_sector(Player_Sector.THREE_PLAYERS);
                break;
            case R.id.radio_4_players:
                learner.setPlayer_sector(Player_Sector.FOUR_PLAYERS);
                break;
        }

        Intent i= new Intent(this, SelectionScreen.class);
        i.putExtra("gameMode","" + learner.getMode_sector());
        i.putExtra("playerNumber","" + learner.getPlayer_sector());
        startActivity(i);
    }
    public void goToMainMenu(View view){
        onBackPressed();
    }
}
