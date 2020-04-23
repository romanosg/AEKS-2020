package Bots;

import GameManagers.GameManagerNormal;
import project.GUI;

public class HardBotMod6 extends HardBotMod3{
	
	GUI gui;
	public HardBotMod6(GUI gui){
		super();
		this.gui=gui;
	}
	
	protected void saveAll(){
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
			knownCards[Integer.parseInt(""+s.charAt(0))][1]!=-1 &&
			knownCards[Integer.parseInt(""+s.charAt(0))][2]!=-1 &&
			knownCards[Integer.parseInt(""+s.charAt(0))][3]!=-1 
			&& s.charAt(2)=='1'){
				openCard2=knownCards[Integer.parseInt(""+s.charAt(0))][1];
				openCard3=knownCards[Integer.parseInt(""+s.charAt(0))][2];
				openCard4=knownCards[Integer.parseInt(""+s.charAt(0))][3];
			System.out.println("PairFoundWithTheSecond");
			return true;
		}
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
	
	public void OpenCardSecond(GUI gui) {
		if(checkCard){
			gui.clickButton(openCard2);
		}
		else{
			while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=opened && x1[x]==0)break;
		}
		gui.clickButton(x);
		saveAll();
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
	saveAll();
	if(checkCard()){
		checkCard = true;
	}
	opened = x;	
	}
}

}
