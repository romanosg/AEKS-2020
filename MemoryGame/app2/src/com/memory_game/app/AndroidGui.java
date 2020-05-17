package com.memory_game.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import com.memory_game.app.R;
import android.util.Log;

import com.android.BackEnd.GameManagers.GameManagerNormal;
import com.memory_game.app.project.*;

public class AndroidGui{


TextView[] labelsArray;

int num_buttons;
Button[] buttonsArray;
Activity a;

   public AndroidGui(TextView[] labelsArray, int num_buttons, Button[] buttonsArray, Activity a){
       this.labelsArray = labelsArray;
       this.num_buttons = num_buttons;
       this.buttonsArray = buttonsArray;
       this.a = a;
       for(int i =0;i<num_buttons;i++){
    		this.buttonsArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    				if(GameManagerNormal.click)handleEvent(v);      
                }
            });
    		}
   }


protected void handleEvent(View v) {
        int id = v.getId();
    	this.openCard(id-R.id.card01);//Integer.parseInt(s));
    	this.st(new Thread(new OpenCardR(this, id-R.id.card01,'n')));
        //a.runOnUiThread(new OpenCardR(this, id-R.id.card01,'n'));
    }

    public void openCard(final int cardNumber){
        a.runOnUiThread(new Runnable() {

    @Override
    public void run() {
Log.v("degbugging", ""+buttonsArray[cardNumber]);
Log.v("degbugging", ""+GameManagerNormal.mainTable[cardNumber]);
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

//------------------------------------

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
    
    public void unClicableButtons(int x1){
    	buttonsArray[x1].setOnClickListener(null);
         //buttonsArray[x1].setEnabled(false);
    }
    
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
    
}
