package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.BackEnd.Learner;
import com.memory_game.app.R;

public class ModeSelection extends AppCompatActivity {
    private Learner learner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);
        learner = new Learner();
    }

    public void po2SelectionScreen(View view){
        Intent i=new Intent(this,SelectionScreen.class);
        i.putExtra("gameMode",1);
        startActivity(i);
    }
    public void po3SelectionScreen(View view){
        Intent i=new Intent(this,SelectionScreen.class);
        i.putExtra("gameMode",2);
        startActivity(i);
    }
    public void battleSelectionScreen(View view){
        Intent i=new Intent(this,SelectionScreen.class);
        i.putExtra("gameMode",3);
        startActivity(i);
    }







    public void goToMainMenu(View view){
        onBackPressed();
    }
}
