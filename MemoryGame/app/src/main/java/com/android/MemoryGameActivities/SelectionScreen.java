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
    private Learner learner=new Learner();
    private int gameMode;
    private DBHandler db;
    private Player player1;
    private Player player2;
    EditText player1Name = findViewById(R.id.player1Name);
    EditText player2Name = findViewById(R.id.player2Name);


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        CharSequence player1name=player1Name.getText();
        outState.putCharSequence("player1",player1name);
        CharSequence player2name=player2Name.getText();
        outState.putCharSequence("player2",player2name);
        boolean AIstate=learner.isAI();
        outState.putBoolean("AIState",AIstate);
        Sector difficulty= learner.getSector();
        outState.putSerializable("difficulty",difficulty);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            gameMode = extras.getInt("gameMode");
        }
        db = new DBHandler(this, null, null, 1);
        if(savedInstanceState!=null){
            CharSequence player1name=savedInstanceState.getCharSequence("player1");
            player1Name.setText(player1name);
            CharSequence player2name=savedInstanceState.getCharSequence("player2");
            player2Name.setText(player2name);
            boolean AIstate=savedInstanceState.getBoolean("AIState");
            learner.setAI(AIstate);
            Serializable difficulty=savedInstanceState.getSerializable("difficulty");
            learner.setSector((Sector) difficulty);
        }
        else{
            player1Name.setText("");
            player2Name.setText("");
            learner.setAI(false);
            learner.setSector(Sector.e);
        }
    }

    public void checkBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        CheckBox AI = findViewById(R.id.AICheckBox);
        RadioButton rb1 = findViewById(R.id.radio_beginner);
        RadioButton rb2 = findViewById(R.id.radio_novice);
        RadioButton rb3 = findViewById(R.id.radio_expert);
        CharSequence message = "";
        if (checked) {
            message = "Player is AI";
            rb1.setEnabled(true);
            rb2.setEnabled(true);
            rb3.setEnabled(true);
        } else {
            rb1.setEnabled(false);
            rb2.setEnabled(false);
            rb3.setEnabled(false);
        }
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, message, duration);
        toast.show();
    }


    public void radioButtonClicked(View view) {
        RadioGroup difficulty = findViewById(R.id.difficultygroup);
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

    public void previousActivity(View view) { onBackPressed(); }


    public void nextActivity (View view) {
        player1=db.findPlayer(player1Name.getText().toString());
        if(player1==null)
            db.addNewPlayer(player1Name.getText().toString());
        if(!learner.isAI()){
            player2=db.findPlayer(player2Name.getText().toString());
            if(player2==null)
                db.addNewPlayer(player2Name.getText().toString());
        }
        switch (gameMode) {
            case 1:
                Intent i=new Intent(this,NormalActivity.class);
                i.putExtra("player1Name",player1Name.getText());
                i.putExtra("player2Name",player2Name.getText());
                i.putExtra("AIState",learner.isAI());
                if(!learner.isAI())
                    i.putExtra("difficulty","p");
                else{
                    RadioGroup difficulty = findViewById(R.id.difficultygroup);
                    int rbid = difficulty.getCheckedRadioButtonId();
                    switch (rbid) {
                        case R.id.radio_beginner:
                           i.putExtra("difficulty","e");
                            break;
                        case R.id.radio_novice:
                            i.putExtra("difficulty","n");
                            break;
                        case R.id.radio_expert:
                            i.putExtra("difficulty","h");
                            break;
                    }
                }
                i.putExtra("isPairsOf2",true);
                startActivity(i);
                break;
            case 2:
                i=new Intent(this,NormalActivity.class);
                i.putExtra("player1Name",player1Name.getText());
                i.putExtra("player2Name",player2Name.getText());
                i.putExtra("AIState",learner.isAI());
                if(!learner.isAI())
                    i.putExtra("difficulty","p");
                else{
                    RadioGroup difficulty = findViewById(R.id.difficultygroup);
                    int rbid = difficulty.getCheckedRadioButtonId();
                    switch (rbid) {
                        case R.id.radio_beginner:
                            i.putExtra("difficulty","e");
                            break;
                        case R.id.radio_novice:
                            i.putExtra("difficulty","n");
                            break;
                        case R.id.radio_expert:
                            i.putExtra("difficulty","h");
                            break;
                    }
                }
                i.putExtra("isPairsOf2",false);
                startActivity(i);
                break;
            case 3:
                i=new Intent(this,BattleActivity.class);
                i.putExtra("player1Name",player1Name.getText());
                i.putExtra("player2Name",player2Name.getText());
                i.putExtra("AIState",learner.isAI());
                if(!learner.isAI())
                    i.putExtra("difficulty","p");
                else{
                    RadioGroup difficulty = findViewById(R.id.difficultygroup);
                    int rbid = difficulty.getCheckedRadioButtonId();
                    switch (rbid) {
                        case R.id.radio_beginner:
                            i.putExtra("difficulty","e");
                            break;
                        case R.id.radio_novice:
                            i.putExtra("difficulty","n");
                            break;
                        case R.id.radio_expert:
                            i.putExtra("difficulty","h");
                            break;
                    }
                }
                break;

        }
    }
    }