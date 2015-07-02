package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JapanDisplay {
	
	public static void main(String[] args) throws IOException {
		
		JFrame frame = new JFrame("Japanese Text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Image backgroundImage = ImageIO.read(new File("/Users/anthonybelen/Documents/japan_background.jpg"));
		
		
		JapanPanel panel = new JapanPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/*public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(backgroundImage, 0, 0, null);
	}*/

}
