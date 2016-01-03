package conjugation;

/** Part of the program that displays the GUI interface that the user
 * interacts with. Contains all the front end stuff.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import javax.swing.JFrame;

public class JapanDisplay {
	
	public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");

		JFrame frame = new JFrame("Japanese Text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JapanPanel panel = (JapanPanel) context.getBean("japanPanel");
		frame.getContentPane().add(panel);

        // set the gui to be visible.
		frame.pack();
		frame.setVisible(true);
	}
}
