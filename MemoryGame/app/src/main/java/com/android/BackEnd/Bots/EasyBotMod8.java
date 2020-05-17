package com.android.BackEnd.Bots;

import com.android.BackEnd.GameManagers.*;
import com.android.BackEnd.AndroidGui;



public class EasyBotMod8 extends EasyBot{	
	
	public void OpenCard(AndroidGui gui){
		while(true){
			x = r.nextInt(GameManagerNormal.numberOfCards)+GameManagerNormal.numberOfCards;
			if(x!=opened && x1[x-GameManagerNormal.numberOfCards]==0)break;
		}
		System.out.println("Played"+x);
                gui.clicableButtons(x);
		gui.clickButton(x);
    	opened = x;
    }

}
