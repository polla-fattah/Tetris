/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author polla
 */
public class Bord {
    public static final int BLOCK_SIZE = 20;
    public static final int X_BLOCK_NO = 23;
    public static final int Y_BLOCK_NO = 30;
    
    public static final int FIRAT_X = 20;
    public static final int LAST_X = FIRAT_X + X_BLOCK_NO * BLOCK_SIZE;
    
    public static final int FIRST_Y = 50;   
    public static final int LAST_Y = FIRST_Y + Y_BLOCK_NO * BLOCK_SIZE;
    
    ArrayList<ArrayList<Color>> matrixBord;
    int r;
    public Bord(){
	matrixBord = new ArrayList<>();
	for (int i = 0; i < Y_BLOCK_NO; i++){
	    matrixBord.add(new ArrayList<>(Collections.nCopies(X_BLOCK_NO, null)));
	}
    }
    
    public void paintBackgraound(Graphics2D screen2D, int w, int h){
	screen2D.setColor(Color.LIGHT_GRAY);
	screen2D.fillRect(0, 0, w, h);
	screen2D.setColor(Color.GRAY);

	for (int i = 0; i <= X_BLOCK_NO; i++){
	    int x = FIRAT_X +  BLOCK_SIZE * i;
	    screen2D.drawLine(x, FIRST_Y, x, LAST_Y);
	}
	for (int i = 0; i <= Y_BLOCK_NO; i++){
	    int y = FIRST_Y + BLOCK_SIZE * i;
	    screen2D.drawLine(FIRAT_X, y, LAST_X, y);
	}
    }
    public void paintBlocks(Graphics2D screen2D){
	for(int x = 0; x < X_BLOCK_NO; x++){
	    for(int y = 0; y < Y_BLOCK_NO; y++){
		Color val = matrixBord.get(y).get(x);
		if(val != null){
		   int i = FIRAT_X + BLOCK_SIZE * x + 1;
		   int j = FIRST_Y + BLOCK_SIZE * y + 1;
		   screen2D.setColor(val);
		    screen2D.fillRect(i, j, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
		}
	    }
	}
    }
}
