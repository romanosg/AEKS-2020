package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.memory_game.app.R;

//activity that shows the rules of the game modes
public class rulesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_page);
    }
    //fuctionality of back button that returns to the previous activity
    public void goToMainMenu(View view){
        onBackPressed();
    }
}
