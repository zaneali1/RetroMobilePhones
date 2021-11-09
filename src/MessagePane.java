
import java.util.Observer;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel class for the messages which are being entered. Also, this class
 * observes the DictionaryModel for possible changes, and is updated accordingly.
 */
public class MessagePane extends JPanel implements Observer {

	private DictionaryModel model;
	private JTextArea message;

	/**
	 * Constructor
	 * 
	 * @param model,
	 *            the DictionaryModel
	 */
	public MessagePane(DictionaryModel model) {
		this.model = model;

		model.addObserver(this);

		message = new JTextArea(5, 20);
		message.setEditable(false);
		message.setLineWrap(true);
		message.setText("predictive text: enter text with 8 keys.");

		JScrollPane scrollPane = new JScrollPane(message);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * This method updates the observer.
	 */
	public void update(Observable obs, Object obj) {

		StringBuffer words = new StringBuffer();

		for (String word : model.getMessage())
			words.append(word + " ");

		message.setText(words + model.getCurrentWord());
		
		
	}
}
