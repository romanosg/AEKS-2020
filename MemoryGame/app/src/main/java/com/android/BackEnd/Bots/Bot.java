/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.android.BackEnd.Bots;

import java.util.Random;
import com.android.BackEnd.GameManagers.*;

/**
 * Είναι η master class που χειρίζεται τις κινήσεις του AI bot.
 *
 * @author Ιωάννα Σταϊνού 2466
 * @version Nov 2015
 */

public class Bot{
    Random r = new Random();
    int x, opened;
    public int[] x1;
	
    public Bot(){
    	opened=-1;
    	x1 = new int [GameManagerNormal.numberOfCards];
    }
}
