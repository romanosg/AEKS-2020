package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.memory_game.app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view){
        Intent i = new Intent(this,ModeSelection.class);
        startActivity(i);
    }

    public void rulesActivity(View view){
        Intent i= new Intent(this,Rules.class);
        startActivity(i);
    }
    public void highScoresActivity(View view){
        Intent i = new Intent(this,Highscores.class);
        startActivity(i);
    }
    public void findPlayerActivity(View view){
        Intent i = new Intent(this,findPlayerActivity.class);
        startActivity(i);

    }

    public void exitApplication(View view){
        Intent i= new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }




}
