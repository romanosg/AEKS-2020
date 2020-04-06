package Bots;

import GameManagers.*;
import project.*;

public class EasyBotMod4 extends EasyBot{
	int x0=-1,x2=-1;

	public EasyBotMod4(){
		super();
	}
	
	public void OpenCard(GUI gui){
		while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=x0 && x1[x]==0 && x!=x2){
				break;
			}
			System.out.println(""+x);
		}
		gui.clickButton(x);
    	if(x0==-1)x0= x;
    	else if(x2==-1)x2=x;
    	else x0=x2=-1;
    	}
}
