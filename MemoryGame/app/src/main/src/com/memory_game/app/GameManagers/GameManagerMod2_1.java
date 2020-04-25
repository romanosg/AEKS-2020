package GameManagers;

import project.GUI;
import Bots.*;

public class GameManagerMod2_1 extends GameManagerMod2{

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
    		moves++;
    		WhoseTurn(gui);
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
    		
    		/*switch(botLvl){
	    	case 'e':break;
	    	case 'n':for(int i=0;i<numberOfBots;i++){
     			((NormalBotMod2) normalBot[i]).playerSwap(x1,x2);
     		}break;
	    	case 'h':for(int i=0;i<numberOfBots;i++){
     			((HardBotMod2) hardBot[i]).playerSwap(x1,x2);
     		}break;
	    	}*/
    		gui.clicableButtons(x1);
    		click = true;
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
