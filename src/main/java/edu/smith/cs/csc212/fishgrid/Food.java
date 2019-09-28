package edu.smith.cs.csc212.fishgrid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;


public class Food extends WorldObject {
	/**
	 * I took these colors from Wikipedia's shades of brown. 
	 * https://en.wikipedia.org/wiki/Shades_of_brown
	 */
	
	private static Color[] FOOD_COLORS = new Color[] {
			new Color(150,75,0),
			new Color(196,176,145),
			new Color(107,68,35),
			new Color(165,42,42),
	};
	
	int color;

	/**
	 * Constructor
	 */
	public Food (World world) {
		super(world);
		color = rand.nextInt(FOOD_COLORS.length);
	}
	
	
	/**
	 * Draw a rock
	 */
	@Override
	public void draw(Graphics2D g) {
		Shape food;
		
		g.setColor(FOOD_COLORS[color]); 
		food = new Ellipse2D.Double(-0.3, -0.3, 0.6, 0.6);
		g.fill(food);
	}
	
	@Override
	public void step() {
		
	}

}

