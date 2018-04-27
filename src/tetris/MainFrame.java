/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

class MainFrame extends JFrame{
    private Bord bord;
    private Shape shape;
    public MainFrame(){
	setTitle("Tetris");
	setResizable(false);
	setSize(500,700);
	setLocation(400, 20);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	bord = new Bord();
	shape = new Shape();
	Container contentPane=getContentPane();//get content pane
	BackPanel backPanel = new BackPanel(bord, shape);
	contentPane.add(backPanel); //on the fly
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new TimerTask() {
	  @Override
	  public void run() {
	    backPanel.repaint();
	    shape.proceed();
	  }
	}, 1000, 500);
	
	addKeyListener(new KeyListener(){

	    @Override
	    public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		    case KeyEvent.VK_LEFT:
			shape.moveLeft();
			backPanel.repaint();
			break;
		    case KeyEvent.VK_RIGHT:
			shape.moveRight();
			backPanel.repaint();
			break;
		    case KeyEvent.VK_UP:
			shape.rotate();
			backPanel.repaint();
			break;
		    case KeyEvent.VK_DOWN:
			shape.proceed();
			backPanel.repaint();
			break;
		}
	    }
	    
	    @Override  public void keyTyped(KeyEvent e){}

	    @Override public void keyReleased(KeyEvent e){}
	});

	
	
	
    }
}
