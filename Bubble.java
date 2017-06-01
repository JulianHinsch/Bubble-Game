package bubblegame;
import processing.core.*;
import java.util.*;

/** 
 * Bubble Class
 * 
 * This class represents a bubble object which will be hidden as
 * the user moves his/her mouse within its area.
 * 
 * @author Julian Hinsch
 * @version 5/20/17
 */
public class Bubble{
	//diameter
	private int diameter; 	
	//xposition
	private int x;	
	//yposition
	private int y;	
	//pixels per frame
	private int speed;	
	//parent
	PApplet parent;		

	/**
	 * Default Constructor
	 * 
	 * Constructs a bubble object.
	 */
	Bubble () {}	
	
//all-args constructor
	
	/**
	 * All-Args Constructor
	 * 
	 * @param parent, the Processing class from which bubble inherits methods
	 * @param diameter, the diameter of this bubble
	 * @param x, the x position of the center of this bubble
	 * @param y, the y position of the center of this bubble
	 * @param speed, the number of pixels this bubble will travel per frame.
	 */
	Bubble (PApplet parent, int diameter, int x, int y, int speed) {
		this.parent = parent;
		this.diameter = diameter;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
//getters & setters
	
	/**
	 * Get Diameter Method
	 * 
	 * Returns the diameter of this bubble.
	 * 
	 * @return the diameter of this bubble.
	 */
	public float getDiameter() {
		return diameter;
	}
	
	/**
	 * Get X-Coordinate Method
	 * 
	 * Returns the x-coordinate of the center of this bubble.
	 * 
	 * @return the x-coordinate of the center of this bubble.
	 */
	public float getX() {
		return x;
	}
	
	
	/**
	 * Get Y-Coordinate Method
	 * 
	 * Returns the y-coordinate of the center of this bubble.
	 * 
	 * @return the y-coordinate of the center of this bubble.
	 */
	public float getY() {
		return y;
	}
	


	/**
	 * Display Method
	 * 
	 * Displays this bubble.
	 */
	public void display() {
		//white outline
		parent.stroke(255,255,255); 
		parent.strokeWeight(2);
		//transparent white inside
		parent.fill(255,255,255,100);  	
		//draw ellipse
		parent.ellipse (x,y,diameter,diameter);
	}
	
	/**
	 * Up Method
	 * 
	 * Moves this bubble up the number of pixels specified by its speed.
	 * This method is called once every frame.
	 */
	public void up() {
		this.y-=speed;
	}
	
	
}