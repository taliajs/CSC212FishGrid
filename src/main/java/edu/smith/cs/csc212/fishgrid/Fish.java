package edu.smith.cs.csc212.fishgrid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Most Fish behavior lives up in WorldObject (a Fish just looks special!).
 * Or it is in Main, where the missing/found and player fish all act different!
 * 
 * @author jfoley
 */
public class Fish extends WorldObject {
	/**
	 * A fish is only special because of its color now!
	 */
	
	boolean isScared = rand.nextBoolean();
	
	static Color[] COLORS = {
			Color.red,
			Color.green,
			Color.yellow,
			//(lab) Add more colors.
			Color.pink,
			Color.blue,
			Color.orange, 
			Color.cyan,
			Color.magenta
			
			// (FishGrid) Maybe make a special fish that is more points?
			// code is in FishGame.java
	}; 
	
	boolean isLittle;
	public void isScared () {
		this.isLittle = true;
	}
	
	/**
	 * This is an index into the {@link #COLORS} array.
	 */
	int color;
	/**
	 * Whether or not this is the player;
	 */
	boolean player = false;
	
	/**
	 * Called only on the Fish that is the player!
	 */
	public void markAsPlayer() {
		this.player = true;
		this.isScared = false;
	}


	/**
	 * A Fish knows what World it belongs to, because all WorldObjects do.
	 * @param color Color by number.
	 * @param world The world itself.
	 */
	public Fish(int color, World world) {
		super(world);
		this.color = color;
	}
	
	/**
	 * What actual color is this fish? We store an index, so get it here.
	 * @return the Color object from our array.
	 */
	public Color getColor() {
		return COLORS[this.color];
	}
	
	/**
	 * Animate our fish by facing left and then right over time.
	 */
	private int dt = 0;
	
	/**
	 * Go ahead and ignore this method if you're not into graphics.
	 * We use "dt" as a trick to make the fish change directions every second or so; this makes them feel a little more alive.
	 */
	@Override
	public void draw(Graphics2D g) {
		dt += 1;
		if (dt > 100) {
			dt = 0;
		}
		Shape circle;
		Shape body;
		Shape tail;
		Shape eye;
		
		if (isScared) { //scaled it down by half 
			circle = new Ellipse2D.Double(-0.6/2, -0.6/2, 1.2/2, 1.2/2);
			body = new Ellipse2D.Double(-.40/2, -.2/2, .8/2, .4/2);
			tail = new Ellipse2D.Double(+.2/2, -.3/2, .2/2, .6/2);
			eye = new Ellipse2D.Double(-.25/2, -.1/2, .1/2, .1/2);
		} else {
			circle = new Ellipse2D.Double(-0.6, -0.6, 1.2, 1.2);
			body = new Ellipse2D.Double(-.40, -.2, .8, .4);
			tail = new Ellipse2D.Double(+.2, -.3, .2, .6);
			eye = new Ellipse2D.Double(-.25, -.1, .1, .1);
		}
		
		Color color = getColor();
		Color tailColor = color.darker();

		
		Graphics2D flipped = (Graphics2D) g.create();
		if (dt < 50) {
			flipped.scale(-1, 1);
		}
		
		
		
		if (this.player) {
			flipped.setColor(new Color(1f,1f,1f,0.5f));
			flipped.fill(circle);
		}

		// Draw the fish of size (1x1, roughly, at 0,0).
		flipped.setColor(color);
		flipped.fill(body);

		flipped.setColor(Color.black);
		flipped.fill(eye);

		// draw tail:
		flipped.setColor(tailColor);
		flipped.fill(tail);
		
		flipped.dispose();
	
	
	}
	
	
	
	@Override
	public void step() {
		// Fish are controlled at a higher level; see FishGame.
	}
}
