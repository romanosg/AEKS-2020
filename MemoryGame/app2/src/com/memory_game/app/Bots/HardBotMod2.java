package Bots;

import GameManagers.*;
import project.*;

public class HardBotMod2 extends HardBot{
	int cardSwap1,cardSwap2,swapCheck1 = -1, swapCheck2 = -1, swapCheckr1, swapCheckr2;

	public HardBotMod2(){
		super();
	}
	
	/*void cardSwap(int x1, int x2){
		for(int i=0;i<GameManagerNormal.numberOfCards/2;i++){
			if(knownCards[i][0]== x1 && knownCards[i][1]== -1){
				swapCheck1 = i;
				swapCheckr1 = 0;
			}
			else if(knownCards[i][1]== x1){
				{
					swapCheck1 = i;
					swapCheckr1 = 1;
				}
			}
			if(knownCards[i][0] == x2 && knownCards[i][1]== -1){
				{
					swapCheck2 = i;
					swapCheckr2 = 0;
				}
			}
			else if(knownCards[i][1]== x2){
				{
					swapCheck2 = i;
					swapCheckr2 = 1;
				}
			}
		}
		if(swapCheck1!=-1) knownCards[swapCheck1][swapCheckr1]= x2;
		if(swapCheck2!=-1) knownCards[swapCheck2][swapCheckr2]= x1;
		swapCheck1 =-1;
		swapCheck2 = -1;
	}*/
	
	public void playerSwap(int x1, int x2){
		for(int i=0;i<GameManagerNormal.numberOfCards/2;i++){
			if(knownCards[i][0]== x1){
				swapCheck1 = i;
				swapCheckr1=0;
			}
			else if(knownCards[i][1]== x1){
				{
					swapCheck1 = i;
					swapCheckr1=1;
				}
			}
			if(knownCards[i][0] == x2){
				{
					swapCheck2 = i;
					swapCheckr2=0;
				}
			}
			else if(knownCards[i][1]== x2){
				{
					swapCheck2 = i;
					swapCheckr2=1;
				}
			}
		}
		if(swapCheck1!=-1){
			knownCards[swapCheck1][swapCheckr1]= -1;
			if(knownCards[GameManagerNormal.mainTable[x1]][0]==-1)knownCards[GameManagerNormal.mainTable[x1]][0] = x1;
			else if(knownCards[GameManagerNormal.mainTable[x1]][1]==-1)knownCards[GameManagerNormal.mainTable[x1]][1]= x1;
		}
		if(swapCheck2!=-1){
			knownCards[swapCheck2][swapCheckr2]= -1;
			if(knownCards[GameManagerNormal.mainTable[x2]][0]==-1)knownCards[GameManagerNormal.mainTable[x2]][0] = x2;
			else if(knownCards[GameManagerNormal.mainTable[x2]][1]==-1)knownCards[GameManagerNormal.mainTable[x2]][1]= x2;
		}
		swapCheck1 =-1;
		swapCheck2 = -1;
	}
	
	
	public void OpenCardSecond(GUI gui) {
		if(checkForPairVar){
			gui.clickButton(openCard2);
		}
		else if(checkCard())gui.clickButton(checkedCard);
		else {
			while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0)break;
		}
		gui.clickButton(x);
		saveAll();
		cardSwap2 =x;
    	opened = x;	
	}
	//playerSwap(cardSwap1,cardSwap2);
	}
	
	public void OpenCardFirst(GUI gui) {
		checkForPairVar = checkForPair();
		if(checkForPairVar){
			gui.clickButton(openCard1);
		}
		else {
			int sumScore=0;
    		for(int i=0;i<GameManagerNormal.numberOfPlayers;i++){
    			sumScore += GameManagerNormal.playersScore[i];
    		}
			while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(sumScore != (GameManagerNormal.numberOfCards/2)-1){
				if(x!=opened && x1[x]==0 && checkX())break;
			}
			else if(x!=opened && x1[x]==0)break;
			
		}
		gui.clickButton(x);
		saveAll();
		cardSwap1 = x;
    	opened = x;	
	}
	}
	
	protected void saveAll(){
		boolean b = true;
		for(int i=0;i<GameManagerNormal.numberOfCards/2;i++){
			if(knownCards[i][0]==x || knownCards[i][1]==x)b=false;
		}
		if(b){
		if(knownCards[GameManagerNormal.mainTable[x]][0]==-1)
			knownCards[GameManagerNormal.mainTable[x]][0] = x; 
		else if(knownCards[GameManagerNormal.mainTable[x]][0] != -1 &&
				knownCards[GameManagerNormal.mainTable[x]][0]!=x)
			knownCards[GameManagerNormal.mainTable[x]][1] = x;
		}
}

	
}
