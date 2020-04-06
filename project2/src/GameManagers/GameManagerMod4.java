package GameManagers;

import java.util.Random;

import project.*;
import Bots.*;

//anoigoun 3 kartes
public class GameManagerMod4 extends GameManagerNormal{

    public static boolean gameCheck(){
		click = false;
    	counter=0;
    	fold_card=-1;
    	if(mainTable[x1] == mainTable[x2] && mainTable[x1] == mainTable[x3]
    			&& x1!=x2 && x1!=x3){
    		return true;
    	}
    return false;
}

public static void InitGameManager(GUI gui,int numberOfPlayersvar,int numberOfBotsvar, int numberOfCardsvar,char... botLvlvar){
	numberOfPlayers = numberOfPlayersvar;
	numberOfBots = numberOfBotsvar;
	botLvl = botLvlvar;
	numberOfCards = numberOfCardsvar;
	mainTable = new int[numberOfCards];
	InitTable();
	x2=-1;
	if(numberOfPlayersvar==numberOfBotsvar)botPlay(gui);
}

protected static void InitTable(){
	if(numberOfBots!=0){
		bot = new Bot[numberOfBots];
		for(int i=0;i<numberOfBots;i++){
			switch(botLvl[i]){
			case 'e':bot[i] = new EasyBotMod4();break;
			case 'n':bot[i] = new NormalBotMod4();break;
			case 'h':bot[i] = new HardBotMod4();break;
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
	int x2,x3;
	for(int i=0;i<numberOfCards/3;i++){
		while(true){
		x = r.nextInt(numberOfCards);
		x2 = r.nextInt(numberOfCards);
		x3 = r.nextInt(numberOfCards);
		if(mainTable[x]==-1 && mainTable[x2]==-1 && mainTable[x3]==-1
			 && x != x2 && x!=x3 && x2!=x3)break;
	}
   		System.out.println(""+mainTable[x]+"  "+mainTable[x2]+"  "+mainTable[x3]);
		mainTable[x]=i;
		mainTable[x2]=i;
		mainTable[x3]=i;
	/*for(int i=0;i<13;i++){
		mainTable[i]=i;
		mainTable[i+13]=i;
	}*/
	}	
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


protected static void botPlay(GUI gui){
	gui.frame.setEnabled(false);
	try {
		Thread.sleep(500);
	} catch (InterruptedException e1) {}
	int botToPlay = (moves%numberOfPlayers)-(numberOfPlayers-numberOfBots);
	switch(botLvl[botToPlay]){
	case 'e': ((EasyBotMod4)bot[botToPlay]).OpenCard(gui);break;
	case 'n': ((NormalBotMod4)bot[botToPlay]).OpenCardFirst(gui);break;
	case 'h': ((HardBotMod4)bot[botToPlay]).OpenCardFirst(gui);break;
	}
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {}
	switch(botLvl[botToPlay]){
	case 'e': ((EasyBotMod4)bot[botToPlay]).OpenCard(gui);break;
	case 'n': ((NormalBotMod4)bot[botToPlay]).OpenCardSecond(gui); break;
	case 'h': ((HardBotMod4)bot[botToPlay]).OpenCardSecond(gui);break;
	}
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {}
	switch(botLvl[botToPlay]){
	case 'e': ((EasyBotMod4)bot[botToPlay]).OpenCard(gui);break;
	case 'n': ((NormalBotMod4)bot[botToPlay]).OpenCardThird(gui);break;
	case 'h': ((HardBotMod4)bot[botToPlay]).OpenCardThird(gui);break;
	}
	gui.frame.setEnabled(true);
}

	
}
