package com.android.MemoryGameActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import com.android.BackEnd.GameManagers.GameManagerNormal;
import com.android.BackEnd.GameManagers.GameManagerMod4;
import com.memory_game.app.R;
import com.android.BackEnd.AndroidGui;

//This activity starts a game with either normal mode or 3cards mode.
public class NormalActivity extends Activity {
	
private int num_buttons;
private AndroidGui gui;
private int num_players;
private int num_bots;
private boolean normal;
private String player1;
private String player2;

	private static Context context;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = getApplicationContext();
      char bota = 'e';
      char botb = 'e';
      char botc = 'e';
      player1 = getIntent().getStringExtra("player1Name");
      player2 = getIntent().getStringExtra("player1Name");
      if(player1 == ""){
          player1 = "Player1";
      }
       if(player2 == ""){
           player2 = "Player2";
       }
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
      String Players[] = new String[2];
      Players[0] = player1;
      Players[1] = player2;

      if(num_bots>0) bota = getIntent().getCharExtra("difficulty", 'e');

      //multiple bots, won't be supported in this app version
      if(num_bots>1) botb = getIntent().getCharExtra("botb", 'e');
      if(num_bots>2) botc = getIntent().getCharExtra("botc", 'e');
      
      //It starts either a game in normal mode (GameManagerNormal) or in 3cards mode (GamemanagerMod4).
      if(!normal){
          gui = new AndroidGui(setLabels(), num_buttons, buttons(), this, false, '6', false);
          if(num_bots==1)GameManagerMod4.InitGameManager(gui,num_players,num_bots,num_buttons,bota);
          else if(num_bots==2)GameManagerMod4.InitGameManager(gui,num_players,num_bots,num_buttons,bota,botb);
          else if(num_bots==3)GameManagerMod4.InitGameManager(gui,num_players,num_bots,num_buttons,bota,botb,botc);
          else GameManagerMod4.InitGameManager(gui,num_players,0,num_buttons, 'n');
      }
      else{
          gui = new AndroidGui(setLabels(), num_buttons, buttons(), this, false, 'n', true);
          if(num_bots==1)GameManagerNormal.InitGameManager(gui,num_players,num_bots,num_buttons,bota);
          else if(num_bots==2)GameManagerNormal.InitGameManager(gui,num_players,num_bots,num_buttons,bota,botb);
          else if(num_bots==3)GameManagerNormal.InitGameManager(gui,num_players,num_bots,num_buttons,bota,botb,botc);
          else GameManagerNormal.InitGameManager(gui,num_players,0,num_buttons,'n');
      }
   }
     
     /**
     * Initiates the Labels.
     */
    protected TextView[] setLabels(){
        TextView[] labelsArray = new TextView[2];
        labelsArray[0] = (TextView) findViewById(R.id.ma_text1);
        labelsArray[1] = (TextView) findViewById(R.id.ma_text2);
        
        labelsArray[0].setText(player1 + ":");
	    labelsArray[1].setText(player2 + ":");

        return labelsArray;
    }

    //Initiates the Buttons.
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
