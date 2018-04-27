/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author polla
 */
public class BackPanel extends JPanel{
    private Bord bord;
    private Shape shape;
    public BackPanel(Bord bord, Shape shape){
	this.bord = bord;
	this.shape = shape;
	shape.nextShape();
    }
    public void paintComponent(Graphics g){
	super.paintComponent(g);
	setSize(500,700);
	setLocation(0, 0);
	repaint();
    }
    
    public void paint(Graphics screen){
	Graphics2D screen2D = (Graphics2D) screen;
	
	bord.paintBackgraound(screen2D,500, 700);
	bord.paintBlocks(screen2D);
	shape.paintShape(screen2D);
	screen2D.setColor(Color.BLACK);
	
    }
}
