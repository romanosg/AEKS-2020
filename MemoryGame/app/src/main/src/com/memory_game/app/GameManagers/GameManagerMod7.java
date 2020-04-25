package GameManagers;

import java.util.Random;
import Bots.*;
import project.GUI;

public class GameManagerMod7 extends GameManagerMod4{
	
	static GUI gui;
	public static boolean gameCheck(){
		click = false;
    	counter=0;
    	fold_card=-1;
    	String s=gui.iconsArray[mainTable[x1]].toString().substring(gui.iconsArray[mainTable[x1]].toString().length() -1-6);
    	String s2=gui.iconsArray[mainTable[x2]].toString().substring(gui.iconsArray[mainTable[x2]].toString().length() -1-6);
    	String s3=gui.iconsArray[mainTable[x3]].toString().substring(gui.iconsArray[mainTable[x3]].toString().length() -1-6);
    	if(s.charAt(0)==s2.charAt(0) && s.charAt(0) == s3.charAt(0) 
    			&& s.charAt(2)=='1' && s2.charAt(2)=='2'
    			&& x1!=x2 && x2!=x3){
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

    	protected static void InitTable(){
        	if(numberOfBots!=0){
        		bot = new Bot[numberOfBots];
        		for(int i=0;i<numberOfBots;i++){
        			switch(botLvl[i]){
        			case 'e':bot[i] = new EasyBotMod4();break;
        			case 'n':bot[i] = new NormalBotMod7(gui);break;
        			case 'h':bot[i] = new HardBotMod7(gui);break;
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
    		else if(counter == 2){
    			x2=cardNumber;
    			gui.unClicableButtons(x2);
    		}
    		else x3=cardNumber;
    		if(counter==3){
    		if(!gameCheck()){
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {}
    			closeCard(gui,x1);
    			closeCard(gui,x2);
    			closeCard(gui,x3);
    			moves++;
    			if(x1!=x2){
    			gui.clicableButtons(x1);
    			gui.clicableButtons(x2);
    			}
    			else gui.clicableButtons(x1);
    			click = true;
    			x2=-1;
    			WhoseTurn(gui);
    			if(moves%numberOfPlayers>(numberOfPlayers-numberOfBots-1) && numberOfBots!=0){
    				botPlay(gui);
    			}
    		}
    		else {
    			gui.unClicableButtons(x3);
    			PairFound(gui);
    			if(numberOfBots!=0){
    				clickedButtonsB(x1);
    				clickedButtonsB(x2);
    				clickedButtonsB(x3);
    	    	}
    			click = true;
    			x2=-1;
    			int sumScore=0;
    			for(int i=0;i<numberOfPlayers;i++){
    				sumScore += playersScore[i];
    			}
    			if(sumScore == numberOfCards/3){
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

