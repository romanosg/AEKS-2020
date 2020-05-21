package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.BackEnd.Learner;
import com.memory_game.app.R;

//activity that gives the option regarding gamemode
public class ModeSelection extends AppCompatActivity {
    private Learner learner;

    //creating the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);
        learner = new Learner();
    }

    //going to selectionscreen with unique gamemodeid=1
    public void po2SelectionScreen(View view){
        Intent i=new Intent(this,SelectionScreen.class);
        i.putExtra("gameMode", 1);
        startActivity(i);
    }

    //going to selectionscreen with unique gamemodeid=2
    public void po3SelectionScreen(View view){
        Intent i=new Intent(this,SelectionScreen.class);
        i.putExtra("gameMode",2);
        startActivity(i);
    }

    //going to selectionscreen with unique gamemodeid=1
    public void battleSelectionScreen(View view){
        Intent i=new Intent(this,SelectionScreen.class);
        i.putExtra("gameMode",3);

        startActivity(i);
    }

    //functionality of back button that returns to the previous activity
    public void goToMainMenu(View view){
        onBackPressed();
    }
}
