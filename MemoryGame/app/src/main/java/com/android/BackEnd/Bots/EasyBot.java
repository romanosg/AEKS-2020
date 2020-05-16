/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory_game.app.Bots;

import com.memory_game.app.GameManagers.*;
import com.memory_game.app.project.*;
import com.memory_game.app.project.AndroidGui;


/**
 * Είναι η sub class που χειρίζεται τις κινήσεις του easy bot.
 *
 * @author Ιωάννα Σταϊνού 2466
 * @version Nov 2015
 */
public class EasyBot extends Bot{

    public EasyBot(){
    	super();
    	for(int i=0;i<GameManagerNormal.numberOfCards;i++){
			this.x1[i] = 0;
    	}
    	System.out.println("Easy bot created");
    }
    
	public void OpenCard(AndroidGui gui){
		while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0)break;
		}
                gui.clicableButtons(x);
		gui.clickButton(x);
    	opened = x;
    }
    
}
