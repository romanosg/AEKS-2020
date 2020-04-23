package project;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import GameManagers.*;

public class Fold extends Grid{
	JButton fold;

	public Fold(int buttonsNumber, char c, JFrame frame) {
		super(buttonsNumber, c,frame);
		setFold();
    	frame.setVisible(true);
    	frame.setResizable(false);
	}

	private void setFold() {
		fold = new JButton();
		fold.setText("Fold");
		fold.setPreferredSize(new Dimension(150,70));
		fold.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(GameManagerNormal.click)fold();
			}
			
		});
		frame.add(fold);
	}

	private void fold(){
	
		switch(c){
		case'2':{
			GameManagerMod2.counter=1;
			st(new Thread(new OpenCardR(this, GameManagerMod2.fold_card,c)));
			break;
		}
			case'4':{
			GameManagerMod2_1.counter=1;
			st(new Thread(new OpenCardR(this, GameManagerMod2_1.fold_card,c)));
			break;
		}
			case'1':{
			GameManagerNormalMod1.counter=1;
			st(new Thread(new OpenCardR(this, GameManagerNormalMod1.fold_card,c)));
			break;
		}
			case'n':{
				GameManagerNormal.counter=1;
				st(new Thread(new OpenCardR(this, GameManagerNormal.fold_card,c)));
				break;
			}
			case'3':{
				GameManagerMod3.counter=3;
				if(GameManagerMod3.x2==-1)
					GameManagerMod3.x2 =GameManagerMod3.fold_card;
				if(GameManagerMod3.x3==-1)
					GameManagerMod3.x3 =GameManagerMod3.fold_card;
				st(new Thread(new OpenCardR(this, GameManagerMod3.fold_card,c)));
				break;
			}
				case'5':{
				GameManagerMod3_1.counter=3;
				if(GameManagerMod3_1.x2==-1)
					GameManagerMod3_1.x2 =GameManagerMod3_1.fold_card;
				if(GameManagerMod3_1.x3==-1)
					GameManagerMod3_1.x3 =GameManagerMod3_1.fold_card;
				st(new Thread(new OpenCardR(this, GameManagerMod3_1.fold_card,c)));
				break;}
				case'6':{
				GameManagerMod4.counter=2;
				if(GameManagerMod4.x2==-1)
					GameManagerMod4.x2 =GameManagerMod4.fold_card;
				st(new Thread(new OpenCardR(this, GameManagerMod4.fold_card,c)));
				break;}

		}
		
	}
	
}
