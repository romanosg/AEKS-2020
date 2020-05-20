package com.android.MemoryGameActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import com.android.BackEnd.AndroidGui;
import com.android.BackEnd.GameManagers.GameManagerMod8;
import com.memory_game.app.R;

//This activity starts a game of battle mod. It uses the battle layout which is different than the normal layout and the layout for the 3 cards mode.
public class BattleActivity extends Activity {
	
int num_buttons = 28;

  //use 2 spaces instead of tabs
  private AndroidGui gui;
  private static Context context;
  private String player1;
  private String player2;
  private int num_players;
  private int num_bots;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = getApplicationContext();
      setContentView(R.layout.battle);
      char bota = 'e', botb = 'e', botc = 'e';
       player1 = getIntent().getStringExtra("player1Name");
       player2 = getIntent().getStringExtra("player2Name");
       if(player1 == ""){
           player1 = "Player1";
       }
       if(player2 == ""){
           player2 = "Player2";
       }
       String Players[] = new String[2];
       Players[0] = player1;
       Players[1] = player2;
       num_players = getIntent().getIntExtra("num_of_players", 2);
       num_bots = getIntent().getIntExtra("num_of_bots", 1);
       gui = new AndroidGui(setLabels(), 28, buttons(), this, true, 'b', false);

       int num_bots = getIntent().getIntExtra("num_of_bots", 1);
       if(num_bots>0) bota = getIntent().getCharExtra("difficulty", 'e');
       if(num_bots==1)GameManagerMod8.InitGameManager(gui,2,num_bots,14,bota);


   }
     
     /**
     * Initiates the JLabels.
     */
    protected TextView[] setLabels(){
        TextView[] labelsArray = new TextView[2];
        labelsArray[0] = (TextView) findViewById(R.id.b_text1);
        labelsArray[1] = (TextView) findViewById(R.id.b_text2);
        
        labelsArray[0].setText("Player 1:");
	    labelsArray[1].setText("Player 2:");

        return labelsArray;
    }

    //Initiates the buttons (cards)
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
