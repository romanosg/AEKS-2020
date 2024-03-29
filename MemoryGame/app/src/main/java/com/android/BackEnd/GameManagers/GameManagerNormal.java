/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.android.BackEnd.GameManagers;

import java.util.Random;
import com.android.BackEnd.Bots.*;
import com.android.BackEnd.AndroidGui;
import com.android.Database.DBHandler;
import com.android.Database.Player;

/**
 * Αυτή η κλάση ελέγχει τη λογική του παιχνιδιού.
 *
 * @author Ιωάννα Σταϊνού 2466
 * @version Nov 2015
 */
public class GameManagerNormal extends GameManager {
	
	public static int[] mainTable;
	public static int x1;
	public static int fold_card=-1; 
	public static int x2;
	public static int x3;
	public static int x4;
	public static int numberOfPlayers;
	static int numberOfBots;
	public static int numberOfCards;
	static int p1score=0;
	static int p2score=0;
	public static int[] playersScore;
	static boolean botOn=false;
	static EasyBot[] easyBot;
	static NormalBot[] normalBot;
	static HardBot[] hardBot;
	static Bot[] bot;
	static char botLvl[];
	static int moves=0;
	public static boolean click = true;
	static DBHandler db;

	
    /**
     * Ελέγχει αν ο μετρητής είναι 2 και σε περίπτωση που είναι δύο, τότε
     * ελέγχει στον πίνακα καρτών εάν οι κάρτες έχουν το ίδιο κλειδί. Στην 
     * περίπτωση αυτή οι κάρτες παραμένουν ανοιχτές, αλλιώς αναποδογυρίζουν.
     */
	public static boolean gameCheck(){
		click = false;
    	counter=0;
    	System.out.println("The false one");
    	fold_card=-1;
    	if(mainTable[x1] == mainTable[x2] && x1!=x2 ){
    		return true;
    	}
    return false;
}
    
    public static void InitGameManager(AndroidGui gui, DBHandler dbhandler, int numberOfPlayersvar,int numberOfBotsvar, int numberOfCardsvar,char... botLvlvar){
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
    			case 'n':bot[i] = new NormalBot();break;
    			case 'h':bot[i] = new HardBot();break;
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
    }
    //In this function we implement the turn based logic of the game, here we specify the player and we evaluate the result of the cards he opened. We add the score and we start the next round. This function is overide in the other two gamemanagers and it implements the different modes.
    public static void OpenCard(AndroidGui gui, int cardNumber){
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
                gui.openCard(x1);
    		gui.unClicableButtons(x1);
    	}
    	else x2=cardNumber;
    	if(counter==2){
        gui.closeButtons();
    	if(!gameCheck()){
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
    		closeCard(gui,x1);
    		closeCard(gui,x2);
    		moves++;
    		gui.openButtons();
    		click = true;
    		WhoseTurn(gui);
    		if(moves%numberOfPlayers>(numberOfPlayers-numberOfBots-1) && numberOfBots!=0){
    			botPlay(gui);
    		}
    	}
    	else {
    		gui.unClicableButtons(x2);
    		PairFound(gui);
                gui.rmButtons(x1,x2);
                gui.openButtons();
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
    
    
    
    public static void closeCard(AndroidGui gui, int cardNumber){
    	gui.closeCard(cardNumber);
    }
    
    protected static void PairFound(AndroidGui gui){
    	int x = moves%numberOfPlayers;
    	playersScore[x]++;
    	String s="";
    	s = s+gui.getName(x) + ": " +playersScore[x];
    	gui.changeJLabels(x,s);

    }
    
    
    static void WhoseTurn(AndroidGui gui){
    	int x = moves%numberOfPlayers; 
    	gui.changeJLabelsTurn(x+1);
    }
    
    protected static void clickedButtonsB(int x){
    	for(int y=0;y<numberOfBots;y++){
    		switch(botLvl[y]){
    		case 'e': ((EasyBot)bot[y]).x1[x]=1;break;
    		case 'n': ((NormalBot)bot[y]).x1[x]=1;break;
    		case 'h': ((HardBot)bot[y]).x1[x]=1;break;
    		}
    	}
    }
    
    protected static void botPlay(AndroidGui gui){
    	gui.closeButtons();
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {}
    	int botToPlay = (moves%numberOfPlayers)-(numberOfPlayers-numberOfBots);
    	switch(botLvl[botToPlay]){
    	case 'e': ((EasyBot)bot[botToPlay]).OpenCard(gui);break;
    	case 'n': ((NormalBot)bot[botToPlay]).OpenCardFirst(gui);break;
    	case 'h': ((HardBot)bot[botToPlay]).OpenCardFirst(gui);break;
    	}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {}
		switch(botLvl[botToPlay]){
    	case 'e': ((EasyBot)bot[botToPlay]).OpenCard(gui);break;
    	case 'n': ((NormalBot)bot[botToPlay]).OpenCardSecond(gui);break;
    	case 'h': ((HardBot)bot[botToPlay]).OpenCardSecond(gui);break;
    	}
		gui.openButtons();
    }
    
    protected static void GameOver(AndroidGui gui){
		if(playersScore[0]>playersScore[1]){
			Player winner = db.checkPlayer(gui.getName(0));
			winner.winsPairsOf2();
			db.updateData(winner);
		}else if((playersScore[1]>playersScore[0])&&numberOfBots==0){
			Player winner = db.checkPlayer(gui.getName(1));
			winner.winsPairsOf2();
			db.updateData(winner);
		}
    	gui.changeJLabels(2, "The game is over");
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {}
    	gui.gameEnd();
    }


    	
}
