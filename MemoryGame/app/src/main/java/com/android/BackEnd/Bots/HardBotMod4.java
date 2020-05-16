package com.memory_game.app.Bots;

import com.memory_game.app.GameManagers.*;
import com.memory_game.app.project.*;
import com.memory_game.app.project.AndroidGui;


public class HardBotMod4 extends HardBot{

	int opened2,openCard1,openCard2,openCard3;
	boolean checkCard;
	
	public HardBotMod4(){
		super(3);
	}
	
	protected void saveAll(){
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
		
		/*for(int i=0;i<6;i++){
			System.out.println(""+knownCards[i][0]+" "+knownCards[i][1]+" "+knownCards[i][2]+" "+knownCards[i][3]);
		}
		System.out.println("-------------------");*/

}	
	
	public void OpenCardSecond(AndroidGui gui) {
		if(checkCard){
                        gui.clicableButtons(openCard2);
			gui.clickButton(openCard2);
		}
		else{   
                        int c=0;
			while(c<30){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0 && checkX())break;
                        c++;
		}
                if(c>=30)for(x=0;x<GameManagerNormal.numberOfCards;x++)if(x!=opened && x1[x]==0)break;
                gui.clicableButtons(x);
		gui.clickButton(x);
		saveAll();
    	opened2 = x;
		}
	}
	
	public void OpenCardFirst(AndroidGui gui) {
		checkCard=checkForPair();
		if(checkCard){
                        gui.clicableButtons(openCard1);
			gui.clickButton(openCard1);
		}
		else{
                     int c=0;
			while(c<30){
		x = r.nextInt(GameManagerNormal.numberOfCards);
		if(x!=opened && x1[x]==0  && checkX())break;
                c++;
	}
        if(c>=30)for(x=0;x<GameManagerNormal.numberOfCards;x++)if(x!=opened && x1[x]==0)break;
        gui.clicableButtons(x);
	gui.clickButton(x);
	saveAll();
	if(checkCard()){
		if(knownCards[GameManagerNormal.mainTable[x]][0]==x){
		openCard2=knownCards[GameManagerNormal.mainTable[x]][1];
		openCard3=knownCards[GameManagerNormal.mainTable[x]][2];
		}
		else if(knownCards[GameManagerNormal.mainTable[x]][1]==x){
			openCard2=knownCards[GameManagerNormal.mainTable[x]][0];
			openCard3=knownCards[GameManagerNormal.mainTable[x]][2];
			}
		else if(knownCards[GameManagerNormal.mainTable[x]][2]==x){
			openCard2=knownCards[GameManagerNormal.mainTable[x]][1];
			openCard3=knownCards[GameManagerNormal.mainTable[x]][0];
			}
		checkCard = true;
	}
	opened = x;	
	}
}
	
	public void OpenCardThird(AndroidGui gui) {
		if(checkCard){
                        gui.clicableButtons(openCard3);
			gui.clickButton(openCard3);
		}
		else{	
                int c=0;
		while(c<30){
                        
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0 && x!=opened2)break;
                        c++;
		}
                if(c>=30)for(x=0;x<GameManagerNormal.numberOfCards;x++)if(x!=opened && x1[x]==0 && x!=opened2)break;
                gui.clicableButtons(x);
		gui.clickButton(x);
		saveAll();	
	}
	}
	
	protected boolean checkCard(){
		if(knownCards[GameManagerNormal.mainTable[x]][0]!=-1 &&
				knownCards[GameManagerNormal.mainTable[x]][1]!=-1 &&
				knownCards[GameManagerNormal.mainTable[x]][2]!=-1){
			if(knownCards[GameManagerNormal.mainTable[x]][0]!=x)
				checkedCard = knownCards[GameManagerNormal.mainTable[x]][0];
			else if(knownCards[GameManagerNormal.mainTable[x]][1]!=x)
				checkedCard = knownCards[GameManagerNormal.mainTable[x]][1];
			else checkedCard = knownCards[GameManagerNormal.mainTable[x]][2];
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
		return false;
	}
	
	protected boolean checkForPair(){
		for(int i = 0;i < GameManagerNormal.numberOfCards/4;i++){
			if(knownCards[i][0]!=-1 && knownCards[i][1]!=-1 && knownCards[i][2] !=-1 &&
					x1[knownCards[i][0]]==0 && x1[knownCards[i][1]]==0 && x1[knownCards[i][2]]==0){
				openCard1 = knownCards[i][0];
				openCard2 = knownCards[i][1];
				openCard3 = knownCards[i][2];
				System.out.println("PairFound");
				return true;
			}
		}
		return false;
	}	
}
