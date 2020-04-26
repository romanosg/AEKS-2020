package com.memory_game.app.GameManagers;

import java.util.Random;
import Bots.*;
import project.*;

public class GameManagerMod2 extends GameManagerNormal{
	
	static int cardSwap1,cardSwap2;
	
	public static void InitGameManager(GUI gui,int numberOfPlayersvar,int numberOfBotsvar, int numberOfCardsvar,char... botLvlvar){
    	numberOfPlayers = numberOfPlayersvar;
    	numberOfBots = numberOfBotsvar;
    	botLvl = botLvlvar;
    	numberOfCards = numberOfCardsvar;
    	mainTable = new int[numberOfCards];
    	InitTable();
    	if(numberOfPlayersvar==numberOfBotsvar)botPlay(gui);
    }
	
	private static void InitTable(){
    	if(numberOfBots!=0){
    		bot = new Bot[numberOfBots];
    		for(int i=0;i<numberOfBots;i++){
    			switch(botLvl[i]){
    			case 'e':bot[i] = new EasyBot();break;
    			case 'n':bot[i] = new NormalBotMod2();break;
    			case 'h':bot[i] = new HardBotMod2();break;
    			}
    		}
    		
    	}
    	playersScore = new int[numberOfPlayers];
		for(int i=0;i<numberOfPlayers;i++)playersScore[i]=0;
    	for(int i=0;i<numberOfCards;i++){
    		mainTable[i] = -1;
    	}
    	Random r = new Random();
    	int x;
    	int x2;
    	for(int i=0;i<numberOfCards/2;i++){
    		while(true){
    		x = r.nextInt(numberOfCards);
    		x2 = r.nextInt(numberOfCards);
    		if(mainTable[x]==-1 && mainTable[x2]==-1 && x != x2)break;
    	}
       		System.out.println(""+mainTable[x]+"  "+mainTable[x2]);
    		mainTable[x]=i;
    		mainTable[x2]=i;
    	}
    	for(int i = 0; i< numberOfCards; i++){
    		System.out.println(""+mainTable[i]);
    	}
    	/*for(int i=0;i<13;i++){
    		mainTable[i]=i;
    		mainTable[i+13]=i;
    	}*/
		
    }
	
	 public static boolean gameCheck(){
 		int temp;
		click = false;
		fold_card=-1;
     	counter=0;
     	if(mainTable[x1] == mainTable[x2] && x1!=x2){
     		return true;
     	}
     	temp = mainTable[x1];
     	mainTable[x1] = mainTable[x2];
     	mainTable[x2] = temp;
     return false;
 }
	 public static void OpenCard(GUI gui, int cardNumber){
		 if(cardNumber==-1){
	    		moves++;
	    		counter=0;
	    		if(moves%numberOfPlayers>(numberOfPlayers-numberOfBots-1) && numberOfBots!=0){
	    			botPlay(gui);
	    		}
	    	}
	    	else{
	    	counter++;
	    	if(counter==1){
	    		x1=cardNumber;
	    		fold_card=x1;
	    		gui.unClicableButtons(x1);
	    	}
	    	else x2=cardNumber;
	    	if(counter==2){
	    	if(!gameCheck()){
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
	    		closeCard(gui,x1);
	    		closeCard(gui,x2);
	    		for(int i=0;i<numberOfBots;i++){
	    			switch(botLvl[i]){
		        	case 'e': break;
		        	case 'n': ((NormalBotMod2)bot[i]).playerSwap(x1,x2);break;
		        	case 'h': ((HardBotMod2)bot[i]).playerSwap(x1,x2);break;
		        	}
	    		}
	    		moves++;
	    		gui.clicableButtons(x1);
	    		click = true;
	    		WhoseTurn(gui);
	    		if(moves%numberOfPlayers>(numberOfPlayers-numberOfBots-1) && numberOfBots!=0){
	    			botPlay(gui);
	    		}
	    	}
	    	else {
	    		gui.unClicableButtons(x2);
	    		PairFound(gui);
	    		if(numberOfBots!=0){
	    			clickedButtonsB(x1);
	    			clickedButtonsB(x2);
	        	}
	    		click = true;
	    		int sumScore=0;
	    		for(int i=0;i<numberOfPlayers;i++){
	    			sumScore += playersScore[i];
	    		}
	    		if(sumScore == numberOfCards/2){
	    			GameOver(gui);
	        	}
	    		if(moves%numberOfPlayers>(numberOfPlayers-numberOfBots-1) && numberOfBots!=0){
	    			botPlay(gui);
	    		}
	    	}
	    	}
	    	}
	    }
	 
	 protected static void botPlay(GUI gui){
	    	gui.frame.setEnabled(false);
	    	try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {}
	    	int botToPlay = (moves%numberOfPlayers)-(numberOfPlayers-numberOfBots);
	    	switch(botLvl[botToPlay]){
	    	case 'e': ((EasyBot)bot[botToPlay]).OpenCard(gui);break;
	    	case 'n': ((NormalBot)bot[botToPlay]).OpenCardFirst(gui);break;
	    	case 'h': ((HardBot)bot[botToPlay]).OpenCardFirst(gui);break;
	    	}
	    	/*switch(botLvl){
	    	case 'e':easyBot[botToPlay].OpenCard(gui);break;
	    	case 'n':normalBot[botToPlay].OpenCardFirst(gui);break;
	    	case 'h':((HardBotMod2)hardBot[botToPlay]).OpenCardFirst(gui);break;
	    	}*/
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {}
			switch(botLvl[botToPlay]){
	    	case 'e': ((EasyBot)bot[botToPlay]).OpenCard(gui);break;
	    	case 'n': ((NormalBot)bot[botToPlay]).OpenCardSecond(gui);break;
	    	case 'h': ((HardBot)bot[botToPlay]).OpenCardSecond(gui);break;
	    	}
			/*switch(botLvl){
	    	case 'e':easyBot[botToPlay].OpenCard(gui);break;
	    	case 'n':normalBot[botToPlay].OpenCardSecond(gui);break;
	    	case 'h':((HardBotMod2)hardBot[botToPlay]).OpenCardSecond(gui);break;
	    	}*/
			gui.frame.setEnabled(true);
	    }

}
