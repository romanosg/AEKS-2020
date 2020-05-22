package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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


//activity of selection screen. It allows user to give input data of both players

public class SelectionScreen extends AppCompatActivity {
    private Learner learner=new Learner();
    private int gameMode;
    private DBHandler db;
    private Player player1;
    private Player player2;
    EditText player1Name;
    EditText player2Name;
    RadioGroup difficultyRG;
    CheckBox AI;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;



    //creating the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
        Bundle extras = getIntent().getExtras();
        player1Name = findViewById(R.id.player1Name);
        player2Name = findViewById(R.id.player2Name);
        difficultyRG = findViewById(R.id.difficultygroup);
        AI = findViewById(R.id.AICheckBox);
        rb1 = findViewById(R.id.radio_beginner);
        rb2 = findViewById(R.id.radio_novice);
        rb3 = findViewById(R.id.radio_expert);
        if (extras != null) {
            gameMode = extras.getInt("gameMode");
        }
        db = new DBHandler(this, null, null, 1);
        if(savedInstanceState!=null){

            //retrieve the data
            CharSequence player1name=savedInstanceState.getCharSequence("player1");
            player1Name.setText(player1name);
            CharSequence player2name=savedInstanceState.getCharSequence("player2");
            player2Name.setText(player2name);
            boolean AIstate=savedInstanceState.getBoolean("AIState");
            AI.setChecked(AIstate);
            enableRadioGroup(AIstate);
            Serializable difficulty=savedInstanceState.getSerializable("difficulty");
            learner.setSector((Sector) difficulty);
        }
        else{
            //initialize the data
            AI.setChecked(false);
            rb1.setChecked(true);
            enableRadioGroup(false);
            player1Name.setText("Player 1");
            player2Name.setText("Player 2");
            learner.setAI(false);
            learner.setSector(Sector.e);
        }
    }


    //data to be saved if activity gets destroyed
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


    //functionality of checkbox
    public void checkBoxClicked(View view) {
        if (AI.isChecked()) {
            learner.setAI(true);
            enableRadioGroup(true);
        } else {
            learner.setAI(false);
            enableRadioGroup(false);
        }
    }

    //functionality that enables or disables all radiobuttons
    private void enableRadioGroup(boolean flag){
        rb1.setEnabled(flag);
        rb2.setEnabled(flag);
        rb3.setEnabled(flag);
    }


    //functionality of clicking a radiobutton
    public void radioButtonClicked(View view) {
        int rbid = difficultyRG.getCheckedRadioButtonId();
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
        int duration = Toast.LENGTH_SHORT;
    }

    public void previousActivity(View view) { onBackPressed(); }


    //class that sends data to the next upcoming activity, based on gameMode
    public void nextActivity (View view) {
        Log.d(null, "sending data");
        //checks if fields are empty to give default name
        if(TextUtils.isEmpty(player1Name.getText())){
            player1Name.setText("Player 1");
        }
        if(TextUtils.isEmpty(player1Name.getText())){
            player2Name.setText("Player 2");
        }

        //checks if player is not in db to be inserted
        player1=db.findPlayer(player1Name.getText().toString());
        if(player1==null)
            db.addNewPlayer(player1Name.getText().toString());
        if(!learner.isAI()){
            player2=db.findPlayer(player2Name.getText().toString());
            if(player2==null)
                db.addNewPlayer(player2Name.getText().toString());
        }

        //goes to activity based on the gameMode data
        switch (gameMode) {
            //goes to normal activity and sends specific data for pairs of 2 cards game
            case 1:
                Intent i=new Intent(this,NormalActivity.class);
                i.putExtra("player1Name",player1Name.getText().toString());
                i.putExtra("player2Name",player2Name.getText().toString());
                i.putExtra("AIState",learner.isAI());
                if(!learner.isAI()) {
                    i.putExtra("difficulty", 'p');
                    i.putExtra("num_of_bots", 0);
                }
                else{
                    int rbid = difficultyRG.getCheckedRadioButtonId();
                    switch (rbid) {
                        case R.id.radio_beginner:
                           i.putExtra("difficulty",'e');
                            break;
                        case R.id.radio_novice:
                            i.putExtra("difficulty",'n');
                            break;
                        case R.id.radio_expert:
                            i.putExtra("difficulty",'h');
                            break;
                    }
                }
                i.putExtra("normal",true);
                startActivity(i);
                break;
            //goes to normal activity and sends specific data for pairs of 3 cards game
            case 2:
                i= new Intent(this,NormalActivity.class);
                i.putExtra("player1Name",player1Name.getText().toString());
                i.putExtra("player2Name",player2Name.getText().toString());
                i.putExtra("AIState",learner.isAI());
                if(!learner.isAI()) {
                    i.putExtra("difficulty", 'p');
                    i.putExtra("num_of_bots", 0);
                }
                else{
                    i.putExtra("num_of_bots", 1);
                    int rbid = difficultyRG.getCheckedRadioButtonId();
                    switch (rbid) {
                        case R.id.radio_beginner:
                            i.putExtra("difficulty",'e');
                            break;
                        case R.id.radio_novice:
                            i.putExtra("difficulty",'n');
                            break;
                        case R.id.radio_expert:
                            i.putExtra("difficulty",'h');
                            break;
                    }
                }
                i.putExtra("isPairsOf2",false);
                startActivity(i);
                break;
            //goes to battle activity and sends specific data for battle game
            case 3:
                Log.d(null, player1Name.getText().toString());
                Log.d(null, player2Name.getText().toString());
                Log.d(null, ""+gameMode);
                Log.d(null, ""+learner.isAI());
                Log.d(null, ""+learner.getSector());
                i=new Intent(this,BattleActivity.class);
                i.putExtra("player1Name",player1Name.getText().toString());
                i.putExtra("player2Name",player2Name.getText().toString());
                i.putExtra("AIState",learner.isAI());
                if(!learner.isAI()) {
                    i.putExtra("difficulty", 'p');
                    i.putExtra("num_of_bots", 0);
                }
                else{
                    i.putExtra("num_of_bots", 1);
                    int rbid = difficultyRG.getCheckedRadioButtonId();
                    switch (rbid) {
                        case R.id.radio_beginner:
                            i.putExtra("difficulty",'e');
                            break;
                        case R.id.radio_novice:
                            i.putExtra("difficulty",'n');
                            break;
                        case R.id.radio_expert:
                            i.putExtra("difficulty",'h');
                            break;
                    }
                }
                startActivity(i);
                break;
        }
    }
    }