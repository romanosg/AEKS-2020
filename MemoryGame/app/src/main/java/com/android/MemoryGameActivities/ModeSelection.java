package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.memory_game.app.R;

public class ModeSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);
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
                rb1.setClickable(true);
                rb2.setClickable(true);
                break;
            case R.id.radio_po3:
                message="Pairs Of 3";
                rb1.setClickable(true);
                rb2.setClickable(true);
                break;
            case R.id.radio_battle:
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
                message="2 Players";
                break;
            case R.id.radio_3_players:
                message="3 Players";
                break;
            case R.id.radio_expert:
                message="4 Players";
                break;
        }
        int duration= Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(this,message,duration);
        toast.show();
    }
    public void submitSelections(View view){
        //code goes here
    }
}
