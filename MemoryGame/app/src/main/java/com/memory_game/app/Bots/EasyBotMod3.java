package com.memory_game.app.Bots;

import GameManagers.*;
import project.*;

public class EasyBotMod3 extends EasyBot{
	int x0=-1,x2=-1,x3=-1;

	public EasyBotMod3(){
		super();
	}
	
	public void OpenCard(GUI gui){
		while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=x0 && x1[x]==0 && x!=x2 && x!=x3){
				break;
			}
			System.out.println(""+x);
		}
		gui.clickButton(x);
    	if(x0==-1)x0= x;
    	else if(x2==-1)x2=x;
    	else if(x3==-1) x3=x;
    	else x0=x2=x3=-1;
    }
	
}
