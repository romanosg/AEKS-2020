package com.memory_game.app.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import GameManagers.GameManagerNormal;

public class Random extends GUI{
	
	java.util.Random r;

	public Random(int buttonsNumber, char c,JFrame frame) {
		super(buttonsNumber, c,frame);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	protected void buttons(int buttonsNumber){
    	boolean touches=true;
    	r = new java.util.Random();
    	buttonsArray = new JButton[buttonsNumber];
    	for(int i =0;i<buttonsNumber;i++){
    		System.out.println("!!!");
    		buttonsArray[i] = new JButton();
    		while(touches){
    			touches=false;
    		buttonsArray[i].setBounds(r.nextInt((screenSize.width-150)), r.nextInt(screenSize.height-450), 100, 150);
    		for(int y=0;y<i;y++){
    			if(buttonsArray[i].getBounds().intersects(buttonsArray[y].getBounds()))touches=true;
    		}
    		}
    		buttonsArray[i].setIcon(icon_Back_Cover);
    		buttonsArray[i].setText("button"+i);
    		buttonsArray[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
    				if(GameManagerNormal.click)handleEvent(e);      
                }
            });
    		touches=true;
    		}
    		
    		for(int i =0;i<buttonsNumber;i++)frame.add(buttonsArray[i]);
    }
	protected void setLabels(){
        labelsArray = new JLabel[2];
        labelsArray[0] = new JLabel();
        labelsArray[1] = new JLabel();
        labelsArray[0].setText("Player 1:");
        labelsArray[0].setBounds(0, screenSize.height-302, screenSize.width-10, 50);
        //labelsArray[0].setPreferredSize(new Dimension(screenSize.width-10,50));
        //labelsArray[0].setLocation(screenSize.width, screenSize.height-300);
        labelsArray[0].setBorder(border);
        frame.add(labelsArray[0]);
        labelsArray[1].setText("Player 2:");
        labelsArray[1].setBounds(0, screenSize.height-250, screenSize.width-10, 50);
        //labelsArray[1].setPreferredSize(new Dimension(screenSize.width-10,50));
        //labelsArray[1].setLocation(3, screenSize.height-150);
        labelsArray[1].setBorder(border);
        frame.add(labelsArray[1]);
    }

}
