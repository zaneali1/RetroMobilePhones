import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * This class implements the T9 algorithm to convert a numeric signature to a 
 * set of possible corresponding words (an vice versa).
 */
public class MapDictionary {
	Map<String, ArrayList<String>> mapOfWords = new HashMap<String, ArrayList<String>>();

	/**
	 * This method takes a word and returns the corresponding signature, which
	 * is a set of numbers that would be inputed to display a word on a mobile
	 * phone 10-key keypad.
	 * 
	 * @param word
	 *              A word for which the corresponding signature will be returned.
	 * @return The signature of a word, i.e. the set of number that would be
	 *         inputed on a mobile phone keypad to cause the word to be
	 *         displayed.
	 */
	public static String wordToSignature(String word) {

		StringBuffer signature = new StringBuffer();
		word = word.toLowerCase();

		for (int i = 0; i < word.length(); i++) {
			char x = word.charAt(i);
			if (x == 'a' || x == 'b' || x == 'c')
				signature.append(2);
			else if (x == 'd' || x == 'e' || x == 'f')
				signature.append(3);
			else if (x == 'g' || x == 'h' || x == 'i')
				signature.append(4);
			else if (x == 'j' || x == 'k' || x == 'l')
				signature.append(5);
			else if (x == 'm' || x == 'n' || x == 'o')
				signature.append(6);
			else if (x == 'p' || x == 'q' || x == 'r' || x == 's')
				signature.append(7);
			else if (x == 't' || x == 'u' || x == 'v')
				signature.append(8);
			else if (x == 'w' || x == 'x' || x == 'y' || x == 'z')
				signature.append(9);
			else
				signature.append(" ");
		}

		return signature.toString();
	}

	/**
	 * A helper method for signatureToWords. Checks if a word is made up of only
	 * letters before adding it to the set of matching words to be returned.
	 * 
	 * @param word
	 *            A word in the dictionary which has a corresponding signature. 
	 * @return True if word is made up of only letters, false otherwise.
	 */
	public static boolean isAWord(String word) {
		for (int i = 0; i < wordToSignature(word).length(); i++) {
			if (wordToSignature(word).charAt(i) == ' ')
				return false;
		}
		return true;
	}
	
	/**
	 * A helper method for wordsToSignature. Checks if a signature is made up of only
	 * numbers before it can be returned.
	 * 
	 * @param signature
	 *            A numeric String which can be typed in to a mobile phone
	 *            10-key keypad to return various words.
	 * @return True if signature is a numeric String, false otherwise.
	 */
	public static boolean isASignature(String signature) {
		for (int i = 0; i < signature.length(); i++) {
			if (!Character.isDigit(signature.charAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * A constructor which places each value in the dictionary into 
	 * a map, with the signature for each word being the key. 
	 */
	public MapDictionary(File file) {
		Scanner listOfWords = null;
		try {
			FileReader reader = new FileReader(file);
			listOfWords = new Scanner(reader);
			while (listOfWords.hasNextLine()) {
				String word = listOfWords.nextLine();
				if (isAWord(word)) {
					word = word.toLowerCase();
					String sig = wordToSignature(word);
					if(mapOfWords.containsKey(sig)){
						if(!mapOfWords.get(sig).contains(word))
							mapOfWords.get(sig).add(word);
					}else{
						ArrayList<String> x = new ArrayList<String>();
						x.add(word);
						mapOfWords.put(sig, x);
					}

				}
			}
		} catch (IOException e) {
			System.out.println("The file was not found.");
		}
		listOfWords.close();

	}
	
	/**
	 * This method takes a numeric signature and returns a set of words that the
	 * numeric signature corresponds to.
	 * 
	 * @param signature
	 *            A numeric String which can be typed in to a mobile phone
	 *            10-key keypad to return various words.
	 * @return The set of words that the signature corresponds to.
	 */
	public Set<String> signatureToWords(String signature) {
		Set<String> x = new HashSet<String>();
		if(mapOfWords.containsKey(signature)){
			ArrayList<String> y = mapOfWords.get(signature);

			for(int i = 0; i<y.size(); i++){
				if(y.get(i).length() == signature.length() && isAWord(y.get(i))){
					x.add(y.get(i));
				}
			}
		} 

		return x;
	}
	
}
