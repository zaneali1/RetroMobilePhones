import java.awt.event.*;
/**
 * A listener class which responds to the special inputs '0', '*' and 'C'
 * as well as the regular inputs on the interface. 
 */
public class KeypadListener implements ActionListener {

	private DictionaryModel model;
	private char key;

	/** A constructor for the listener.
	 * 
	 * @param model
	 * @param key
	 */
	public KeypadListener(DictionaryModel model, char key) {
		this.model = model;
		this.key = key;
	}


	public void actionPerformed(ActionEvent e) {
		if (key == '0') {
			// Accepts the current word as part of the message.
			model.acceptWord();
		} else if (key == '*') {
			// Changes the current word by cycling through the list of 
			// possible matches in the dictionary.
			model.nextMatch();  
		} 
		else if (key == 'C') {
			// Deletes the last character in the word, or deletes an entire
			// previous word if the word is completed (i.e. a space is inputed after
			// the word). 
			model.removeLastCharacter();
		} else {
			model.addCharacter(key);
		}
	}
}
