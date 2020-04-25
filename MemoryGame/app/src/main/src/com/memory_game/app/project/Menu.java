package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GameManagers.*;

public class Menu {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JFrame frame;
	JButton b1,b2,b3,b4,b5;
	int numberOfPlayers,numberOfBots,gameMod,guitype,pre_numberOfBots=0,special_mods;
	JSlider cardNumber,numberOfPlayers_S,numberOfBots_S;
	Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
	JComboBox[] cB;

	public Menu(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	start();
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	private void start(){
		 b1 = new JButton();
		 b1.setText("SOLO");
		 b2 = new JButton();
		 b2.setText("MULTIPLAYER");
		b1.setBounds((screenSize.width-555)/2, screenSize.height/2-300, 500, 200);
		b2.setBounds((screenSize.width-555)/2, screenSize.height/2-100, 500, 200);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			numberOfPlayers =1;
			mods();
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			numberOfPlayers =1;
			m_mods();
			}
		});
		frame.add(b1);
		frame.add(b2);
	}
	private void mods(){
		frame.remove(b1);
		frame.remove(b2);
		 b1 = new JButton();
		 b1.setText("NORMAL");
		 b3 = new JButton();
		 b2 = new JButton();
		 b2.setText("THREE CARDS");
		 b3.setText("FOUR CARDS");
		 	b1.setBounds((screenSize.width-555)/2, screenSize.height/2-350, 500, 200);
			b2.setBounds((screenSize.width-555)/2, screenSize.height/2-150, 500, 200);
			b3.setBounds((screenSize.width-555)/2, screenSize.height/2+50, 500, 200);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			gameMod =1;
			special_mods_n();
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			gameMod =2;
			special_mods();
			}
		});
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			gameMod =3;
			special_mods();
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.repaint();
	}
	private void guitypes(){
		frame.remove(b1);
		frame.remove(b2);
		frame.remove(b3);
		 b1 = new JButton();
		 b1.setText("GRID");
		 b2 = new JButton();
		 b2.setText("RANDOM");
		b1.setBounds((screenSize.width-555)/2, screenSize.height/2-350, 500, 200);
		b2.setBounds((screenSize.width-555)/2, screenSize.height/2-150, 500, 200);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			guitype =1;
			if(gameMod==1)play(8,48,2);
			else if(gameMod==2)play(9,48,3);
			else play(8,48,4);
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			guitype =2;
			if(gameMod==1)play(8,22,2);
			else if(gameMod==2)play(9,21,3);
			else play(8,20,4);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.repaint();
	}
	public void play(int min,int x,int y){
		frame.remove(b1);
		frame.remove(b2);
		b1 = new JButton();
		b1.setText("CONFIRM");
		b1.setBounds((screenSize.width-520)/2, screenSize.height/2-300, 500, 200);
		cardNumber = new JSlider();
		cardNumber.setBounds((screenSize.width-520)/2, screenSize.height/2-10, 500, 200);
		cardNumber.setMaximum(x);
		cardNumber.setMinimum(min);
		cardNumber.setMajorTickSpacing(y);
		cardNumber.setPaintTicks(true);
		cardNumber.setPaintLabels(true);
		cardNumber.setSnapToTicks(true);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(cardNumber);
				frame.remove(b1);
				if(guitype==1){//GRID
					if(gameMod==1){//NORMAL
						if(special_mods==2){//Normal
						Grid mainFrame = new Grid(cardNumber.getValue(),'n',frame);
						GameManagerNormal.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
						}
					else if(special_mods==1){//card swap
						Grid mainFrame = new Grid(cardNumber.getValue(),'2',frame);
						GameManagerMod2.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
					}
					else if(special_mods==3){//Certain_queue
						Certain_queue mainFrame = new Certain_queue(cardNumber.getValue(),'8',frame);
						GameManagerMod5.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
					}
					}
					else if(gameMod==2){//3 Cards
						if(special_mods==1){
						Grid mainFrame = new Grid(cardNumber.getValue(),'6',frame);
						GameManagerMod4.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
						}
						else if(special_mods==2){
							Certain_queue mainFrame = new Certain_queue(cardNumber.getValue(),'a',frame);
							GameManagerMod7.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
						}
					}
					else if(gameMod==3){//4 cards
						if(special_mods==1){
							Grid mainFrame = new Grid(cardNumber.getValue(),'3',frame);
							GameManagerMod3.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
							}
							else if(special_mods==2){
								Certain_queue mainFrame = new Certain_queue(cardNumber.getValue(),'9',frame);
								GameManagerMod6.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
							}
					}
				}
				else if(guitype==2){//Random
					if(gameMod==1){//Normal
						if(special_mods==2){//Normal
							Random mainFrame = new Random(cardNumber.getValue(),'n',frame);
							GameManagerNormal.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
							}
						else if(special_mods==1){//card swap
							Random mainFrame = new Random(cardNumber.getValue(),'2',frame);
							GameManagerMod2.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
						}
					}
					else if(gameMod==2){//3 Cards
						Random mainFrame = new Random(cardNumber.getValue(),'6',frame);
						GameManagerMod4.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
					}
					else if(gameMod==3){//4 cards
						Random mainFrame = new Random(cardNumber.getValue(),'3',frame);
						GameManagerMod3.InitGameManager(mainFrame,numberOfPlayers,numberOfBots,cardNumber.getValue(),'h','h');
					}
				}
				frame.repaint();	
			}
		});
		frame.add(b1);
		frame.add(cardNumber);
		frame.repaint();
	}
	private void m_special_mods_n(){
		frame.remove(b1);
		frame.remove(b2);
		frame.remove(b3);
		frame.remove(b4);
		 b1 = new JButton();
		 b1.setText("DRAW ONCE");
		 b2 = new JButton();
		 b2.setText("CARD SWAP");
		 b3= new JButton();
		 b3.setText("DRAW ONCE AND CARD SWAP");
		 b4 = new JButton();
		 b4.setText("NORMAL");
		 b5 = new JButton();
		 b5.setText("WITH STANDAR QUEUE");
		b1.setBounds((screenSize.width-555)/2, screenSize.height/2-520, 500, 200);
		b2.setBounds((screenSize.width-555)/2, screenSize.height/2-320, 500, 200);
		b3.setBounds((screenSize.width-555)/2, screenSize.height/2-120, 500, 200);
		b4.setBounds((screenSize.width-555)/2, screenSize.height/2+80, 500, 200);
		b5.setBounds((screenSize.width-555)/2, screenSize.height/2+280, 500, 200);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =1;
			frame.remove(b4);
			frame.remove(b1);
			frame.remove(b2);
			frame.remove(b5);
			frame.remove(b3);
			m_guitypes();
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =2;
			frame.remove(b4);
			frame.remove(b1);
			frame.remove(b2);
			frame.remove(b3);
			frame.remove(b5);
			m_guitypes();
			}
		});
		b4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =4;
			frame.remove(b4);
			frame.remove(b1);
			frame.remove(b2);
			frame.remove(b3);
			frame.remove(b5);
			m_guitypes();
			}
		});
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =3;
			frame.remove(b4);
			frame.remove(b1);
			frame.remove(b2);
			frame.remove(b3);
			frame.remove(b5);
			m_guitypes();
			}
		});
		b5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =5;
			frame.remove(b4);
			frame.remove(b5);
			guitype = 1;
			m_play(6,48,2);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.repaint();
	}
	private void m_mods(){
		frame.remove(b1);
		frame.remove(b2);
		 b1 = new JButton();
		 b1.setText("NORMAL");
		 b3 = new JButton();
		 b2 = new JButton();
		 b4 = new JButton();
		 b2.setText("TRIO");
		 b3.setText("QUARTETO");
		b1.setBounds((screenSize.width-555)/2, screenSize.height/2-450, 500, 200);
		b2.setBounds((screenSize.width-555)/2, screenSize.height/2-250, 500, 200);
		b3.setBounds((screenSize.width-555)/2, screenSize.height/2-50, 500, 200);
		b4.setBounds((screenSize.width-555)/2, screenSize.height/2+150, 500, 200);
		b4.setText("BATTLE");
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			gameMod =1;
			m_special_mods_n();
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			gameMod =2;
			m_special_mods();
			}
		});
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			gameMod =3;
			m_special_mods();
			}
		});
		b4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			gameMod =4;
			frame.remove(b4);
			m_play(8,24,2);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.repaint();
	}
	private void m_guitypes(){
		 b1 = new JButton();
		 b1.setText("GRID");
		 b2 = new JButton();
		 b2.setText("RANDOM");
		 b3 = new JButton();
		 b3.setText("FOLD");
		b1.setBounds((screenSize.width-555)/2, screenSize.height/2-350, 500, 200);
		b2.setBounds((screenSize.width-555)/2, screenSize.height/2-150, 500, 200);
		b3.setBounds((screenSize.width-555)/2, screenSize.height/2+50, 500, 200);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			guitype =1;
			if(gameMod==1)m_play(8,22,2);
			else if(gameMod==2)m_play(9,21,3);
			else m_play(8,20,4);
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			guitype =2;
			if(gameMod==1)m_play(8,22,2);
			else if(gameMod==2)m_play(9,21,3);
			else m_play(8,20,4);
			}
		});
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			guitype =3;
			if(gameMod==1)m_play(8,22,2);
			else if(gameMod==2)m_play(9,21,3);
			else m_play(8,20,4);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.repaint();
	}

	public void m_play(int min,int x,int y){
		cB = new JComboBox[10];
		frame.remove(b1);
		frame.remove(b2);
		frame.remove(b3);
		b1 = new JButton();
		b1.setText("CONFIRM");
		b1.setBounds((screenSize.width-520)/2, 50, 500, 200);
		JLabel label1 = new JLabel();
		label1.setText("Number Of Cards");
		label1.setBounds((screenSize.width)/2-55, 250, screenSize.width-100, 30);
		JLabel label2 = new JLabel();
		label2.setText("Number Of Players");
		label2.setBounds((screenSize.width)/2-55, 350, screenSize.width-100, 30);
		JLabel label3 = new JLabel();
		label3.setText("Number Of Bots");
		label3.setBounds((screenSize.width)/2-55, 450, screenSize.width-100, 30);
		cardNumber = new JSlider();
		cardNumber.setBounds((screenSize.width-520)/2, 300, 500, 50);
		cardNumber.setMaximum(x);
		cardNumber.setMinimum(min);
		cardNumber.setMajorTickSpacing(y);
		cardNumber.setPaintTicks(true);
		cardNumber.setPaintLabels(true);
		cardNumber.setSnapToTicks(true);
		cardNumber.setToolTipText("Number Of Cards");
		numberOfPlayers_S = new JSlider();
		numberOfPlayers_S.setBounds((screenSize.width-520)/2, 400, 500, 50);
		numberOfPlayers_S.setMaximum(10);
		numberOfPlayers_S.setMinimum(1);
		numberOfPlayers_S.setMajorTickSpacing(1);
		numberOfPlayers_S.setPaintTicks(true);
		numberOfPlayers_S.setPaintLabels(true);
		numberOfPlayers_S.setSnapToTicks(true);
		numberOfPlayers_S.setValue(1);
		numberOfBots_S = new JSlider();
		numberOfBots_S.setBounds((screenSize.width-520)/2, 500, 500, 50);
		numberOfBots_S.setMaximum(9);
		numberOfBots_S.setMinimum(0);
		numberOfBots_S.setMajorTickSpacing(1);
		numberOfBots_S.setPaintTicks(true);
		numberOfBots_S.setPaintLabels(true);
		numberOfBots_S.setSnapToTicks(true);
		numberOfBots_S.setValue(0);
		numberOfBots_S.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(numberOfBots_S.getValue()<pre_numberOfBots){
						frame.remove(cB[numberOfBots_S.getValue()]);
						pre_numberOfBots=numberOfBots_S.getValue();
						frame.revalidate();
						frame.repaint();
				}
				else if(numberOfBots_S.getValue()!=pre_numberOfBots){
				String[] bot_lvl={"easy","normal","hard"};
				for(int i=pre_numberOfBots;i<numberOfBots_S.getValue();i++){
				cB[i] = new JComboBox<String>(bot_lvl);
				cB[i].setBounds(screenSize.width/2-100, 600+(i*30),200, 30);
				frame.add(cB[i]);
			}
				pre_numberOfBots=numberOfBots_S.getValue();
				frame.revalidate();
				frame.repaint();
				}
				else{
					frame.revalidate();
					frame.repaint();
				}
			}
			
		});
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				char [] c;
				c=new char[10];
				for(int i=0;i<numberOfBots_S.getValue();i++){
					c[i] = cB[i].getSelectedItem().toString().charAt(0);
				}
				frame.remove(cardNumber);
				frame.remove(b1);
				for(int i=0;i<numberOfBots_S.getValue();i++){
					frame.remove(cB[i]);
				}
				frame.remove(numberOfBots_S);
				frame.remove(numberOfPlayers_S);
				frame.remove(label3);
				frame.remove(label2);
				frame.remove(label1);
				if(gameMod==4){
					int x = numberOfBots_S.getValue();
					if(x>0)x=1;
					else x=0;
					Battle mainFrame = new Battle(cardNumber.getValue(),'b',frame);
					GameManagerMod8.InitGameManager(mainFrame,2,x,cardNumber.getValue(),c);
				}
				else{
				if(guitype==1){ //GRID
						if(gameMod==1){ //Normal
							if(special_mods==4){ // Normal
						Grid mainFrame = new Grid(cardNumber.getValue(),'n',frame);
						GameManagerNormal.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
							}
							else if(special_mods==1){ //Draw once
								Grid mainFrame = new Grid(cardNumber.getValue(),'1',frame);
								GameManagerNormalMod1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
									}
							else if(special_mods==2){ //Swap Card
								Grid mainFrame = new Grid(cardNumber.getValue(),'2',frame);
								GameManagerMod2.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
									}
							else if(special_mods==3){ //Draw Once and Card Swap
								Grid mainFrame = new Grid(cardNumber.getValue(),'4',frame);
								GameManagerMod2_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
									}
							else if(special_mods==5){ //Standar Queue
								Certain_queue mainFrame = new Certain_queue(cardNumber.getValue(),'8',frame);
								GameManagerMod5.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
									}
					}
					else if(gameMod==2){ // 3 Cards
						if(special_mods==1){ // Draw Once
						Grid mainFrame = new Grid(cardNumber.getValue(),'7',frame);
						GameManagerMod4_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
							}
						else if(special_mods==2){ // Normal
							Grid mainFrame = new Grid(cardNumber.getValue(),'6',frame);
							GameManagerMod4.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
							}
						else if(special_mods==3){//Standar Queue
							Certain_queue mainFrame = new Certain_queue(cardNumber.getValue(),'a',frame);
							GameManagerMod7.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
					}
					else if(gameMod==3){ // 4 Cards
						if(special_mods==1){ // Draw Once
						Grid mainFrame = new Grid(cardNumber.getValue(),'5',frame);
						GameManagerMod3_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
							}
						else if(special_mods==2){ // Normal
							Grid mainFrame = new Grid(cardNumber.getValue(),'3',frame);
							GameManagerMod3.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
								}
						else if(special_mods==3){//Standar Queue
							Certain_queue mainFrame = new Certain_queue(cardNumber.getValue(),'9',frame);
							GameManagerMod6.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
						}
				}
				else if(guitype==2){//Random
					if(gameMod==1){ //Normal
						if(special_mods==4){ // Normal
					Random mainFrame = new Random(cardNumber.getValue(),'n',frame);
					GameManagerNormal.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
						else if(special_mods==1){ //Draw once
							Random mainFrame = new Random(cardNumber.getValue(),'1',frame);
							GameManagerNormalMod1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
								}
						else if(special_mods==2){ //Swap Card
							Random mainFrame = new Random(cardNumber.getValue(),'2',frame);
							GameManagerMod2.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
								}
						else if(special_mods==3){ //Draw Once and Card Swap
							Random mainFrame = new Random(cardNumber.getValue(),'4',frame);
							GameManagerMod2_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
								}
				}
				else if(gameMod==2){ // 3 Cards
					if(special_mods==1){ // Draw Once
						Random mainFrame = new Random(cardNumber.getValue(),'7',frame);
					GameManagerMod4_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
					else if(special_mods==2){ // Normal
						Random mainFrame = new Random(cardNumber.getValue(),'6',frame);
						GameManagerMod4.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
				}
				else if(gameMod==3){ // 4 Cards
					if(special_mods==1){ // Draw Once
						Random mainFrame = new Random(cardNumber.getValue(),'5',frame);
					GameManagerMod3_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
					else if(special_mods==2){ // Normal
						Random mainFrame = new Random(cardNumber.getValue(),'3',frame);
						GameManagerMod3.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
							}
					}
				}
				else if(guitype==3){ //Fold
					if(gameMod==1){ //Normal
						if(special_mods==4){ // Normal
					Fold mainFrame = new Fold(cardNumber.getValue(),'n',frame);
					GameManagerNormal.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
						else if(special_mods==1){ //Draw once
							Fold mainFrame = new Fold(cardNumber.getValue(),'1',frame);
							GameManagerNormalMod1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
								}
						else if(special_mods==2){ //Swap Card
							Fold mainFrame = new Fold(cardNumber.getValue(),'2',frame);
							GameManagerMod2.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
								}
						else if(special_mods==3){ //Draw Once and Card Swap
							Fold mainFrame = new Fold(cardNumber.getValue(),'4',frame);
							GameManagerMod2_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
								}
				}
				else if(gameMod==2){ // 3 Cards
					if(special_mods==1){ // Draw Once
						Fold mainFrame = new Fold(cardNumber.getValue(),'7',frame);
					GameManagerMod4_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
					else if(special_mods==2){ // Normal
						Fold mainFrame = new Fold(cardNumber.getValue(),'6',frame);
						GameManagerMod4.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
				}
				else if(gameMod==3){ // 4 Cards
					if(special_mods==1){ // Draw Once
						Fold mainFrame = new Fold(cardNumber.getValue(),'5',frame);
					GameManagerMod3_1.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
						}
					else if(special_mods==2){ // Normal
						Fold mainFrame = new Fold(cardNumber.getValue(),'3',frame);
						GameManagerMod3.InitGameManager(mainFrame,numberOfPlayers_S.getValue(),numberOfBots_S.getValue(),cardNumber.getValue(),c);
							}
					}
				}
			}
				frame.repaint();	
			}
		});
		frame.add(b1);
		frame.add(cardNumber);
		frame.add(numberOfBots_S);
		frame.add(numberOfPlayers_S);
		frame.add(label3);
		frame.add(label2);
		frame.add(label1);
		frame.repaint();
	}
	private void m_special_mods(){
		frame.remove(b1);
		frame.remove(b2);
		frame.remove(b3);
		frame.remove(b4);
		 b1 = new JButton();
		 b1.setText("DRAW ONCE");
		 b2 = new JButton();
		 b2.setText("NORMAL");
		 b3 =new JButton();
		 b4 =new JButton();
		 b3.setText("WITH STANDAR QUEUE");
		b1.setBounds((screenSize.width-555)/2, screenSize.height/2-350, 500, 200);
		b2.setBounds((screenSize.width-555)/2, screenSize.height/2-150, 500, 200);
		b3.setBounds((screenSize.width-555)/2, screenSize.height/2+50, 500, 200);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =1;
			frame.remove(b1);
			frame.remove(b2);
			frame.remove(b3);
			m_guitypes();
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =2;
			frame.remove(b1);
			frame.remove(b2);
			frame.remove(b3);
			m_guitypes();
			}
		});
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =3;
			guitype =1;
			if(gameMod==3)m_play(4,48,4);
			else if(gameMod==2)m_play(6,48,3);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.repaint();
	}
	private void special_mods_n(){
		frame.remove(b1);
		frame.remove(b2);
		frame.remove(b3);
		 b1 = new JButton();
		 b1.setText("CARD SWAP");
		 b2 = new JButton();
		 b2.setText("NORMAL");
		 b3 = new JButton();
		 b3.setText("WITH STANDAR QUEUE");
		b1.setBounds((screenSize.width-555)/2, screenSize.height/2-350, 500, 200);
		b2.setBounds((screenSize.width-555)/2, screenSize.height/2-150, 500, 200);
		b3.setBounds((screenSize.width-555)/2, screenSize.height/2+50, 500, 200);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =1;
			guitypes();
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =2;
			guitypes();
			}
		});
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =3;
			guitype = 1;
			frame.remove(b3);
			play(6,48,2);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.repaint();
	}
	private void special_mods(){
		frame.remove(b1);
		frame.remove(b2);
		frame.remove(b3);
		 b1 = new JButton();
		 b1.setText("NORMAL");
		 b2 = new JButton();
		 b2.setText("WITH STANDAR QUEUE");
		b1.setBounds((screenSize.width-555)/2, screenSize.height/2-300, 500, 200);
		b2.setBounds((screenSize.width-555)/2, screenSize.height/2-100, 500, 200);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =1;
			guitypes();
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			special_mods =2;
			guitype = 1;
			if(gameMod==2)play(6,48,3);
			else if(gameMod==3)play(8,48,4);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.repaint();
	}
	
}
