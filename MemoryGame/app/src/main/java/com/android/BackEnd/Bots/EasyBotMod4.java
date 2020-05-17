package com.android.BackEnd.Bots;

import com.android.BackEnd.GameManagers.*;
import com.android.BackEnd.AndroidGui;


public class EasyBotMod4 extends EasyBot{
	int x0=-1,x2=-1;

	public EasyBotMod4(){
		super();
	}
	
	public void OpenCard(AndroidGui gui){
		while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards);
			if(x!=x0 && x1[x]==0 && x!=x2){
				break;
			}
			System.out.println(""+x);
		}
                gui.clicableButtons(x);
		gui.clickButton(x);
    	if(x0==-1)x0= x;
    	else if(x2==-1)x2=x;
    	else x0=x2=-1;
    	}
}
