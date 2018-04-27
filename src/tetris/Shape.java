/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 *
 * @author polla
 */
public class Shape {
    public static final int SHAPE_SIZE = 3;
    private ArrayList<ArrayList<Color>> shapeMatrix;
    private int xShape, xLoc;
    private int yShape, yLoc;
    public Shape(){
	shapeMatrix = new ArrayList<>();
	for(int i = 0; i < SHAPE_SIZE; i++)
	    shapeMatrix.add(new ArrayList<>(Collections.nCopies(SHAPE_SIZE, null)));
    }
    
    public void nextShape(){
	yLoc = 0;
	xLoc = (Bord.X_BLOCK_NO - 2) / 2;

	yShape = Bord.FIRST_Y;
	xShape = Bord.FIRAT_X + Bord.BLOCK_SIZE * xLoc;
	int shapeNo = 8;
	
	Random rand = new Random();

	int  randShape = rand.nextInt(shapeNo);
	switch(randShape){
	    case 0:
		shapeMatrix.get(0).set(0, null);
		shapeMatrix.get(0).set(1, Color.pink);
		shapeMatrix.get(0).set(2, null);
		
		shapeMatrix.get(1).set(0, null);
		shapeMatrix.get(1).set(1, Color.pink);
		shapeMatrix.get(1).set(2, null);
		
		shapeMatrix.get(2).set(0, null);
		shapeMatrix.get(2).set(1, Color.pink);
		shapeMatrix.get(2).set(2, null);
		break;
	    case 1:
		System.out.println(shapeMatrix);
		shapeMatrix.get(0).set(0, Color.green);
		shapeMatrix.get(0).set(1, Color.green);
		shapeMatrix.get(0).set(2, Color.green);
		
		shapeMatrix.get(1).set(0, null);
		shapeMatrix.get(1).set(1, Color.green);
		shapeMatrix.get(1).set(2, null);
		
		shapeMatrix.get(2).set(0, null);
		shapeMatrix.get(2).set(1, null);
		shapeMatrix.get(2).set(2, null);
		break;
	    case 2:
		shapeMatrix.get(0).set(0, Color.red);
		shapeMatrix.get(0).set(1, Color.red);
		shapeMatrix.get(0).set(2, Color.red);
		
		shapeMatrix.get(1).set(0, Color.red);
		shapeMatrix.get(1).set(1, null);
		shapeMatrix.get(1).set(2, null);
		
		shapeMatrix.get(2).set(0, Color.red);
		shapeMatrix.get(2).set(1, null);
		shapeMatrix.get(2).set(2, null);
		break;
	    case 3:
		shapeMatrix.get(0).set(0, null);
		shapeMatrix.get(0).set(1, null);
		shapeMatrix.get(0).set(2, null);
		
		shapeMatrix.get(1).set(0, null);
		shapeMatrix.get(1).set(1, Color.red);
		shapeMatrix.get(1).set(2, null);
		
		shapeMatrix.get(2).set(0, null);
		shapeMatrix.get(2).set(1, null);
		shapeMatrix.get(2).set(2, null);
		break;
	    case 4:
		shapeMatrix.get(0).set(0, null);
		shapeMatrix.get(0).set(1, Color.red);
		shapeMatrix.get(0).set(2, null);
		
		shapeMatrix.get(1).set(0, null);
		shapeMatrix.get(1).set(1, Color.red);
		shapeMatrix.get(1).set(2, null);
		
		shapeMatrix.get(2).set(0, null);
		shapeMatrix.get(2).set(1, null);
		shapeMatrix.get(2).set(2, null);
		break;
	    case 5:
		shapeMatrix.get(0).set(0, Color.red);
		shapeMatrix.get(0).set(1, null);
		shapeMatrix.get(0).set(2, null);
		
		shapeMatrix.get(1).set(0, Color.red);
		shapeMatrix.get(1).set(1, Color.red);
		shapeMatrix.get(1).set(2, Color.red);
		
		shapeMatrix.get(2).set(0, null);
		shapeMatrix.get(2).set(1, null);
		shapeMatrix.get(2).set(2, Color.red);
		break;
	    case 6:
		shapeMatrix.get(0).set(0, null);
		shapeMatrix.get(0).set(1, null);
		shapeMatrix.get(0).set(2, Color.red);
		
		shapeMatrix.get(1).set(0, Color.red);
		shapeMatrix.get(1).set(1, Color.red);
		shapeMatrix.get(1).set(2, Color.red);
		
		shapeMatrix.get(2).set(0, Color.red);
		shapeMatrix.get(2).set(1, null);
		shapeMatrix.get(2).set(2, null);
		break;
	    case 7:
		shapeMatrix.get(0).set(0, null);
		shapeMatrix.get(0).set(1, Color.red);
		shapeMatrix.get(0).set(2, Color.red);
		
		shapeMatrix.get(1).set(0, null);
		shapeMatrix.get(1).set(1, Color.red);
		shapeMatrix.get(1).set(2, null);
		
		shapeMatrix.get(2).set(0, null);
		shapeMatrix.get(2).set(1, null);
		shapeMatrix.get(2).set(2, null);
		break;
	    case 8:
		shapeMatrix.get(0).set(0, Color.red);
		shapeMatrix.get(0).set(1, Color.red);
		shapeMatrix.get(0).set(2, Color.red);
		
		shapeMatrix.get(1).set(0, Color.red);
		shapeMatrix.get(1).set(1, Color.red);
		shapeMatrix.get(1).set(2, Color.red);
		
		shapeMatrix.get(2).set(0, Color.red);
		shapeMatrix.get(2).set(1, Color.red);
		shapeMatrix.get(2).set(2, Color.red);
		break;
	}
	
    }
    public void proceed(){

	if(Bord.Y_BLOCK_NO - SHAPE_SIZE == yLoc ){
	    nextShape();
	}
 	yShape += Bord.BLOCK_SIZE;
	yLoc++;
    }
    public void paintShape(Graphics screen2D){
	for(int x = 0; x < SHAPE_SIZE; x++){
	    for(int y = 0; y < SHAPE_SIZE; y++){
		Color val = shapeMatrix.get(y).get(x);
		if(val != null){
		   int i = xShape + Bord.BLOCK_SIZE * x + 1;
		   int j = yShape + Bord.BLOCK_SIZE * y + 1;
		   screen2D.setColor(val);
		    screen2D.fillRect(i, j, Bord.BLOCK_SIZE - 1, Bord.BLOCK_SIZE - 1);
		}
	    }
	}
    }
    public ArrayList<ArrayList<Color>> getShape(){
	return shapeMatrix;
    }

    void moveLeft() {
	if(xShape < Bord.FIRAT_X)
	    return;
	if(! edgeIsNull(0) && xShape < Bord.FIRAT_X + Bord.BLOCK_SIZE)
	    return;
	xShape -=  Bord.BLOCK_SIZE;
	xLoc--;
    }

    void moveRight() {
	if(xShape > Bord.LAST_X - Bord.BLOCK_SIZE * 3)
	    return;
	if(! edgeIsNull(2) && xShape > Bord.LAST_X - Bord.BLOCK_SIZE * 4)
	    return;
	
	xShape +=  Bord.BLOCK_SIZE;
	xLoc++;
    }

    void rotate() {
	// Consider all squares one by one
        for (int x = 0; x < SHAPE_SIZE / 2; x++){
            // Consider elements in group of 4 in 
            // current square
            for (int y = x; y < SHAPE_SIZE-x-1; y++){
                // store current cell in temp variable
                Color temp = shapeMatrix.get(x).get(y);
      
                // move values from right to top
                shapeMatrix.get(x).set(y, 
			shapeMatrix.get(y).get(SHAPE_SIZE-1-x));
      
                // move values from bottom to right
                shapeMatrix.get(y).set(SHAPE_SIZE-1-x, 
			shapeMatrix.get(SHAPE_SIZE-1-x).get(SHAPE_SIZE-1-y)) ;
      
                // move values from left to bottom
                shapeMatrix.get(SHAPE_SIZE-1-x).set(SHAPE_SIZE-1-y, 
			shapeMatrix.get(SHAPE_SIZE-1-y).get(x));
      
                // assign temp to left
                shapeMatrix.get(SHAPE_SIZE-1-y).set(x, temp);
            }
        }
	
	if(! edgeIsNull(0) && xShape < Bord.FIRAT_X ){
	    xShape +=  Bord.BLOCK_SIZE;
	    xLoc++;
	}
	if(! edgeIsNull(2) && xShape > Bord.LAST_X - Bord.BLOCK_SIZE * 3){
	    xShape -=  Bord.BLOCK_SIZE;
	    xLoc--;
	}

	

	
    }

    private boolean edgeIsNull(int x) {
	return shapeMatrix.get(0).get(x) == null &&
		shapeMatrix.get(1).get(x) == null &&
		shapeMatrix.get(2).get(x) == null ;
    }
    
}
