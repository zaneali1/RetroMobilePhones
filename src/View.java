
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

/**
 * This class represents the view. Essentially here we create the JFrame
 * (top-level container), and all the classes which make up the complete GUI.
 *
 * Here we create two Views with the same model passed as an argument, to demonstrate
 * the effect of the Observer pattern. That is, when a change happens to one view,
 * the other is being updated accordingly. 
 */

public class View {
	public static void main(String[] args) throws Exception {
		javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

		DictionaryModel model = new DictionaryModel();
		KeypadPane keypad = new KeypadPane(model);
		MessagePane view = new MessagePane(model);

		JFrame gui = new JFrame();
		gui.setLayout(new BorderLayout());
		gui.add(keypad, BorderLayout.SOUTH);
		gui.add(view, BorderLayout.CENTER);

		gui.pack();
		gui.setTitle("Predictive Text: View 1");
		gui.setVisible(true);

		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		KeypadPane keypad1 = new KeypadPane(model);
		MessagePane view1 = new MessagePane(model);

		JFrame gui1 = new JFrame();
		gui1.setLayout(new BorderLayout());
		gui1.add(keypad1, BorderLayout.SOUTH);
		gui1.add(view1, BorderLayout.CENTER);

		gui1.pack();
		gui1.setTitle("Predictive Text: View 2");
		gui1.setLocationRelativeTo(null);
		gui1.setVisible(true);
		gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
