package com.memory_game.app.Bots;

import GameManagers.*;
import project.*;

public class NormalBotMod3 extends NormalBot{
	
	int opened2,opened3,openCard1,openCard2,openCard3,openCard4;
	boolean checkCard;
	public NormalBotMod3(){
		super(4);
	}
	
	protected void saveHalf(){
		if(knownCards[GameManagerNormal.mainTable[x]][0]==-1)
			knownCards[GameManagerNormal.mainTable[x]][0] = x; 
		else if(knownCards[GameManagerNormal.mainTable[x]][0] != -1 &&
				knownCards[GameManagerNormal.mainTable[x]][1] == -1 &&
				knownCards[GameManagerNormal.mainTable[x]][0]!=x)
			knownCards[GameManagerNormal.mainTable[x]][1] = x;
		else if(knownCards[GameManagerNormal.mainTable[x]][0] != -1 &&
				knownCards[GameManagerNormal.mainTable[x]][0]!=x &&
				knownCards[GameManagerNormal.mainTable[x]][1] != -1 &&
						knownCards[GameManagerNormal.mainTable[x]][2] == -1 &&
				knownCards[GameManagerNormal.mainTable[x]][1] != x)
			knownCards[GameManagerNormal.mainTable[x]][2] = x;
		else if(knownCards[GameManagerNormal.mainTable[x]][0] != -1 &&
				knownCards[GameManagerNormal.mainTable[x]][0]!=x &&
				knownCards[GameManagerNormal.mainTable[x]][1] != -1 &&
				knownCards[GameManagerNormal.mainTable[x]][1] != x &&
				knownCards[GameManagerNormal.mainTable[x]][2] != -1 &&
				knownCards[GameManagerNormal.mainTable[x]][3] == -1 &&
				knownCards[GameManagerNormal.mainTable[x]][2] != x)
			knownCards[GameManagerNormal.mainTable[x]][3] = x;
		
		/*for(int i=0;i<6;i++){
			System.out.println(""+knownCards[i][0]+" "+knownCards[i][1]+" "+knownCards[i][2]+" "+knownCards[i][3]);
		}
		System.out.println("-------------------");*/

}	
	
	public void OpenCardSecond(GUI gui) {
		if(checkCard){
			gui.clickButton(openCard2);
		}
		else{
			while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0 && checkX())break;
		}
		gui.clickButton(x);
		saveHalf();
    	opened2 = x;
		}
	}
	
	public void OpenCardFirst(GUI gui) {
		checkCard=checkForPair();
		if(checkCard){
			gui.clickButton(openCard1);
		}
		else{
			while(true){
		x = r.nextInt(GameManagerNormal.numberOfCards);
		if(x!=opened && x1[x]==0  && checkX())break;
	}
	gui.clickButton(x);
	saveHalf();
	if(checkCard()){
		if(knownCards[GameManagerNormal.mainTable[x]][0]==x){
		openCard2=knownCards[GameManagerNormal.mainTable[x]][1];
		openCard3=knownCards[GameManagerNormal.mainTable[x]][2];
		openCard4=knownCards[GameManagerNormal.mainTable[x]][3];
		}
		else if(knownCards[GameManagerNormal.mainTable[x]][1]==x){
			openCard2=knownCards[GameManagerNormal.mainTable[x]][0];
			openCard3=knownCards[GameManagerNormal.mainTable[x]][2];
			openCard4=knownCards[GameManagerNormal.mainTable[x]][3];
			}
		else if(knownCards[GameManagerNormal.mainTable[x]][2]==x){
			openCard2=knownCards[GameManagerNormal.mainTable[x]][1];
			openCard3=knownCards[GameManagerNormal.mainTable[x]][0];
			openCard4=knownCards[GameManagerNormal.mainTable[x]][3];
			}
		else if(knownCards[GameManagerNormal.mainTable[x]][3]==x){
			openCard2=knownCards[GameManagerNormal.mainTable[x]][1];
			openCard3=knownCards[GameManagerNormal.mainTable[x]][2];
			openCard4=knownCards[GameManagerNormal.mainTable[x]][0];
			}
		checkCard = true;
	}
	opened = x;	
	}
}
	
	public void OpenCardThird(GUI gui) {
		if(checkCard){
			gui.clickButton(openCard3);
		}
		else{	
		while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0 && x!=opened2)break;
		}
		gui.clickButton(x);
    	opened3 = x;	
	}
	}
	
	public void OpenCardFouth(GUI gui) {
		if(checkCard){
			gui.clickButton(openCard4);
		}
		else{
		while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0 && x!=opened2 && x!=opened3)break;
		}
		gui.clickButton(x);
	}
	}
	
	protected boolean checkCard(){
		if(knownCards[GameManagerNormal.mainTable[x]][0]!=-1 &&
				knownCards[GameManagerNormal.mainTable[x]][1]!=-1 &&
				knownCards[GameManagerNormal.mainTable[x]][2]!=-1 && 
				knownCards[GameManagerNormal.mainTable[x]][3]!=-1){
			if(knownCards[GameManagerNormal.mainTable[x]][0]!=x)
				checkedCard = knownCards[GameManagerNormal.mainTable[x]][0];
			else if(knownCards[GameManagerNormal.mainTable[x]][1]!=x)
				checkedCard = knownCards[GameManagerNormal.mainTable[x]][1];
			else if(knownCards[GameManagerNormal.mainTable[x]][2]!=x)
				checkedCard = knownCards[GameManagerNormal.mainTable[x]][2];
			else checkedCard = knownCards[GameManagerNormal.mainTable[x]][3];
			System.out.println("PairFoundWithTheSecond");
			return true;
		}
		return false;
			
	}

	protected boolean checkX(){
		if(knownCards[GameManagerNormal.mainTable[x]][0]==-1)
			return true;
		else if(knownCards[GameManagerNormal.mainTable[x]][0]!= x &&
				knownCards[GameManagerNormal.mainTable[x]][1]==-1)
			return true;
		else if(knownCards[GameManagerNormal.mainTable[x]][0]!=x &&
				knownCards[GameManagerNormal.mainTable[x]][1]!=x &&
				knownCards[GameManagerNormal.mainTable[x]][2]==-1)
			return true;
		else if(knownCards[GameManagerNormal.mainTable[x]][0]!=x &&
				knownCards[GameManagerNormal.mainTable[x]][1]!=x &&
				knownCards[GameManagerNormal.mainTable[x]][2]!=x &&
				knownCards[GameManagerNormal.mainTable[x]][3]==-1)
			return true;
		return false;
	}
	
	protected boolean checkForPair(){
		for(int i = 0;i < GameManagerNormal.numberOfCards/4;i++){
			if(knownCards[i][0]!=-1 && knownCards[i][1]!=-1 && knownCards[i][2] !=-1 && knownCards[i][3]!=-1 &&
					x1[knownCards[i][0]]==0 && x1[knownCards[i][1]]==0 && x1[knownCards[i][2]]==0 && x1[knownCards[i][3]]==0){
				openCard1 = knownCards[i][0];
				openCard2 = knownCards[i][1];
				openCard3 = knownCards[i][2];
				openCard4 = knownCards[i][3];
				System.out.println("PairFound");
				return true;
			}
		}
		return false;
	}
	
}
