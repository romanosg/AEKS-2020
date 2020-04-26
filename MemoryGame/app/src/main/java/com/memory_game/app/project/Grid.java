/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory_game.app.project;

import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * Αυτή η κλάση βάζει τις κάρτες σε πλέγμα.
 *
 * @author Ιωάννα Σταϊνού 2466
 * @version Nov 2015
 */
public class Grid extends GUI {
    FlowLayout flowLayout;
    /**
     * Καλεί τον κονστράκτορα της υπερκλάσης και μετά καλεί τη μέθοδο setGrid
     * η οποία βάζει τις κάρτες σε πλέγμα.
     */
    public Grid (int buttonsNumber,char c, JFrame frame){
    	super(buttonsNumber,c,frame);
    	setGrid();
    	frame.setVisible(true);
    	frame.setResizable(false);
        
    }
    /**
     * Βάζει τις κάρτες σε πλέγμα.
     */
    private void setGrid(){
        flowLayout = new FlowLayout();
        frame.setLayout(flowLayout);
    }
    
            
}
