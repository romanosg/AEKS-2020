package com.memory_game.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import com.memory_game.app.GameManagers.GameManagerNormal;
import com.memory_game.app.GameManagers.GameManagerMod4;
import com.memory_game.app.GameManagers.GameManagerMod8;
import com.memory_game.app.project.*;

public class NormalActivity extends Activity {
	
int num_buttons;
AndroidGui gui;
int num_players;
int num_bots;
boolean normal = false;

	private static Context context;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = getApplicationContext();
      char bota = 'e';
      char botb = 'e';
      char botc = 'e';
      num_players = getIntent().getIntExtra("num_of_players", 2);
      num_bots = getIntent().getIntExtra("num_of_bots", 1);
      normal = getIntent().getBooleanExtra("normal", true);
      if(!normal){
          num_buttons=24;
          setContentView(R.layout.cards3);
      }
      else{
          num_buttons=28;
          setContentView(R.layout.normal);
      }
      if(num_bots>0) bota = getIntent().getCharExtra("bota", 'e');
      if(num_bots>1) botb = getIntent().getCharExtra("botb", 'e');
      if(num_bots>2) botc = getIntent().getCharExtra("botc", 'e');
      //gui = new AndroidGui(setLabels(), num_buttons, buttons(), this, false, 'n');
      if(!normal){
          gui = new AndroidGui(setLabels(), num_buttons, buttons(), this, false, '6', false);
          if(num_bots==1)GameManagerMod4.InitGameManager(gui,num_players,num_bots,num_buttons,bota);
          else if(num_bots==2)GameManagerMod4.InitGameManager(gui,num_players,num_bots,num_buttons,bota,botb);
          else if(num_bots==3)GameManagerMod4.InitGameManager(gui,num_players,num_bots,num_buttons,bota,botb,botc);
      }
      else{
          gui = new AndroidGui(setLabels(), num_buttons, buttons(), this, false, 'n', true);
          if(num_bots==1)GameManagerNormal.InitGameManager(gui,num_players,num_bots,num_buttons,bota);
          else if(num_bots==2)GameManagerNormal.InitGameManager(gui,num_players,num_bots,num_buttons,bota,botb);
          else if(num_bots==3)GameManagerNormal.InitGameManager(gui,num_players,num_bots,num_buttons,bota,botb,botc);
      }
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
    		if(normal)buttonsArray[i] = (Button) findViewById(R.id.card01+i);
                else buttonsArray[i] = (Button) findViewById(R.id.card_3_01+i);
    		buttonsArray[i].setBackgroundResource(R.drawable.back_cover);
    		//buttonsArray[i].setText("button"+i);
    		}
        return buttonsArray;
    }

}
