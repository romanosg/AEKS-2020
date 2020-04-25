package Bots;

import GameManagers.GameManagerNormal;
import project.Battle;

public class HardBotMod8 extends HardBot{

	private int[] knowncards;
	
	 public HardBotMod8(){
	    	super();
	    	knowncards = new int[GameManagerNormal.numberOfCards];
	    	for(int i=0;i<GameManagerNormal.numberOfCards;i++){
	    		knowncards[i]=-1;
	    	}
	    	
	    }
	 
	 protected void saveHalf(){
			knowncards[GameManagerNormal.mainTable[x]]=x;

 }
	 public void OpenCardFirst(Battle gui,int x){
			if(knowncards[GameManagerNormal.mainTable[x]]!=-1){
				gui.clickButton(knowncards[GameManagerNormal.mainTable[x]]);
			}
			else {
				while(true){
				x = r.nextInt(GameManagerNormal.numberOfCards)+GameManagerNormal.numberOfCards;
				System.out.println("!!"+x);
				if(x!=opened && x1[x-GameManagerNormal.numberOfCards]==0)break;
			}
			saveHalf();
			gui.clickButton(x);
	    	opened = x;	
		}
		}
		
		public void OpenCardSecond(Battle gui){
				while(true){
				x = r.nextInt(GameManagerNormal.numberOfCards)+GameManagerNormal.numberOfCards;
				System.out.println("!!!!!!!!!"+x);
				if(x!=opened && x1[x-GameManagerNormal.numberOfCards]==0)break;
				}
				saveHalf();
			gui.clickButton(x);
		}
	
}
