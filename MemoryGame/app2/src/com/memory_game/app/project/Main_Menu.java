package project;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import GameManagers.*;

public class Main_Menu {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JFrame frame;
	JButton solo,multiplayer,normal,trio,quarteto,queue,confirm,random,grid;
	JSlider cardNumber;
	
	public Main_Menu(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		soloMultiplayer();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	private void soloMultiplayer(){
		 solo = new JButton();
		 solo.setText("SOLO");
		 multiplayer = new JButton();
		 multiplayer.setText("MULTIPLAYER");
		solo.setBounds((screenSize.width-555)/2, screenSize.height/2-300, 500, 200);
		multiplayer.setBounds((screenSize.width-555)/2, screenSize.height/2-100, 500, 200);
		solo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			solo();
			}
		});
		frame.add(solo);
		frame.add(multiplayer);
	}
	private void solo(){
		frame.remove(solo);
		frame.remove(multiplayer);
		normal =new JButton();
		trio = new JButton();
		quarteto = new JButton();
		normal.setText("NORMAL");
		trio.setText("TRIO");
		quarteto.setText("QUARTETO");
		normal.setBounds((screenSize.width-520)/2, screenSize.height/2-350, 500, 200);
		trio.setBounds((screenSize.width-520)/2, screenSize.height/2-150, 500, 200);
		quarteto.setBounds((screenSize.width-520)/2, screenSize.height/2+50, 500, 200);
		normal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				solo_normal();				
			}
		});
		trio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				solo_trio();				
			}
		});
		frame.add(normal);
		frame.add(trio);
		frame.add(quarteto);
		frame.repaint();
	}

	private void solo_normal(){
		frame.remove(normal);
		frame.remove(trio);
		frame.remove(quarteto);
		normal=new JButton();
		queue= new JButton();
		normal.setText("NORMAL");
		queue.setText("QUEUE");
		normal.setBounds((screenSize.width-520)/2, screenSize.height/2-300, 500, 200);
		queue.setBounds((screenSize.width-520)/2, screenSize.height/2-100, 500, 200);
		normal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				normal();
			}
		});
		frame.add(normal);
		frame.add(queue);
		frame.repaint();
	}
	
	private void solo_trio(){
		frame.remove(normal);
		frame.remove(trio);
		frame.remove(quarteto);
		normal=new JButton();
		queue= new JButton();
		normal.setText("NORMAL");
		queue.setText("QUEUE");
		normal.setBounds((screenSize.width-520)/2, screenSize.height/2-300, 500, 200);
		queue.setBounds((screenSize.width-520)/2, screenSize.height/2-100, 500, 200);
		normal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				normal();
			}
		});
		frame.add(normal);
		frame.add(queue);
		frame.repaint();
	}
	
	private void normal(){
		frame.remove(queue);
		frame.remove(normal);
		grid=new JButton();
		random = new JButton();
		grid.setBounds((screenSize.width-520)/2, screenSize.height/2-300, 500, 200);
		random.setBounds((screenSize.width-520)/2, screenSize.height/2-100, 500, 200);
		grid.setText("GRID");
		random.setText("RANDOM");
		grid.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				s_grid();
			}
		});
		random.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				s_random();
			}
			
		});
		frame.add(grid);
		frame.add(random);
		frame.repaint();
	}
	
	private void s_grid(){
		frame.remove(grid);
		frame.remove(random);
		confirm = new JButton();
		confirm.setText("CONFIRM");
		confirm.setBounds((screenSize.width-520)/2, screenSize.height/2-300, 500, 200);
		cardNumber = new JSlider();
		cardNumber.setBounds((screenSize.width-520)/2, screenSize.height/2-10, 500, 200);
		cardNumber.setMaximum(48);
		cardNumber.setMinimum(8);
		cardNumber.setMajorTickSpacing(2);
		cardNumber.setPaintTicks(true);
		cardNumber.setPaintLabels(true);
		cardNumber.setSnapToTicks(true);
		confirm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(cardNumber);
				frame.remove(confirm);
				Grid mainFrame = new Grid(cardNumber.getValue(),'n',frame);
				GameManagerNormal.InitGameManager(mainFrame,1,0,cardNumber.getValue(),'h','h');
				frame.repaint();	
			}
		});
		frame.add(confirm);
		frame.add(cardNumber);
		frame.repaint();
	}
	
	private void s_random(){
		frame.remove(grid);
		frame.remove(random);
		confirm = new JButton();
		confirm.setText("CONFIRM");
		confirm.setBounds((screenSize.width-520)/2, screenSize.height/2-300, 500, 200);
		cardNumber = new JSlider();
		cardNumber.setBounds((screenSize.width-520)/2, screenSize.height/2-10, 500, 200);
		cardNumber.setMaximum(22);
		cardNumber.setMinimum(8);
		cardNumber.setMajorTickSpacing(2);
		cardNumber.setPaintTicks(true);
		cardNumber.setPaintLabels(true);
		cardNumber.setSnapToTicks(true);
		confirm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(cardNumber);
				frame.remove(confirm);
				Random mainFrame = new Random(cardNumber.getValue(),'n',frame);
				GameManagerNormal.InitGameManager(mainFrame,1,0,cardNumber.getValue(),'h','h');
				frame.repaint();	
			}
		});
		frame.add(confirm);
		frame.add(cardNumber);
		frame.repaint();
	}
	
}
