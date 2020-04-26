package com.memory_game.app.GameManagers;

import project.GUI;

public class GameManagerMod4_1 extends GameManagerMod4{

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
			moves++;
			WhoseTurn(gui);
		if(!gameCheck()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			closeCard(gui,x1);
			closeCard(gui,x2);
			closeCard(gui,x3);
			if(x1!=x2){
			gui.clicableButtons(x1);
			gui.clicableButtons(x2);
			}
			else gui.clicableButtons(x1);
			click = true;
			x2=-1;
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
	
	protected static void PairFound(GUI gui){
    	int x = (moves-1)%numberOfPlayers;
    	playersScore[x]++;
    	String s="";
    	for(int i=0;i<numberOfPlayers;i++){
    		s = s+"Player"+(i+1)+"'s score: "+playersScore[i]+"   \n";
    	}
    	gui.changeJLabels(0,s);
    }
	
}
