package T0X1CCR34T0R.zombio.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;

public class gameManager extends Thread{
	
	public boolean running;
	public int fps = 60;
	public Display display;
	private BufferStrategy bufferStrategy;
	
	public gameManager(Display display) {
		running = true;
		fps = 60;
		this.display = display;
	}
	
	public void update() { 		//all you want to update goes in here
//		System.out.println("updating");
//		System.out.println(display.getWidth());
	}
	
	public void render() { 		//all the rendering or drawing goes in here
//		System.out.println("rendering");
		initGraphics();
		Graphics graphics = bufferStrategy.getDrawGraphics();
		//all the  drawing goes in here
		
		graphics.setColor(Color.GREEN); 		//set Color of drawings
//		graphics.drawLine(0, 0, 640, 480); 					//	!!!draw a LINE!!!
//		graphics.drawRect(295, 215, 50, 50); 				//	!!!draw a RECTANGLE!!!
//		graphics.drawOval(200, 150, 200, 200);				//	!!!draw a CIRCLE!!!
		graphics.drawString(fps + "fps", 0, 10);			//	!!!draw TEXT!!!
		
		//end of drawing code
		bufferStrategy.show();
		graphics.dispose();
		
	}
	
	public void initGraphics() {
		Canvas canvas = display.getCanvas();
		bufferStrategy = canvas.getBufferStrategy();
		
		if(bufferStrategy != null)
			return;
		
		canvas.createBufferStrategy(3);
		bufferStrategy = canvas.getBufferStrategy();
		
	}

	
	@Override
	public void run() {
		int counter = 0;
		float timePerUpdate= 1000000000/fps;
		long currentTime = 0 , prevTime = System.nanoTime();
		
		long now , lastTime;
		lastTime = System.nanoTime();
		
		while(running) {
			
			currentTime = System.nanoTime();
			if(currentTime - prevTime >= timePerUpdate) {
				update();
				render();
				prevTime = currentTime;
				counter++;
			}
						
			//FPS Counter code
			now = System.nanoTime();
			
			if ((now -lastTime) >= 1000000000) {
				System.out.println(counter + " fps");
				counter = 0;
				lastTime = now;
			}
		}
	}
	
	public Display getDisplay() {
		return display;
	}
}
