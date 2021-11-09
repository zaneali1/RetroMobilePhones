import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the dictionary model. 
 */
public class TestCases {

	private DictionaryModel dict;
	private DictionaryModel dictWords;
	
	
	@Before
	public void setUp() {

		try {
			dict = new DictionaryModel();
			dictWords = new DictionaryModel("words.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// Testing the addCharacter and getCurrentWord method:
	@Test
	public void Test1() {

		dictWords.addCharacter('2');

		String actual = dictWords.getCurrentWord();
		String expected = "a";

		assertTrue(actual.equals(expected));
	}

	@Test
	public void Test2() {

		dictWords.addCharacter('1');

		List<String> actual = dictWords.getMessage();
		List<String> expected = Arrays.asList();

		assertTrue(actual.equals(expected));
	}

	// Testing the acceptMatch method:
	@Test
	public void Test3() {

		dictWords.addCharacter('4');
		dictWords.addCharacter('3');
		dictWords.addCharacter('5');
		dictWords.addCharacter('5');
		dictWords.addCharacter('6');
		dictWords.acceptWord();

		List<String> actual = dictWords.getMessage();
		String x = "gekko ";
		List<String> expected = new ArrayList<String>();
		expected.add(x);


		assertEquals(actual, expected);
	}

	// Testing the nextMatch method:
	@Test
	public void Test4() {

		dictWords.addCharacter('4');
		dictWords.addCharacter('3');
		dictWords.addCharacter('5');
		dictWords.addCharacter('5');
		dictWords.addCharacter('6');
		dictWords.nextMatch();

		String actual = dictWords.getCurrentWord();
		String expected = "hello";

		assertEquals(expected, actual);
	}
	
	// Checks if the nextMatch method cycles back to the original value:
	@Test
	public void Test5() {

		dictWords.addCharacter('4');
		dictWords.addCharacter('3');
		dictWords.addCharacter('5');
		dictWords.addCharacter('5');
		dictWords.addCharacter('6');
		dictWords.nextMatch();
		dictWords.nextMatch();


		String actual = dictWords.getCurrentWord();
		String expected = "gekko";

		assertEquals(expected, actual);
	}

	// Testing the removeLastCharacter method:
	@Test
	public void Test6() {

		dictWords.addCharacter('4');
		dictWords.addCharacter('3');
		dictWords.addCharacter('5');
		dictWords.addCharacter('5');
		dictWords.addCharacter('6');
		dictWords.removeLastCharacter();

		String actual = dictWords.getCurrentWord();
		String expected = "hell";

		assertEquals(expected, actual);
	}

	@Test
	public void Test7() {

		dictWords.addCharacter('4');
		dictWords.removeLastCharacter();

		List<String> actual = dictWords.getMessage();
		List<String> expected = Arrays.asList();

		assertTrue(actual.equals(expected));

	}

}
