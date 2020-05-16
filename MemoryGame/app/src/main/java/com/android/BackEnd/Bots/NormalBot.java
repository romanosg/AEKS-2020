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
 * Είναι η sub class που χειρίζεται τις κινήσεις του normal bot.
 *
 * @author Ιωάννα Σταϊνού 2466
 * @version Nov 2015
 */
public class NormalBot extends Bot{
   
	protected int[][] knownCards; 
	boolean firstOpen, checkForPairVar;
	protected int checkedCard, openCard1,openCard2;
	
    public NormalBot(){
    	super();
    	System.out.println("NormalBotCreated");
    	knownCards = new int[GameManagerNormal.numberOfCards/2][2];
    	firstOpen = true;
    	for(int i=0;i<GameManagerNormal.numberOfCards;i++){
			this.x1[i] = 0;
    	}
    	System.out.println(""+GameManagerNormal.numberOfCards);
    	for(int i=0;i<GameManagerNormal.numberOfCards/2;i++){
    		this.knownCards[i][0] = -1;
			this.knownCards[i][1] = -1;
    	}
    }
    
    public NormalBot(int numberOfRows){
    	super();
    	System.out.println("NormalBotCreated");
    	knownCards = new int[GameManagerNormal.numberOfCards/2][numberOfRows];
    	firstOpen = true;
    	for(int i=0;i<GameManagerNormal.numberOfCards;i++){
			this.x1[i] = 0;
    	}
    	for(int i=0;i<GameManagerNormal.numberOfCards/2;i++){
    		for(int y=0;y<numberOfRows;y++){
    			this.knownCards[i][y] = -1;
    		}
    	}
    }
	
	protected void saveHalf(){
			if(knownCards[GameManagerNormal.mainTable[x]][0]==-1)
				knownCards[GameManagerNormal.mainTable[x]][0] = x; 
			else if(knownCards[GameManagerNormal.mainTable[x]][0] != -1 &&
					knownCards[GameManagerNormal.mainTable[x]][0]!=x)
				knownCards[GameManagerNormal.mainTable[x]][1] = x;

    }

	public void OpenCardFirst(AndroidGui gui) {
		checkForPairVar = checkForPair();
		if(checkForPairVar){
                        gui.clicableButtons(openCard1);
			gui.clickButton(openCard1);
		}
		else {
			while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0  && checkX())break;
		}
                gui.clicableButtons(x);
		gui.clickButton(x);
		saveHalf();
    	opened = x;	
	}
	}
	
	public void OpenCardSecond(AndroidGui gui) {
		if(checkForPairVar){
                        gui.clicableButtons(openCard2);
			gui.clickButton(openCard2);
		}
		else if(checkCard())gui.clickButton(checkedCard);
		else {
			while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0)break;
		}
                gui.clicableButtons(x);
		gui.clickButton(x);
    	opened = x;	
	}
	}
	
	private boolean checkForPair(){
		for(int i = 0;i < 13;i++){
			if(knownCards[GameManagerNormal.mainTable[x]][0]!=-1 && 
					knownCards[GameManagerNormal.mainTable[x]][1]!=-1
					&& x1[knownCards[GameManagerNormal.mainTable[x]][0]] == 0
					&& x1[knownCards[GameManagerNormal.mainTable[x]][0]]==0){
				openCard1 = knownCards[GameManagerNormal.mainTable[x]][0];
				openCard2 = knownCards[GameManagerNormal.mainTable[x]][1];
				System.out.println("PairFound");
				return true;
			}
		}
		return false;
	}
protected boolean checkCard(){
		if(knownCards[GameManagerNormal.mainTable[x]][0]!=-1 &&
				knownCards[GameManagerNormal.mainTable[x]][1]!=-1){
			if(knownCards[GameManagerNormal.mainTable[x]][0]!=x)
				checkedCard = knownCards[GameManagerNormal.mainTable[x]][0];
			else checkedCard = knownCards[GameManagerNormal.mainTable[x]][1];
			System.out.println("PairFoundWithTheSecond");
			return true;
		}
		return false;
			
	}

	protected boolean checkX(){
		if(knownCards[GameManagerNormal.mainTable[x]][0]==-1 &&
				knownCards[GameManagerNormal.mainTable[x]][1]==-1)
			return true;
		else if(knownCards[GameManagerNormal.mainTable[x]][0]==-1 &&
				knownCards[GameManagerNormal.mainTable[x]][1]!=x)
			return true;
		else if(knownCards[GameManagerNormal.mainTable[x]][1]==-1 &&
				knownCards[GameManagerNormal.mainTable[x]][0]!=x)
			return true;
		return false;
	}


}
