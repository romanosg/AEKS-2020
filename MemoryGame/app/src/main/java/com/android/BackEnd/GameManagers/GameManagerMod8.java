package com.android.BackEnd.GameManagers;

import java.util.Random;
import com.android.BackEnd.Bots.*;
import com.android.BackEnd.AndroidGui;
import com.android.Database.DBHandler;
import com.android.Database.Player;

public class GameManagerMod8 extends GameManagerNormal{
	static int playerCounter;
	
	public static void InitGameManager(AndroidGui gui, DBHandler dbhandler, int numberOfPlayersvar, int numberOfBotsvar, int numberOfCardsvar, char... botLvlvar){
    	numberOfPlayers = numberOfPlayersvar;
    	numberOfBots = numberOfBotsvar;
    	botLvl = botLvlvar;
    	numberOfCards = numberOfCardsvar;
    	mainTable = new int[numberOfCards*2];
    	db = dbhandler;
    	InitTable();
    	playerCounter=1;
    	gui.closeP2buttons();
    	gui.changeJLabels(2, gui.getName(0) + " picks a card");
    	if(numberOfPlayersvar==numberOfBotsvar)botPlay(gui);
    }

	public static boolean gameCheck(){
		click = false;
    	counter=0;
    	fold_card=-1;
    	System.out.println(""+mainTable[x1]+"  "+mainTable[x2]);
    	if(mainTable[x1] == mainTable[x2] && x1!=x2){
    		return true;
    	}
    return false;
}
	
	 private static void InitTable(){
	    	if(numberOfBots!=0){
	    		bot = new Bot[numberOfBots];
	    		for(int i=0;i<numberOfBots;i++){
	    			switch(botLvl[i]){
	    			case 'e':bot[i] = new EasyBotMod8();break;
	    			case 'n':bot[i] = new NormalBotMod8();break;
	    			case 'h':bot[i] = new HardBotMod8();break;
	    			}
	    		}
	    	}
	    	playersScore = new int[numberOfPlayers];
			for(int i=0;i<numberOfPlayers;i++)playersScore[i]=0;
	    	for(int i=0;i<numberOfCards*2;i++){
	    		mainTable[i] = -1;
	    	}
	    	Random r = new Random();
	    	int x;
	    	int x2;
	    	for(int i=0;i<numberOfCards;i++){
	    		while(true){
	    		x = r.nextInt(numberOfCards);
	    		x2 = r.nextInt(numberOfCards)+numberOfCards;
	    		if(mainTable[x]==-1 && mainTable[x2]==-1)break;
	    	}
	    		System.out.println(""+x+"  "+x2);
	    		mainTable[x]=i;
	    		mainTable[x2]=i;
	    		System.out.println(""+mainTable[x]+"  "+mainTable[x2]);
	    	}
			
	    }
	 
	public static void OpenCard(AndroidGui gui, int cardNumber){
	    	if(cardNumber==-1){
	    		moves++;
	    		counter=0;
	    		/*if(moves%numberOfPlayers>(numberOfPlayers-numberOfBots-1) && numberOfBots!=0){
	    			botPlay(gui);
	    		}*/
	    	}
	    	else{
	    	counter++;
	    	if(counter==1){
	    		x1=cardNumber;
	    		fold_card=x1;
                        gui.openCard(x1);
	    		gui.unClicableButtons(x1);
	    		if(playerCounter==1){
	    			gui.openP2buttons();
		    		gui.closeP1buttons();
		    		gui.changeJLabels(2, gui.getName(1) + " picks a card");
		    		if(numberOfBots>0){
		    			botPlay(gui);
		    		}
		    		else playerCounter=2;
		    		}
		    		else if(playerCounter==2){
		    			gui.changeJLabels(2, "Now " + gui.getName(1) + " picks first");
		    			playerCounter=3;
		    		}
		    		else if(playerCounter==3) {
		    			gui.closeP2buttons();
		    			gui.openP1buttons();
		    			gui.changeJLabels(2, gui.getName(0) + " picks a card");
		    			playerCounter=4;
		    		}
		    		else {
                                        gui.closeP2buttons();
		    			gui.openP1buttons();
		    			gui.changeJLabels(2, "Now " + gui.getName(0) + " picks first");
		    			playerCounter=1;
		    		}
	    	}
	    	else {
	    		x2=cardNumber;
	    		if(playerCounter==1){
		    		gui.closeP1buttons();
		    		gui.openP2buttons();
		    		gui.changeJLabels(2, gui.getName(1) + " picks a card");
		    		if(numberOfBots>0){
		    			botPlay(gui);
		    		}
		    		else playerCounter=2;
		    		}
		    		else if(playerCounter==2){
		    			gui.changeJLabels(2, "Now " + gui.getName(1) + " picks first");
		    			playerCounter=3;
		    		}
		    		else if(playerCounter==3) {
		    			gui.closeP2buttons();
		    			gui.openP1buttons();
		    			gui.changeJLabels(2, gui.getName(0) + " picks a card");
		    			playerCounter=4;
		    		}
		    		else {
                                        
		    			gui.changeJLabels(2, "Now " + gui.getName(0) + " picks first");
		    			playerCounter=1;
		    		}
	    	}
	    	if(counter==2){
                gui.closeButtons();
	    	if(!gameCheck()){
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
	    		closeCard(gui,x1);
	    		closeCard(gui,x2);
	    		moves++;
	    		gui.openP1buttons();
	    		click = true;
	    		//WhoseTurn(gui);
	    		/*if(moves%numberOfPlayers>(numberOfPlayers-numberOfBots-1) && numberOfBots!=0){
	    			botPlay(gui);
	    		}*/
	    	}
	    	else {
	    		gui.unClicableButtons(x2);
	    		PairFound(gui, playerCounter);
                        gui.rmButtons(x1,x2);
                        gui.openP1buttons();
	    		if(numberOfBots!=0){
	    			if(playerCounter==1 || playerCounter==4){
	    				clickedButtonsB(x1);
	    			}
	    			else{
		    			clickedButtonsB(x2);
	    			}
	        	}
	    		click = true;
	    		int sumScore=0;
	    		for(int i=0;i<numberOfPlayers;i++){
	    			sumScore += playersScore[i];
	    		}
	    		if(sumScore == numberOfCards){
	    			GameOver(gui);
	        	}
	    		/*if(moves%numberOfPlayers>(numberOfPlayers-numberOfBots-1) && numberOfBots!=0){
	    			botPlay(gui);
	    		}*/
	    	}
	    	}
	    	}
	    }
	
	 protected static void PairFound(AndroidGui gui, int x){
	    	switch(x){
	    	case 1:case 4:playersScore[0]++;break;
	    	case 2:case 3:playersScore[1]++; 
	    	}
	    	//playersScore[x]++;
	    	String s="";
		 	s = s+gui.getName(x) + "'s points: "+playersScore[x];
		 	gui.changeJLabels(x,s);
	    }

	 protected static void botPlay(AndroidGui gui){
	    	gui.closeButtons();
	    	playerCounter=2;
	    	try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {}
	    	switch(botLvl[0]){
	    	case 'e': ((EasyBotMod8)bot[0]).OpenCard(gui);break;
	    	case 'n': ((NormalBotMod8)bot[0]).OpenCardFirst(gui,x1);break;
	    	case 'h': ((HardBotMod8)bot[0]).OpenCardFirst(gui,x1);break;
	    	}
	    	try {
				Thread.sleep(1100);
			} catch (InterruptedException e1) {}
			switch(botLvl[0]){
	    	case 'e': ((EasyBotMod8)bot[0]).OpenCard(gui);break;
	    	case 'n': ((NormalBotMod8)bot[0]).OpenCardSecond(gui);break;
	    	case 'h': ((HardBotMod8)bot[0]).OpenCardSecond(gui);break;
	    	}
			gui.openP1buttons();
	   }

	 protected static void clickedButtonsB(int x){
	    		switch(botLvl[0]){
	    		case 'e': ((EasyBot)bot[0]).x1[x-numberOfCards]=1;break;
	    		case 'n': ((NormalBotMod8)bot[0]).x1[x-numberOfCards]=1;break;
	    		case 'h': ((HardBotMod8)bot[0]).x1[x-numberOfCards]=1;break;
	    	}
	    }

	protected static void GameOver(AndroidGui gui){
		if(playersScore[0]>playersScore[1]){
			Player winner = db.checkPlayer(gui.getName(0));
			winner.winsBattle();
			db.updateData(winner);
		}else if((playersScore[1]>playersScore[0])&&numberOfBots==0){
			Player winner = db.checkPlayer(gui.getName(1));
			winner.winsBattle();
			db.updateData(winner);
		}
		gui.changeJLabels(2, "The game is over");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {}
		gui.gameEnd();
	}
}
