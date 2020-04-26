package com.memory_game.app.project;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Certain_queue extends GUI{
	public Certain_queue(int buttonsNumber, char varc, JFrame frame) {
		super(buttonsNumber, varc,frame);
		setGrid();
    	frame.setVisible(true);
    	frame.setResizable(false);
	}
	@Override
	protected void setIcons(int iconsNumber){
		System.out.println("The right one");
    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
    	iconsArray = new ImageIcon[iconsNumber];
    	switch(c){
    	case'n':case'1':case'2':case'4':case'8':{
           for(int i=0;i<iconsNumber/2;i++){
        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+1+".jpg"));
        	  iconsArray[i+(iconsNumber/2)] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+2+".jpg"));
           }
    	break;
    	}
    	case'9':{
    		for(int i=0;i<iconsNumber/4;i++){
    			System.out.println("!!!");
          	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+1+".jpg"));
          	  iconsArray[i+(iconsNumber/4)] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+2+".jpg"));
          	  iconsArray[i+((iconsNumber/4)*2)] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+3+".jpg"));
          	  iconsArray[i+((iconsNumber/4)*3)] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+4+".jpg"));
             }
    		break;
           }
    	case'a':{
    		for(int i=0;i<iconsNumber/3;i++){
          	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+1+".jpg"));
          	  iconsArray[i+(iconsNumber/3)] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+2+".jpg"));
          	  iconsArray[i+(iconsNumber/3)*2] = new ImageIcon(GUI.class.getResource("/img_certain_queue/"+i+"_"+3+".jpg"));
             }
    		break;
           }	
    	
    	}
	}
	@Override
	protected void setIcons_large(int iconsNumber){
		System.out.println("The right one");
    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
    	iconsArray = new ImageIcon[iconsNumber];
    	switch(c){
    	case'n':case'1':case'2':case'4':case'8':{
           for(int i=0;i<iconsNumber/2;i++){
        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+1+".jpg"));
        	  iconsArray[i+(iconsNumber/2)] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+2+".jpg"));
           }
    	break;
    	}
    	case'9':{
    		for(int i=0;i<iconsNumber/4;i++){
    			System.out.println("!!!");
          	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+1+".jpg"));
          	  iconsArray[i+(iconsNumber/4)] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+2+".jpg"));
          	  iconsArray[i+((iconsNumber/4)*2)] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+3+".jpg"));
          	  iconsArray[i+((iconsNumber/4)*3)] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+4+".jpg"));
             }
    		break;
           }
    	case'a':{
    		for(int i=0;i<iconsNumber/3;i++){
          	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+1+".jpg"));
          	  iconsArray[i+(iconsNumber/3)] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+2+".jpg"));
          	  iconsArray[i+(iconsNumber/3)*2] = new ImageIcon(GUI.class.getResource("/large_img_certain_queue/"+i+"_"+3+".jpg"));
             }
    		break;
           }	
    	
    	}
	}
	@Override
	protected void setIcons_medium(int iconsNumber){
		System.out.println("The right one");
    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
    	iconsArray = new ImageIcon[iconsNumber];
    	switch(c){
    	case'n':case'1':case'2':case'4':case'8':{
           for(int i=0;i<iconsNumber/2;i++){
        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+1+".jpg"));
        	  iconsArray[i+(iconsNumber/2)] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+2+".jpg"));
           }
    	break;
    	}
    	case'9':{
    		for(int i=0;i<iconsNumber/4;i++){
    			System.out.println("!!!");
          	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+1+".jpg"));
          	  iconsArray[i+(iconsNumber/4)] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+2+".jpg"));
          	  iconsArray[i+((iconsNumber/4)*2)] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+3+".jpg"));
          	  iconsArray[i+((iconsNumber/4)*3)] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+4+".jpg"));
             }
    		break;
           }
    	case'a':{
    		for(int i=0;i<iconsNumber/3;i++){
          	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+1+".jpg"));
          	  iconsArray[i+(iconsNumber/3)] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+2+".jpg"));
          	  iconsArray[i+(iconsNumber/3)*2] = new ImageIcon(GUI.class.getResource("/medium_img_certain_queue/"+i+"_"+3+".jpg"));
             }
    		break;
           }	
    	
    	}
	}
	@Override
	protected void setIcons_xsmall(int iconsNumber){
		System.out.println("The right one");
    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
    	iconsArray = new ImageIcon[iconsNumber];
    	switch(c){
    	case'n':case'1':case'2':case'4':case'8':{
           for(int i=0;i<iconsNumber/2;i++){
        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+1+".jpg"));
        	  iconsArray[i+(iconsNumber/2)] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+2+".jpg"));
           }
    	break;
    	}
    	case'9':{
    		for(int i=0;i<iconsNumber/4;i++){
    			System.out.println("!!!");
          	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+1+".jpg"));
          	  iconsArray[i+(iconsNumber/4)] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+2+".jpg"));
          	  iconsArray[i+((iconsNumber/4)*2)] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+3+".jpg"));
          	  iconsArray[i+((iconsNumber/4)*3)] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+4+".jpg"));
             }
    		break;
           }
    	case'a':{
    		for(int i=0;i<iconsNumber/3;i++){
          	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+1+".jpg"));
          	  iconsArray[i+(iconsNumber/3)] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+2+".jpg"));
          	  iconsArray[i+(iconsNumber/3)*2] = new ImageIcon(GUI.class.getResource("/xsmall_img_certain_queue/"+i+"_"+3+".jpg"));
             }
    		break;
           }	
    	
    	}
	}
	
	private void setGrid(){
        FlowLayout flowLayout = new FlowLayout();
        frame.setLayout(flowLayout);
    }
}
