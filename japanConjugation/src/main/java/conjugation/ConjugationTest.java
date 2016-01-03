package conjugation;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class that is used to test the different conjugation patterns.
 */
public class ConjugationTest {

	@Test
	public void test() {
		JapanCharacters jpnChars = new JapanCharacters();
		
		assertEquals(Conjugation.masuForm("やめる", jpnChars), "やめます");
		assertEquals(Conjugation.masuForm("たべる", jpnChars), "たべます");
		assertEquals(Conjugation.masuForm("たべさせる", jpnChars), "たべます");

		// TODO: check to see if the romaji translation works.
	}
}
