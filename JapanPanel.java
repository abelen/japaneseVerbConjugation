package gui;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/* JapanPanel.java */
/* The class that contains the Listener that responds to the user events when 
 * they enter in the word and then hit enter on the keyboard. 
 */

public class JapanPanel extends JPanel {
	
	private JLabel enterLabel;
	private JTextField jpnText;
	private JLabel jpnMasu;
	private JLabel jpnMasuTitle;
	private JLabel jpnPast;
	private JLabel jpnPastTitle;
	private JapanCharacters chars;
	private JLabel jpnTe;
	private JLabel jpnTeTitle;
	private JLabel jpnNeg;
	private JLabel jpnNegTitle;
	private JLabel jpnNegPast;
	private JLabel jpnNegPastTitle;
	private JLabel jpnPotentialForm;
	private JLabel jpnPotTitle;
	private JLabel jpnPassiveTitle;
	private JLabel jpnPassive;
	private JLabel jpnCausativeTitle;
	private JLabel jpnCausative;
	
	
	public JapanPanel() throws IOException {
		chars = new JapanCharacters();
		
		enterLabel = new JLabel("Enter the dictionary form of the verb in kanji and hiragana.");
		jpnText = new JTextField(10);
		jpnMasuTitle = new JLabel("Masu Form");
		jpnMasu = new JLabel("---");
		jpnPastTitle = new JLabel("Past Form");
		jpnPast = new JLabel("---");
		jpnTeTitle = new JLabel("Te Form");
		jpnTe = new JLabel("---");
		jpnNegTitle = new JLabel("Negative Form");
		jpnNeg = new JLabel("---");
		jpnNegPastTitle = new JLabel("Past Negative Form");
		jpnNegPast = new JLabel("---");
		jpnPotentialForm = new JLabel("---");
		jpnPotTitle = new JLabel("Potential Form");
		jpnPassiveTitle = new JLabel("Passive");
		jpnPassive = new JLabel("---");
		jpnCausativeTitle = new JLabel("Causative");
		jpnCausative = new JLabel("---");
		
		
		jpnText.addActionListener(new TextListener());
		add(enterLabel);
		add(jpnText);
		add(jpnMasuTitle);
		add(jpnMasu);
		add(jpnPastTitle);
		add(jpnPast);
		add(jpnTeTitle);
		add(jpnTe);
		add(jpnNegTitle);
		add(jpnNeg);
		add(jpnNegPastTitle);
		add(jpnNegPast);
		add(jpnPotTitle);
		add(jpnPotentialForm);
		add(jpnPassiveTitle);
		add(jpnPassive);
		add(jpnCausativeTitle);
		add(jpnCausative);
		
		
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.RED);
		
	}
	
	private class TextListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			jpnMasu.setText(Conjugation.masuForm(jpnText.getText(),chars));
			jpnPast.setText(Conjugation.taHelper(jpnText.getText(), chars));
			jpnTe.setText(Conjugation.teHelper(jpnText.getText(), chars));
			jpnNeg.setText(Conjugation.getNegForm(jpnText.getText(), chars));
			jpnNegPast.setText(Conjugation.getNegPastForm(jpnText.getText(), chars));
			jpnPassive.setText(Conjugation.getPassive(jpnText.getText(), chars));
			jpnCausative.setText(Conjugation.getCausative(jpnText.getText(), chars));
			jpnPotentialForm.setText(Conjugation.getPotential(jpnText.getText(), chars));
			
		}		
	}
	
}