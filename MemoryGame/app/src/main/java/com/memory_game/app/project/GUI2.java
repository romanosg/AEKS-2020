/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory_game.app.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SplashScreen;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import GameManagers.GameManagerNormal;
/**
 * Αυτή η κλάση περιέχει τις μεθόδους της γραφικής διεπαφής χρήστη
 * του Project.
 *
 * @author Ιωάννα Σταϊνού 2466
 * @version Nov 2015
 */
public class GUI {
	public JFrame frame;
	JButton[] buttonsArray;
	JLabel[] labelsArray;
	public ImageIcon[] iconsArray;
	ImageIcon icon_Back_Cover;
	SplashScreen screen;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
	char c;
    /**
     * Κατασκευάζει ένα πλέγμα από κουμπιά. Καλεί την μέθοδο
     * setFrame, η οποία αρχικοποιεί ένα καινούριο JFrame. Καλεί τη setIcons η 
     * οποία εισάγει τις εικώνες και στη συνέχεια καλεί τη buttons η οποία αρχηκοποιέι
     * ενα πλέγμα από κουμπιά. Τέλος καλεί την setLabels() και αρχηκοποιεί τα labels.
     * @param buttonsNumber αριθμός κουμπιών
     */
    public GUI(int buttonsNumber, char c,JFrame frame){
    	this.frame = frame;
    	setFrame();
    	this.c = c;	
    	int x=buttonsNumber/8;
    	if(buttonsNumber%8!=0)x++;
    	if(x<=3 && x>1)setIcons_medium(buttonsNumber);
    	else if(x<=4 && x>3)setIcons_large(buttonsNumber);
    	else if(x<=6 && x>4)setIcons_xsmall(buttonsNumber);
    	else setIcons(buttonsNumber);
    	buttons(buttonsNumber);
    	setLabels();
    }
    /**
     * Συνδέει  αντικείμενα που παράγουν γεγονότα(κουμπιά) με αντικείμενα που
     * ακούνε για γεγονότα(listeners) και περέχουν κώδικα διαχείρισής τους.
     *
     * @param e αντικείμενο με πληροφορίες που αφορούν την αλληλεπίδραση του 
     * χρήστη με κάποιο συστατικό.
     */
    protected void handleEvent(ActionEvent e) {
    	String s=e.getActionCommand();
    	s=s.substring(s.length()-2);
    	if(s.charAt(0)=='n')s=s.substring(1);
    	openCard(Integer.parseInt(s));
    	st(new Thread(new OpenCardR(this, Integer.parseInt(s),c)));
    }


    /**
     * Αρχηκοποιεί ένα καινούριο JFrame με μέγεθος όλη την οθόνη, με τίτλο 
     * παιχνίδι μνήμης.
     *
     */
    private void setFrame(){
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    /**
     * Εισάγει τα αριθμό εικονιδίων iconsNumber για τις κάρτες σε ένα πίνακα και ένα για τη πίσω πλευρά των 
     * καρτών.
     * @param iconsNumber αριθμός εικονιδίων
     */
    protected void setIcons(int iconsNumber){
    	System.out.println("normal");
    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
    	System.out.println(icon_Back_Cover.getImage().toString());
    	iconsArray = new ImageIcon[iconsNumber];
           for(int i=0;i<iconsNumber/2;i++){
        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/img/"+i+".jpg"));
           	  iconsArray[iconsNumber-i-1] = new ImageIcon(GUI.class.getResource("/img/"+i+".jpg"));
           }
           }
    protected void setIcons_medium(int iconsNumber){
    	System.out.println("medium");
    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/medium_img/Back_Cover.jpg"));
    	System.out.println(icon_Back_Cover.getImage().toString());
    	iconsArray = new ImageIcon[iconsNumber];
           for(int i=0;i<iconsNumber/2;i++){
        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/medium_img/"+i+".jpg"));
           	  iconsArray[iconsNumber-i-1] = new ImageIcon(GUI.class.getResource("/medium_img/"+i+".jpg"));
           }
           }
    protected void setIcons_large(int iconsNumber){
    	System.out.println("large");
    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/large_img/Back_Cover.jpg"));
    	System.out.println(icon_Back_Cover.getImage().toString());
    	iconsArray = new ImageIcon[iconsNumber];
           for(int i=0;i<iconsNumber/2;i++){
        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/large_img/"+i+".jpg"));
           	  iconsArray[iconsNumber-i-1] = new ImageIcon(GUI.class.getResource("/large_img/"+i+".jpg"));
           }
           }
    protected void setIcons_xsmall(int iconsNumber){
    	System.out.println("small");
    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/large_img/Back_Cover.jpg"));
    	System.out.println(icon_Back_Cover.getImage().toString());
    	iconsArray = new ImageIcon[iconsNumber];
           for(int i=0;i<iconsNumber/2;i++){
        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/xsmall_img/"+i+".jpg"));
           	  iconsArray[iconsNumber-i-1] = new ImageIcon(GUI.class.getResource("/xsmall_img/"+i+".jpg"));
           }
           }
           
    /**
     * Αρχηκοποιεί τα JLabels.
     */
    protected void setLabels(){
        labelsArray = new JLabel[2];
        labelsArray[0] = new JLabel();
        labelsArray[1] = new JLabel();
        labelsArray[0].setText("Player 1:");
        labelsArray[0].setPreferredSize(new Dimension(screenSize.width-10,50));
        labelsArray[0].setLocation(screenSize.width, screenSize.height-300);
        labelsArray[0].setBorder(border);
        frame.add(labelsArray[0]);
        labelsArray[1].setText("Player 2:");
        labelsArray[1].setPreferredSize(new Dimension(screenSize.width-10,50));
        labelsArray[1].setLocation(3, screenSize.height-150);
        labelsArray[1].setBorder(border);
        frame.add(labelsArray[1]);
    }
    /** 
     * Αρχηκοποιεί αριθμό κουμπιών buttonsMumber. Για το καθένα κάνει το text bi (όπου i από 0
     * εώς buttonsNumber-1). Βάζει την ίδια εικόνα για κάθε κουμπί και δημιουργεί έναν ActionListener
     * για κάθε κουμπί.
     * @param buttonsNumber αριθμός κουμπιών
     */
    protected void buttons(int buttonsNumber){
    	int x,l=0;
    	if(buttonsNumber/2>8)x=8;
    	else x= buttonsNumber/2;
    	if(buttonsNumber%x!=0)l=1;
    	buttonsArray = new JButton[buttonsNumber];
    	for(int i =0;i<buttonsNumber;i++){
    		buttonsArray[i] = new JButton();
    		buttonsArray[i].setPreferredSize(new Dimension((screenSize.width-100)/x,(screenSize.height-300)/((buttonsNumber/x)+l)));//(buttonsNumber/13)));
    		System.out.println(""+(screenSize.width-100)/x+"  "+(screenSize.height-300)/((buttonsNumber/x)+l));
    		buttonsArray[i].setIcon(icon_Back_Cover);
    		buttonsArray[i].setText("button"+i);
    		buttonsArray[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
    				if(GameManagerNormal.click)handleEvent(e);      
                }
            });
    		}
    		
    		for(int i =0;i<buttonsNumber;i++)frame.add(buttonsArray[i]);
    }
    /**
     * Ανοίγει μια κάρτα (αλλάζει την εικόνα που χρησιμοποιείται από όλλες τις
     * κάρτες με αυτήν που αντιστοιχεί στη συγκεκριμένη κάρτα).
     * @param cardNumber ο αριθμός μιας συγκεκριμένης κάρτας.
     */
    protected void openCard(int cardNumber){
        buttonsArray[cardNumber].setIcon(iconsArray[GameManagerNormal.mainTable[cardNumber]]);
    }
    
    public void closeCard(int cardNumber){
        buttonsArray[cardNumber].setIcon(icon_Back_Cover);
    }
    
    /**
     * Αλλάζει το κείμενο στα Jlabels.
     */
    
    public void changeJLabelsTurn(int x){
    	labelsArray[1].setText("It is player"+x+"'s turn");
    }
    
    public void changeJLabels(int x, String s){
    	labelsArray[x].setText(s);
    }
    
    protected void st(Thread t1){
    	t1.start();
    }
    
    public void unClicableButtons(int x1){
    	buttonsArray[x1].removeActionListener(buttonsArray[x1].getActionListeners()[0]);
    }
    
    public void gameEnd(){
    	frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
    
    public void clicableButtons(int x){
    	buttonsArray[x].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				if(GameManagerNormal.click)handleEvent(e);      
            }
        });
    }

    public void clickButton(int x){
    	buttonsArray[x].doClick();
    }
    
}
