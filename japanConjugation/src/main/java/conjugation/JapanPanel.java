package conjugation;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

/* JapanPanel.java */
/* The class that contains the Listener that responds to the user events when 
 * they enter in the word and then hit enter on the keyboard. 
 */

public class JapanPanel extends JPanel {
	
	private JLabel enterLabel;
	private JapanCharacters chars;
	private ConjugationPanel conjugationPanel;
	
	
	public JapanPanel() throws IOException {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		chars = new JapanCharacters();
		conjugationPanel = new ConjugationPanel();
		
		enterLabel = new JLabel("Enter the dictionary form of the verb in kanji and hiragana.");
		add(enterLabel);
		add(conjugationPanel);
		
		setPreferredSize(new Dimension(300,370));
		setBackground(Color.RED);
		
	}

	/* Inner class that uses to get the panel that holds all the conjugations */
	class ConjugationPanel extends JPanel {
		private JLabel jpnMasu;
		private JLabel jpnMasuTitle;
		private JLabel jpnPast;
		private JLabel jpnPastTitle;
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
		private JTextField jpnText;
		private JLabel jpnTaiForm;
		private JLabel jpnTaiFormTitle;
		private JLabel jpnCondForm;
		private JLabel jpnCondFormTitle;

		public ConjugationPanel() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			jpnText = new JTextField(10);
			
			jpnText.addActionListener(new TextListener());
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
			jpnTaiFormTitle = new JLabel("Want to Form");
			jpnTaiForm = new JLabel("---");
			jpnCondFormTitle = new JLabel("Conditional");
			jpnCondForm = new JLabel("---");
			
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
			add(jpnTaiFormTitle);
			add(jpnTaiForm);
			add(jpnCondFormTitle);
			add(jpnCondForm);
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
				jpnTaiForm.setText(Conjugation.getTaiForm(jpnText.getText(), chars));
				jpnCondForm.setText(Conjugation.getConditional(jpnText.getText(), chars));
				
			}		
		}
	}
}