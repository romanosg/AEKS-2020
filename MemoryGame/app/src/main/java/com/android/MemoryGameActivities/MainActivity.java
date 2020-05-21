package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import com.memory_game.app.R;
// the main and startup activity of the app. It shows the basic options
public class MainActivity extends AppCompatActivity {

    //creating main activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //going into modeselection activity
    public void startGame(View view){
        Intent i = new Intent(this,ModeSelection.class);
        startActivity(i);
    }

    //going into rules activity
    public void rulesActivity(View view){
        Intent i= new Intent(this,rulesPage.class);
        startActivity(i);
    }

    //going to highscores activity
    public void highScoresActivity(View view){
        Intent i = new Intent(this, Highscores.class);
        startActivity(i);
    }

    //going to findplayer activity
    public void findPlayerActivity(View view){
        Intent i = new Intent(this,findPlayerActivity.class);
        startActivity(i);
    }

    //exiting application by pressing this button
    public void exitApplication(View view){
        Intent i= new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }




}
