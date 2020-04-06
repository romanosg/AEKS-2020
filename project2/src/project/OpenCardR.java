package project;

import GameManagers.*;

public class OpenCardR implements Runnable{
	GUI gui;
	int  cardNumber;
	char c;
	OpenCardR(GUI gui,int  cardNumber,char c){
		this.gui = gui;
		this.cardNumber = cardNumber;
		this.c = c;
	}
	public void run(){
		switch(c){
		case'n':GameManagerNormal.OpenCard(gui, cardNumber);break;
		case'1':GameManagerNormalMod1.OpenCard(gui, cardNumber);break;
		case'2':GameManagerMod2.OpenCard(gui, cardNumber);break;
		case'3':GameManagerMod3.OpenCard(gui, cardNumber);break;
		case'4':GameManagerMod2_1.OpenCard(gui, cardNumber);break;
		case'5':GameManagerMod3_1.OpenCard(gui, cardNumber);break;
		case'6':GameManagerMod4.OpenCard(gui, cardNumber);break;
		case'7':GameManagerMod4_1.OpenCard(gui, cardNumber);break;
		case'8':GameManagerMod5.OpenCard(gui, cardNumber);break;
		case'9':GameManagerMod6.OpenCard(gui, cardNumber);break;
		case'a':GameManagerMod7.OpenCard(gui, cardNumber);break;
		case'b':GameManagerMod8.OpenCard((Battle)gui, cardNumber);break;
		}
		
	}

}
