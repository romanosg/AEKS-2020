/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.android.BackEnd.Bots;

import com.android.BackEnd.GameManagers.*;
import com.android.BackEnd.AndroidGui;

/**
 * Είναι η sub class που χειρίζεται τις κινήσεις του hard bot.
 *
 * @author Ιωάννα Σταϊνού 2466
 * @version Nov 2015
 */
public class HardBot extends Bot {
    
    /**
     * Αποθηκεύει όλλους τους αριθμούς των δύο καρτών που ανοίγοντε κάθε φορά.
     */

    protected int[][] knownCards; 
	protected int openCard1;
	protected int openCard2;
	boolean checkForPairVar;
	protected int checkedCard;
	
    public HardBot(){
    	super();
    	System.out.println("HardBotCreated");
    	knownCards = new int[GameManagerNormal.numberOfCards/2][2];
    	for(int i=0;i<GameManagerNormal.numberOfCards;i++){
			this.x1[i] = 0;
    	}
    	for(int i=0;i<GameManagerNormal.numberOfCards/2;i++){
    		this.knownCards[i][0] = -1;
			this.knownCards[i][1] = -1;
    	}
    }
	
    public HardBot(int numberOfRows){
    	super();
    	System.out.println("HardBotCreated");
    	knownCards = new int[GameManagerNormal.numberOfCards/2][numberOfRows];
    	for(int i=0;i<GameManagerNormal.numberOfCards;i++){
			this.x1[i] = 0;
    	}
    	for(int i=0;i<GameManagerNormal.numberOfCards/2;i++){
    	for(int y=0;y<numberOfRows;y++){
    		this.knownCards[i][y] = -1;
    	}
    	}
    }
    
	protected void saveAll(){
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
		saveAll();
    	opened = x;	
	}
	}
	
	public void OpenCardSecond(AndroidGui gui) {
		if(checkForPairVar){
                        gui.clicableButtons(openCard2);
			gui.clickButton(openCard2);
		}
		else if(checkCard()){
                    gui.clicableButtons(checkedCard);
                    gui.clickButton(checkedCard);
                }
		else {
			while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0)break;
		}
                gui.clicableButtons(x);
		gui.clickButton(x);
		saveAll();
    	opened = x;	
	}
	}
	
	protected boolean checkForPair(){
		for(int i = 0;i < GameManagerNormal.numberOfCards;i++){
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
