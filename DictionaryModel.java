import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * A 'Dictionary' class which extracts words from a file and manipulates
 * the words so they can be implemented by the mobile phone GUI and T9 algorithm. 
 */
public class DictionaryModel extends Observable {
	private MapDictionary model;
	private Collection<String> currentMatches;
	private Iterator<String> i;
	private String currentWord;
	private List<String> currentMessage;
	private String currentSig = new String();

	/**
	 * First constructor for the dictionary model.
	 * 
	 * @param dictionaryFile
	 *            A file in the form of a list of words to be used as an
	 *            alternative dictionary
	 * @throws java.io.IOException if the dictionaryFile param is invalid
	 */
	public DictionaryModel(String dictionaryFile) throws java.io.IOException {
		this.model = new MapDictionary(new File(dictionaryFile));
		currentMessage = new ArrayList<String>();

	}
	
	/**
	 * Second constructor for the dictionary model, which uses a default
	 * dictionary file.
	 * 
	 * @throws java.io.IOException if the file is not found or invalid
	 */
	public DictionaryModel() throws java.io.IOException {
		this.model = new MapDictionary(new File("words.txt"));
		currentMessage = new ArrayList<String>();

	}
	
	/**
	 * A getter method for the current message. 
	 * 
	 * @return The current message.
	 */
	public List<String> getMessage() {
		return currentMessage;
	}
	
	/**
	 * A method to add a letter to the current word using numbers 2 to 9 on 
	 * the keypad.
	 */
	public void addCharacter(char key) {

		currentSig += String.valueOf(key);
		currentMatches = ( model).signatureToWords(currentSig);

		i = currentMatches.iterator();
		nextMatch();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * A method to be activated by the 'C' button the keypad to remove the 
	 * last character on the word displayed on the message pane.
	 */
	public void removeLastCharacter() {
	    
		
	    if(currentWord != null && !currentMessage.isEmpty() && currentSig.length() == 0) {
			currentMessage.remove(currentMessage.size() - 1);
		}
	
		else if (currentSig.length() == 1) {
			currentSig = "";
			currentWord = "";
		} else if (currentSig.length() !=0){
			currentSig = currentSig.substring(0, currentSig.length() - 1);
			currentMatches = (model).signatureToWords(currentSig);
			i = currentMatches.iterator();
			nextMatch();
		}
		setChanged();
		notifyObservers();
		

	}
	
	/**
	 * A method to cycle to the next match in the list of possible words (for the
	 * current text typed in by the user on the interface) to be activated by the
	 * 'C' key.
	 */
	public void nextMatch() {
		try {
			if (i.hasNext()) {
				currentWord = i.next();
			} else {
				i = currentMatches.iterator();
				if (i.hasNext())
					currentWord = i.next();
			}
			setChanged();
			notifyObservers();
		} catch (NullPointerException e) {
		}
		
	}

	/**
	 * A method to accept the word being displayed as the current match and add
	 * the word to the list of words in the current message.
	 */
	public void acceptWord() {
		currentMessage.add(currentWord);
		currentWord = new String();
		currentSig = new String();
		i = currentMatches.iterator();
		setChanged();
		notifyObservers();

	}
	
	/**
	 * A getter method for the current message. 
	 * 
	 * @return The current word.
	 */
	public String getCurrentWord() {
		return currentWord;
	}

}
