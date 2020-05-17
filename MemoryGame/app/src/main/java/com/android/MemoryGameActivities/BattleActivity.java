package com.android.MemoryGameActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import com.android.BackEnd.AndroidGui;
import com.android.BackEnd.GameManagers.GameManagerMod8;
import com.memory_game.app.R;


public class BattleActivity extends Activity {
	
int num_buttons = 28;
AndroidGui gui;

	private static Context context;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = getApplicationContext();
      setContentView(R.layout.battle);
      char bota = 'e', botb = 'e', botc = 'e';
      gui = new AndroidGui(setLabels(), 28, buttons(), this, true, 'b', false);
      //GameManagerMod8.InitGameManager(gui,2,1,14,'h','h');
      int num_bots = getIntent().getIntExtra("num_of_bots", 1);
      if(num_bots>0) bota = getIntent().getCharExtra("bota", 'e');
      if(num_bots>1) botb = getIntent().getCharExtra("botb", 'e');
      if(num_bots>2) botc = getIntent().getCharExtra("botc", 'e');
      if(num_bots==1)GameManagerMod8.InitGameManager(gui,2,num_bots,14,bota);
      else if(num_bots==2)GameManagerMod8.InitGameManager(gui,2,num_bots,14,bota,botb);
      else if(num_bots==3)GameManagerMod8.InitGameManager(gui,2,num_bots,14,bota,botb,botc);
   }
     
     /**
     * Αρχηκοποιεί τα JLabels.
     */
    protected TextView[] setLabels(){
        TextView[] labelsArray = new TextView[2];
        labelsArray[0] = (TextView) findViewById(R.id.b_text1);
        labelsArray[1] = (TextView) findViewById(R.id.b_text2);
        
        labelsArray[0].setText("Player 1:");
	labelsArray[1].setText("Player 2:");

        return labelsArray;
    }

    protected Button[] buttons(){
        Button[] buttonsArray = new Button[num_buttons];
    	for(int i =0;i<num_buttons;i++){
    		if(i<14)buttonsArray[i] = (Button) findViewById(R.id.b_card01+i);
                else buttonsArray[i] = (Button) findViewById(R.id.b_card15+i-14);
    		buttonsArray[i].setBackgroundResource(R.drawable.back_cover);
    		//buttonsArray[i].setText("button"+i);
    		}
        return buttonsArray;
    }

}