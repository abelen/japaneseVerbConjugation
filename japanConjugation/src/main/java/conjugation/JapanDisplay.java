package conjugation;

/** Part of the program that displays the GUI interface that the user
 * interacts with. Contains all the front end stuff.
 */

import java.io.IOException;
import javax.swing.JFrame;

public class JapanDisplay {
	
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Japanese Text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JapanPanel panel = new JapanPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}
