package com.memory_game.app.Bots;

import GameManagers.GameManagerNormal;
import com.memory_game.app.project.GUI;

public class HardBotMod5 extends HardBot{
	
GUI gui;
	
	public HardBotMod5(GUI gui){
		super();
		this.gui =gui;
	}
	@Override
	protected void saveAll(){
		String s = gui.iconsArray[GameManagerNormal.mainTable[x]].toString().substring(
				gui.iconsArray[GameManagerNormal.mainTable[x]].toString().length() -1-6);
		knownCards[Integer.parseInt(""+s.charAt(0))][Integer.parseInt(""+s.charAt(2))-1]=x;

}
	@Override
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
	@Override
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
	@Override
	protected boolean checkX(){
		String s = gui.iconsArray[GameManagerNormal.mainTable[x]].toString().substring(
				gui.iconsArray[GameManagerNormal.mainTable[x]].toString().length() -1-6);
		System.out.println(s);
		if(knownCards[Integer.parseInt(""+s.charAt(0))][Integer.parseInt(""+s.charAt(2))-1]==-1)
			return true;
		return false;
	}
}
