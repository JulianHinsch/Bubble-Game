package bubblegame;
import processing.core.*;
import java.util.*;

/** 
 * Bubble App Class
 * 
 * This class contains the setup() and draw() methods for the bubble application
 * as well as a method to test whether the user's cursor is within any
 * bubble objects.
 * 
 * @author Julian Hinsch
 * @version 5/20/17
 */
public class BubbleApp extends PApplet {
	//ArrayList of bubble objects
	ArrayList<Bubble> bubbles = new ArrayList<Bubble>(); 
	//number of frames drawn
	int framecount = 0;  
	//number of bubbles popped by user, displayed on screen
	int popcount = 0;  
	//font
	PFont f; 

	/**
	 * Setup Method
	 */
	public void setup() {
		//screen size
		  size(720, 480);
		//background color
		  background(139,189,255);
		  //frame rate
		  frameRate(50);
		  //text font
		  f = createFont("Arial",48,true);
		  //no stroke
		  strokeWeight(0);
	}
	
	/**
	 * Draw Method (Loop)
	 */
	public void draw() {
		framecount+=1;
		if (framecount%10==0) {
			int x = (int) random(0,width); 	//random x position
			int y = 900; //bubbles start below the screen
			int diameter = (int) random(10,150);	//random diameter
			int speed = (int) random(1,3); //random speed
			
			//create circle object
			Bubble temp = new Bubble(this,diameter,x,y,speed);
			//add to ArrayList
			bubbles.add(temp);
		}
		setup(); //clears the screen each time a frame is displayed
		for (int i = 0; i < bubbles.size(); i++) {				
				bubbles.get(i).display();	//display each bubble
				bubbles.get(i).up();  //move each bubble up
		}
		/*this loop deletes bubbles that have fallen off the screen to prevent the 
		application from using too much memory and slowing down over time */
		for (int i = 0; i < bubbles.size(); i++) {
			if (bubbles.get(i).getY()<-200) {
				bubbles.remove(i);
			}
		}
		// this loop deletes bubbles that the mouse clicks on 
		for (int i = 0; i < bubbles.size(); i++) {
			if (mouseWithin(bubbles.get(i))) {
				bubbles.remove(i);
				popcount++; //number on screen goes up 1
			}
		}
		//this displays the number of bubbles that have been popped
		textFont(f,48);
		fill(0);
		textAlign(CENTER);
		text(popcount,width/2,60);
	}
	
	/**
	 * Mouse Within Method
	 * 
	 * Tests if the cursor is within the area of a bubble by finding
	 * the euclidean distance between the center and the cursor's position.
	 * 
	 * @param b, any bubble object.
	 * @return true if the mouse is within the bubble's area, false otherwise.
	 */
	public boolean mouseWithin(Bubble b) {
		//radius of bubble
		double r = 0.5*b.getDiameter(); 
		//x position of bubble center
		double bubblexpos = b.getX();
		//y position of bubble center
		double bubbleypos = b.getY(); 
		//find euclidean distance between mouse position and bubble center (x^2 + y^2).
		float xdif = abs((float) mouseX - (float) bubblexpos); 
		float xsquared = xdif*xdif;
		float ydif = abs((float) mouseY - (float) bubbleypos);
		float ysquared = ydif*ydif;
		float eucl = xsquared + ysquared;  //euclidean distance
		//test if euclidean distance is less than radius squared
		double rsquared = r*r;
		if (eucl <= rsquared) {
			return true;	
		}
		return false;
	}
}