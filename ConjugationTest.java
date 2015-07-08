package gui;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConjugationTest {

	@Test
	public void test() {
		
		JapanCharacters jpnChars = new JapanCharacters();
		
		assertEquals(Conjugation.masuForm("やめる", jpnChars), "やめます");
		assertEquals(Conjugation.masuForm("たべる", jpnChars), "たべます");
		assertEquals(Conjugation.masuForm("たべさせる", jpnChars), "たべます");
		//assertEquals(Conjugation.masuForm("たべる", jpnChars), "たべます");
		
	}
	
	

}
