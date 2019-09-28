package edu.smith.cs.csc212.fishgrid;

import java.awt.Graphics2D;

/**
 * Construct a Falling Rock in our world.
 * @param world - the grid world.
 */

public class FallingRock extends Rock {
	public FallingRock (World world) { 
		super(world);
		}
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
	@Override
	public void step() {
		this.moveDown();
	}
}
