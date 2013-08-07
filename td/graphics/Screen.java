/* 
 * File Name: Tile.java
 * Contributors:	Jonathan Bradley 	- 7/18/2013
 * 					Ryan Meier			- 
 * 					Ben Emrick			-
 * 
 * Purpose: This will handle what we see inside the frame.. WIP
 */
package td.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import td.Game;

public class Screen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6468166128684414161L;
	
	// set up needed variables 
	private Game game;
	
	// Constructor
	public Screen(Game gme) {
		game = gme;
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		//setPreferredSize(new Dimension(game.map.getWidth(), game.map.getHeight()));
	}
	
	// used by the paintComponent I think?
	public void addNotify() {
		super.addNotify();
	}
	
	// called by repaint(); - the way this is set up, this class is similar to a graphics handler
	// 		other objects are responsible for creating their image, but screen.java actually renders it
	//	still needs generated images of the Towers, Bullets, and Mobs
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		if (game.inGame == true) {
			g2d.drawImage(game.map.getMapImage(), null, 0, 0); // render the background map
		}
		
		Toolkit.getDefaultToolkit().sync();
	    g2d.dispose();
	    
	}
	
	// called by the main game loop
	public void render() {
		repaint();
	}

}
