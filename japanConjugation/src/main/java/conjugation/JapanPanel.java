package conjugation;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.*;

/**
 * The class that contains the Listener that responds to the user events when
 * they enter in the word and then hit enter on the keyboard. 
 */

@Named
public class JapanPanel extends JPanel {

    private JLabel enterLabel;

    private ConjugationPanel conjugationPanel;

    @Inject
    private JapanCharacters chars;

    /**
     * Default constructor.
     *
     * @throws IOException
     */
    public JapanPanel() throws IOException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        chars = new JapanCharacters();
        conjugationPanel = new ConjugationPanel();

        enterLabel = new JLabel("Enter the dictionary form of the verb in kanji or hiragana.");
        add(enterLabel);
        add(conjugationPanel);

        setPreferredSize(new Dimension(400, 370));
        setBackground(Color.RED);
    }

    /* Inner class that uses to get the panel that holds all the conjugations */
    class ConjugationPanel extends JPanel {
        private JTextField jpnText;
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
        private JLabel jpnTaiForm;
        private JLabel jpnTaiFormTitle;
        private JLabel jpnCondForm;
        private JLabel jpnCondFormTitle;

        /**
         * Default constructor that is setup the conjugation panel with its
         * default values.
         */
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

        /**
         * Inner class that will be used to listen for when a user enters a Japanese word.
         */
        private class TextListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                if (DataValidator.validate(jpnText.getText())) {
                    // check to see if there's need to be translation from romaji.
                    String newWord;
                    if (DataValidator.getType() == DataValidator.Type.ROMAJI) {
                        newWord = RomajiTranslation.translate(jpnText.getText());
                    } else {
                        newWord = jpnText.getText();
                    }
                    jpnMasu.setText(Conjugation.masuForm(newWord, chars));
                    jpnPast.setText(Conjugation.getTe(newWord, chars));
                    jpnTe.setText(Conjugation.getTa(newWord, chars));
                    jpnNeg.setText(Conjugation.getNegForm(newWord, chars));
                    jpnNegPast.setText(Conjugation.getNegPastForm(newWord, chars));
                    jpnPassive.setText(Conjugation.getPassive(newWord, chars));
                    jpnCausative.setText(Conjugation.getCausative(newWord, chars));
                    jpnPotentialForm.setText(Conjugation.getPotential(newWord, chars));
                    jpnTaiForm.setText(Conjugation.getTaiForm(newWord, chars));
                    jpnCondForm.setText(Conjugation.getConditional(newWord, chars));
                } else {
                    JOptionPane.showMessageDialog(null, "Word must be a Japanese verb written in Japanese characters");
                }
            }
        }
    }
}