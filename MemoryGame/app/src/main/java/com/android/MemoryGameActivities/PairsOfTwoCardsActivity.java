package com.android.MemoryGameActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.memory_game.app.AndroidGui;
import com.memory_game.app.GameManagers.GameManagerNormal;
import com.memory_game.app.R;
import com.memory_game.app.project.*;

public class PairsOfTwoCardsActivity extends AppCompatActivity {

    int num_buttons = 28;
    AndroidGui gui;

    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getApplicationContext();
        setContentView(R.layout.activity_main);
        gui = new AndroidGui(setLabels(), 28, buttons(), this);
        GameManagerNormal.InitGameManager(gui,2,1,28,'h','h');
    }

    /**
     * Αρχηκοποιεί τα JLabels.
     */
    protected TextView[] setLabels(){
        TextView[] labelsArray = new TextView[2];
        labelsArray[0] = (TextView) findViewById(R.id.ma_text1);
        labelsArray[1] = (TextView) findViewById(R.id.ma_text2);

        labelsArray[0].setText("Player 1:");
        labelsArray[1].setText("Player 2:");

        return labelsArray;
    }

    protected Button[] buttons(){
        Button[] buttonsArray = new Button[num_buttons];
        for(int i =0;i<num_buttons;i++){
            buttonsArray[i] = (Button) findViewById(R.id.card01+i);
            buttonsArray[i].setBackgroundResource(R.drawable.back_cover);
            //buttonsArray[i].setText("button"+i);
        }
        return buttonsArray;
    }

}
