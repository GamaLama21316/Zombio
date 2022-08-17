package display;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;

public class Display extends JFrame{
	public String title;
	public Canvas canvas;
	
	public Display(String title, int width, int height, Color bgColor) {
		this.title = title;
		initialize(width, height, bgColor);
		
	}
	
	public void initialize(int width, int height, Color bg) {
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		canvas =  new Canvas();
		canvas.setSize(width, height);
		canvas.setBackground(bg);
		add(canvas);
		setResizable(false);
		
	}	
	
	public void display() {
		setVisible(true);
	}	
	
	public Canvas getCanvas() {
		return canvas;
	}
	
 }
