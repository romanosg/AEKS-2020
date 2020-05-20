package com.android.BackEnd;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import com.memory_game.app.R;

import com.android.BackEnd.GameManagers.GameManagerNormal;

//This class implements the gui, it changes the android's components like the buttons and the labels. Every change of those elements has to
//happen through this class in order to happen on the thread that has the permission to alter the view components.
public class AndroidGui{


TextView[] labelsArray;

int num_buttons;
Button[] buttonsArray;
Activity a;
boolean battle;
char open_card;
boolean normal;

   //Constructor, it requires the initiated labels and buttons as well the number of the buttons. The activity is recuired in order to gain
   //access to the guiThread. Boolean battle specidies if the game is of the battle mode and char open_card is a specific character for each
   //mode. Finally normal flag specifies if the game is normal mode or not.
   public AndroidGui(TextView[] labelsArray, int num_buttons, Button[] buttonsArray, Activity a, boolean battle, char open_card, boolean normal){
       this.labelsArray = labelsArray;
       this.num_buttons = num_buttons;
       this.buttonsArray = buttonsArray;
       this.a = a;
       this.battle = battle;
       this.open_card = open_card;
       this.normal = normal;
       for(int i =0;i<num_buttons;i++){
    		this.buttonsArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    				if(GameManagerNormal.click)handleEvent(v);      
                }
            });
    		}
   }

//This function is triggered when a card is selected, it flips the card and handles the calling of the thread that controls the closing of the cards
protected void handleEvent(View v) {
        int id = v.getId();
    	if(!battle && normal){
            this.openCard(id-R.id.card01);//Integer.parseInt(s));
    	    this.st(new Thread(new OpenCardR(this, id-R.id.card01, open_card)));
        }
        else if(!battle && !normal){
            this.openCard(id-R.id.card_3_01);//Integer.parseInt(s));
    	    this.st(new Thread(new OpenCardR(this, id-R.id.card_3_01, open_card)));
        }
        else{
            int offset=0;
            if(id-R.id.b_card01>=14)offset=2;
            this.openCard(id-R.id.b_card01-offset);//Integer.parseInt(s));
    	    this.st(new Thread(new OpenCardR(this, id-R.id.b_card01-offset, open_card)));
        }
        //a.runOnUiThread(new OpenCardR(this, id-R.id.card01,'n'));
    }

    public void openCard(final int cardNumber){
        a.runOnUiThread(new Runnable() {

    @Override
    public void run() {
buttonsArray[cardNumber].setBackgroundResource(R.drawable.i0+GameManagerNormal.mainTable[cardNumber]);

    }
});
        //Log.v("degbugging", ""+buttonsArray[cardNumber]);
        //buttonsArray[cardNumber].setBackgroundResource(R.id.card01+GameManagerNormal.mainTable[cardNumber]);
    }
    
    public void closeCard(final int cardNumber){
a.runOnUiThread(new Runnable() {

    @Override
    public void run() {

buttonsArray[cardNumber].setBackgroundResource(R.drawable.back_cover);

    }
});
        
    }

//The following two functions are changing the text in the labels.

    public void changeJLabelsTurn(final int x){
a.runOnUiThread(new Runnable() {

    @Override
    public void run() {

labelsArray[1].setText("It is player"+x+"'s turn");

    }
});
    	
    }
    
    public void changeJLabels(final int x, final String s){
a.runOnUiThread(new Runnable() {

    @Override
    public void run() {

labelsArray[x].setText(s);

    }
});
    	
    }
    
    protected void st(Thread t1){
    	t1.start();
    }
    //The following functions are rendering some buttons (or all of them) unclicable or they restore their ability to be clicked. It is used in order to disable the buttons during the bots' turns and re enable them afterwards.
    public void unClicableButtons(int x1){
    	buttonsArray[x1].setOnClickListener(null);
         //buttonsArray[x1].setEnabled(false);
    }
    
    //Depricated function used for the pure java implementation in order to end the game.
    public void gameEnd(){
    	//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
    
    public void clicableButtons(int x){
        //buttonsArray[x].setEnabled(true);
    	buttonsArray[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    				if(GameManagerNormal.click)handleEvent(v);      
                }
            });
    }

    public void clickButton(final int x){
a.runOnUiThread(new Runnable() {

    @Override
    public void run() {

buttonsArray[x].performClick();
    }
});
    	
    }
    
    public void closeButtons(){
        for(int i=0;i < num_buttons;i++)if(buttonsArray[i]!=null)unClicableButtons(i);
    }

    public void openButtons(){
        for(int i=0;i < num_buttons;i++)if(buttonsArray[i]!=null)clicableButtons(i);
    }

    public void  rmButtons(int x1, int x2){
        buttonsArray[x1] = null;
        buttonsArray[x2] = null;
    }

    public void  rmButtons(int x1, int x2, int x3){
        buttonsArray[x1] = null;
        buttonsArray[x2] = null;
        buttonsArray[x3] = null;
    }

    public void closeP2buttons(){
        for(int i=num_buttons/2;i < num_buttons;i++)if(buttonsArray[i]!=null)unClicableButtons(i);
    }

    public void closeP1buttons(){
        for(int i=0;i < num_buttons/2;i++)if(buttonsArray[i]!=null)unClicableButtons(i);
    }
 
    public void openP2buttons(){
        for(int i=num_buttons/2;i < num_buttons;i++)if(buttonsArray[i]!=null)clicableButtons(i);
    }

    public void openP1buttons(){
        for(int i=0;i < num_buttons/2;i++)if(buttonsArray[i]!=null)clicableButtons(i);
    }   
}
