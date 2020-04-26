package com.memory_game.app.GameManagers;

import java.util.Random;
import Bots.*;
import project.*;

public class GameManagerMod5 extends GameManagerNormal{
	static GUI gui;
	
	
    /**
     * Ελέγχει αν ο μετρητής είναι 2 και σε περίπτωση που είναι δύο, τότε
     * ελέγχει στον πίνακα καρτών εάν οι κάρτες έχουν το ίδιο κλειδί. Στην 
     * περίπτωση αυτή οι κάρτες παραμένουν ανοιχτές, αλλιώς αναποδογυρίζουν.
     */
	public static boolean gameCheck(){
		click = false;
    	counter=0;
    	fold_card=-1;
    	String s=gui.iconsArray[mainTable[x1]].toString().substring(gui.iconsArray[mainTable[x1]].toString().length() -1-6);
    	String s2=gui.iconsArray[mainTable[x2]].toString().substring(gui.iconsArray[mainTable[x2]].toString().length() -1-6);
    	System.out.println(s.charAt(2));
    	if(s.charAt(0)==s2.charAt(0) && x1!=x2 && s.charAt(2)=='1'){
    		return true;
    	}
    return false;
}
    
    public static void InitGameManager(GUI guivar,int numberOfPlayersvar,int numberOfBotsvar, int numberOfCardsvar,char... botLvlvar){
    	numberOfPlayers = numberOfPlayersvar;
    	numberOfBots = numberOfBotsvar;
    	botLvl = botLvlvar;
    	numberOfCards = numberOfCardsvar;
    	mainTable = new int[numberOfCards];
    	gui =guivar;
    	InitTable();
    	if(numberOfPlayersvar==numberOfBotsvar)botPlay(gui);
    }
    
    private static void InitTable(){
    	if(numberOfBots!=0){
    		bot = new Bot[numberOfBots];
    		for(int i=0;i<numberOfBots;i++){
    			switch(botLvl[i]){
    			case 'e':bot[i] = new EasyBot();break;
    			case 'n':bot[i] = new NormalBotMod5(gui);break;
    			case 'h':bot[i] = new HardBotMod5(gui);break;
    			}
    		}
    		/*switch(botLvl){
    		case 'e':easyBot = new EasyBot[numberOfBots];
    		for(int y=0;y<numberOfBots;y++){
    			easyBot[y] = new EasyBot();
    		}break;
    		case 'n': normalBot = new NormalBot[numberOfBots];
    		for(int y=0;y<numberOfBots;y++){
    			normalBot[y] = new NormalBot();
    		}break;
    		case 'h':hardBot = new HardBot[numberOfBots];
    		for(int y=0;y<numberOfBots;y++){
    			hardBot[y] = new HardBot();
    		}break;*/
    	}
    	playersScore = new int[numberOfPlayers];
		for(int i=0;i<numberOfPlayers;i++)playersScore[i]=0;
    	for(int i=0;i<numberOfCards;i++){
    		mainTable[i] = -1;
    	}
    	Random r = new Random();
    	int x;
    	for(int i=0;i<numberOfCards;i++){
    		while(true){
    		x = r.nextInt(numberOfCards);
    		if(mainTable[x]==-1)break;
    	}
       		System.out.println(""+mainTable[x]);
    		mainTable[x]=i;
    	}
    	/*for(int i=0;i<13;i++){
    		mainTable[i]=i;
    		mainTable[i+13]=i;
    	}*/
		
    }
    
    public static void OpenCard(GUI gui, int cardNumber){
    	//gui.openCard(cardNumber);
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

}
