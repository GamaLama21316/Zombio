
package T0X1CCR34T0R.zombio.game.main;

import java.awt.Color;

import display.Display;

//
//
//

public class zombioGame {
	
	public static void main(String[] args) {
		
		String title = "Zombio";
		int width = 640;
		int height = 480;
		Display display = new Display(title, width, height, new Color(0, 0, 0));
		
		display.display();
		
		gameManager manager = new gameManager(display);
		manager.start();
		
		// ALWAYS KEEP THIS AT THE END!!!
		System.out.println("If this message pops up, the shit above actually works!!!");
		// ALWAYS KEEP THIS AT THE END!!!
	}
}