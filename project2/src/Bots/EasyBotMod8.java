package Bots;

import GameManagers.GameManagerNormal;
import project.*;

public class EasyBotMod8 extends EasyBot{	
	
	public void OpenCard(Battle gui){
		while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards)+GameManagerNormal.numberOfCards;
			System.out.println("!!!!!!!!");
			if(x!=opened && x1[x-GameManagerNormal.numberOfCards]==0)break;
		}
		System.out.println("Played"+x);
		gui.clickButton(x);
    	opened = x;
    }

}
