package project;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameManagers.GameManagerMod8;
import GameManagers.GameManagerNormal;

public class Battle extends GUI{
	JButton[] buttonsArray2;
	public JPanel panel_p1;
	public JPanel panel_p2;
	int playerCount=2,count=1;

	public Battle(int buttonsNumber, char c, JFrame frame) {
		super(buttonsNumber, c,frame);
		set();
		// TODO Auto-generated constructor stub
	}

	private void set(){
		
		frame.setVisible(true);
		
		
		
	}
	
	 protected void buttons(int buttonsNumber){
		 panel_p1= new JPanel();
		 panel_p2= new JPanel();
		 panel_p2.setBorder(border);
		 panel_p1.setBorder(border);
		 panel_p1.setPreferredSize(new Dimension((screenSize.width-20)/2, screenSize.height-300));
		 panel_p2.setPreferredSize(new Dimension((screenSize.width-20)/2, screenSize.height-300));
		 int x,l=0;
	    	if(buttonsNumber/2>4)x=4;
	    	else x= buttonsNumber/2;
	    	if(buttonsNumber%x!=0)l=1;
	    	buttonsArray = new JButton[buttonsNumber*2];
	    	buttonsArray2 = new JButton[buttonsNumber];
	    	for(int i =0;i<buttonsNumber*2;i++){
	    		buttonsArray[i] = new JButton();
	    		buttonsArray[i].setPreferredSize(new Dimension((screenSize.width-80)/(2*x),(screenSize.height-380)/((buttonsNumber/x)+l)));
	    		buttonsArray[i].setIcon(icon_Back_Cover);
	    		buttonsArray[i].setText("button"+i);
	    		buttonsArray[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	if(GameManagerNormal.click){
	                		String s = e.getActionCommand();
	                		s=s.substring(s.length()-2);
	                    	if(s.charAt(0)=='n')s=s.substring(1);
	                    	System.out.println(""+panel_p2.isEnabled());
	                	if(Integer.parseInt(s)>=GameManagerNormal.numberOfCards && panel_p2.isEnabled())handleEvent(e);
	                	else if(Integer.parseInt(s)<GameManagerNormal.numberOfCards && panel_p1.isEnabled())handleEvent(e);
	                	}
	                }
	            });
	    		}
	    	JLabel label_p1 = new JLabel();
	    	label_p1.setPreferredSize(new Dimension(550,30));
	    	label_p1.setBorder(border);
	    	label_p1.setText("Player1");
	    	panel_p1.add(label_p1);
	    	JLabel label_p2 = new JLabel();
	    	label_p2.setPreferredSize(new Dimension(550,30));
	    	label_p2.setBorder(border);
	    	label_p2.setText("Player2");
	    	panel_p2.add(label_p2);
	    		
	    		for(int i =0;i<buttonsNumber;i++){
	    			panel_p1.add(buttonsArray[i]);
	    			panel_p2.add(buttonsArray[i+buttonsNumber]);
	    		}
	    		panel_p1.setLayout(new FlowLayout());
	    		panel_p2.setLayout(new FlowLayout());
	    		frame.setLayout(new FlowLayout());
	    		frame.add(panel_p1);
	    		frame.add(panel_p2);
	    }
	 protected void openCard(int cardNumber){
		 int x;
		 if(GameManagerMod8.mainTable[cardNumber]>=GameManagerMod8.numberOfCards)
			 x=GameManagerNormal.mainTable[cardNumber]-GameManagerMod8.numberOfCards;
		 else x=GameManagerNormal.mainTable[cardNumber];
	        buttonsArray[cardNumber].setIcon(iconsArray[x]);
	    }
	 
	 protected void setIcons(int iconsNumber){
	    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
	    	System.out.println(icon_Back_Cover.getImage().toString());
	    	iconsArray = new ImageIcon[iconsNumber];
	           for(int i=0;i<iconsNumber;i++){
	        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/img/"+i+".jpg"));
	           }
	           }
	 
	 protected void setIcons_medium(int iconsNumber){
		 icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
	    	System.out.println(icon_Back_Cover.getImage().toString());
	    	iconsArray = new ImageIcon[iconsNumber];
	           for(int i=0;i<iconsNumber;i++){
	        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/medium_img/"+i+".jpg"));
	           }
	           }
	    protected void setIcons_large(int iconsNumber){
	    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
	    	System.out.println(icon_Back_Cover.getImage().toString());
	    	iconsArray = new ImageIcon[iconsNumber];
	           for(int i=0;i<iconsNumber;i++){
	        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/large_img/"+i+".jpg"));
	           }
	           }
	    protected void setIcons_xsmall(int iconsNumber){
	    	icon_Back_Cover = new ImageIcon(GUI.class.getResource("/img/Back_Cover.jpg"));
	    	System.out.println(icon_Back_Cover.getImage().toString());
	    	iconsArray = new ImageIcon[iconsNumber];
	           for(int i=0;i<iconsNumber;i++){
	        	   System.out.println("!!!!!"+i+""+iconsNumber);
	        	  iconsArray[i] = new ImageIcon(GUI.class.getResource("/xsmall_img/"+i+".jpg"));
	           }
	           }
	 
	 
	 
	 public void clicableButtons(int x){
	    	buttonsArray[x].addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
                	if(GameManagerNormal.click){
                		String s = e.getActionCommand();
                		s=s.substring(s.length()-2);
                    	if(s.charAt(0)=='n')s=s.substring(1);
                    	System.out.println(""+panel_p2.isEnabled());
                	if(Integer.parseInt(s)>=GameManagerNormal.numberOfCards && panel_p2.isEnabled())handleEvent(e);
                	else if(Integer.parseInt(s)<GameManagerNormal.numberOfCards && panel_p1.isEnabled())handleEvent(e);
                	}
                }
	        });
	    }
	 
}
