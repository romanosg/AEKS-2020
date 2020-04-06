package Bots;

import GameManagers.GameManagerNormal;
import project.*;

public class NormalBotMod5 extends NormalBot{
	
	GUI gui;
	private int openCard1;
	private int openCard2;
	
	public NormalBotMod5(GUI gui){
		super();
		this.gui =gui;
	}
	
	protected void saveHalf(){
		String s = gui.iconsArray[GameManagerNormal.mainTable[x]].toString().substring(
				gui.iconsArray[GameManagerNormal.mainTable[x]].toString().length() -1-6);
		knownCards[Integer.parseInt(""+s.charAt(0))][Integer.parseInt(""+s.charAt(2))-1]=x;
}

	protected boolean checkX(){
		String s = gui.iconsArray[GameManagerNormal.mainTable[x]].toString().substring(
				gui.iconsArray[GameManagerNormal.mainTable[x]].toString().length() -1-6);
		System.out.println(s);
		if(knownCards[Integer.parseInt(""+s.charAt(0))][Integer.parseInt(""+s.charAt(2))-1]==-1)
			return true;
		return false;
	}
	
	protected boolean checkCard(){
		String s = gui.iconsArray[GameManagerNormal.mainTable[x]].toString().substring(
				gui.iconsArray[GameManagerNormal.mainTable[x]].toString().length() -1-6);
		if(knownCards[Integer.parseInt(""+s.charAt(0))][0]!=-1 &&
			knownCards[Integer.parseInt(""+s.charAt(0))][1]!=-1){
			if(s.charAt(2)=='1')checkedCard=knownCards[Integer.parseInt(""+s.charAt(0))][1];
			else checkedCard=knownCards[Integer.parseInt(""+s.charAt(0))][0];
			System.out.println("PairFoundWithTheSecond");
			return true;
		}
		return false;
			
	}
	protected boolean checkForPair(){
		for(int i = 0;i < GameManagerNormal.numberOfCards/2;i++){
			if(knownCards[i][0]!=-1 && knownCards[i][1]!=-1
					&& x1[knownCards[i][0]] == 0
					&& x1[knownCards[i][0]]==0){
				openCard1 = knownCards[i][0];
				openCard2 = knownCards[i][1];
				System.out.println("PairFound");
				return true;
			}
		}
		return false;
	}
	
	public void OpenCardFirst(GUI gui) {
		checkForPairVar = checkForPair();
		if(checkForPairVar){
			gui.clickButton(openCard1);
		}
		else {
			while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0  && checkX())break;
		}
		gui.clickButton(x);
		saveHalf();
    	opened = x;	
	}
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
    	opened = x;	
	}
	}
	
}
