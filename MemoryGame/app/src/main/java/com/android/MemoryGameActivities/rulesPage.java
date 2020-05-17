package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.memory_game.app.R;

public class rulesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_page);
    }
    public void goToMainMenu(View view){
        onBackPressed();
    }
}
