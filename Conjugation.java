package gui;

/* Conjugation.java */
/* Handles the heavy lifting of doing the conjugations of the different Japanese verbs.
 */

import java.util.ArrayList;

public class Conjugation {
	
	public static String masuForm(String word, JapanCharacters chars) {
		
		char[] charsArr = word.toCharArray();
		String masuWord = "";
		ArrayList<String> table;
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("します");
			return suruWord;
			
		} else if (checkKuruVerb(word)){
			
			return "きます";
		
		} else if (checkRuVerb(word)){
			
			String ruWord = word.substring(0, word.length() - 1);
			ruWord = ruWord.concat("ます");
			return ruWord;
			
		} else {
		
			table = chars.getDict().get(Character.toString(charsArr[charsArr.length-1]));
		
			for (int i = 0; i < charsArr.length-1; i++) {
				masuWord = masuWord.concat(Character.toString(charsArr[i]));
			}
			masuWord = masuWord.concat(table.get(1));
			masuWord = masuWord.concat("ます");
			return masuWord;	
		}
		
	}
	
	public static String taHelper(String word, JapanCharacters chars) {
		String newWord = makeTeTa(word, chars);
		newWord = newWord.concat(addTa(word,chars));
		return newWord;
	}
	
	public static String teHelper(String word, JapanCharacters chars) {
		String newWord = makeTeTa(word, chars);
		newWord = newWord.concat(addTe(word,chars));
		return newWord;
	}
	
	private static String makeTeTa(String word, JapanCharacters chars) {
				
		char[] charsArr = word.toCharArray();
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("し");
			return suruWord;
			
		} else if (checkKuruVerb(word)){
			
			return "き";
		
		} else if (checkRuVerb(word)){
			String ruWord = word.substring(0, word.length() - 1);
			return ruWord;
			
		} else {
		
			String newWord = new String(word.substring(0, word.length() - 1));
			if (word.charAt(word.length() - 1) == 'う' ||
					word.charAt(word.length() - 1) == 'る' ||
					word.charAt(word.length() - 1) == 'つ' 
					) {
				newWord = newWord.concat("っ");
			} else if ((word.charAt(word.length() - 1) == 'ぬ' ||
					word.charAt(word.length() - 1) == 'む' ) ||
					word.charAt(word.length() - 1) == 'ぶ') {
				newWord = newWord.concat("ん");
			} else if (word.charAt(word.length() - 1) == 'く') {
				newWord = newWord.concat("い");
			} else if (word.charAt(word.length() - 1) == 'ぐ') {
				newWord = newWord.concat("い");
			} else { 
				newWord = newWord.concat("し");
			}
			return newWord;
		}
	}
	
	private static String addTe(String word, 
			JapanCharacters chars) {
	
		if ((word.charAt(word.length() - 1) == 'う' ||
				word.charAt(word.length() - 1) == 'る' ||
				word.charAt(word.length() - 1) == 'つ' ||
				word.charAt(word.length() - 1) == 'く')) {	
			return "て";
		} else  {
			return "で";
		}
	}
	
	private static String addTa(String word, 
			JapanCharacters chars) {
	
		if ((word.charAt(word.length() - 1)) == 'う' ||
				word.charAt(word.length() - 1) == 'る' ||
				word.charAt(word.length() - 1) == 'つ' ||
				word.charAt(word.length() - 1) == 'く') {	
			return "た";
		} else  {
			return "だ";
		}
	}
	
	public static String getNegForm(String word, JapanCharacters chars) {
		
		String newWord = preNegForm(word,chars);
		newWord = newWord.concat("い");
		return newWord;
	}
	
	public static String getNegPastForm(String word, JapanCharacters chars) {
		
		String newWord = preNegForm(word,chars);
		newWord = newWord.concat("かった");
		return newWord;
	}
	
	public static String preNegForm(String word, JapanCharacters chars) {
		
		char[] charsArr = word.toCharArray();
		String masuWord = "";
		ArrayList<String> table;
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("しな");
			return suruWord;
			
		} else if (checkKuruVerb(word)){
			
			return "きな";
		
		} else if (checkRuVerb(word)){
			
			String ruWord = word.substring(0, word.length() - 1);
			ruWord = ruWord.concat("な");
			return ruWord;
			
		} else {
		
			table = chars.getDict().get(Character.toString(charsArr[charsArr.length-1]));
		
			for (int i = 0; i < charsArr.length-1; i++) {
				masuWord = masuWord.concat(Character.toString(charsArr[i]));
			}
			if (checkUVerb(word)) {
				masuWord = masuWord.concat("わ");
			} else {
				masuWord = masuWord.concat(table.get(0));
			}
			masuWord = masuWord.concat("な");
			return masuWord;	
		}
		
	}
	
	public static String getPassive(String word, JapanCharacters chars) {
		
		char[] charsArr = word.toCharArray();
		String masuWord = "";
		ArrayList<String> table;
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("される");
			return suruWord;
			
		} else if (checkKuruVerb(word)){
			
			return "来される";
		
		} else if (checkRuVerb(word)){
			
			String ruWord = word.substring(0, word.length() - 1);
			ruWord = ruWord.concat("される");
			return ruWord;
			
		} else {
		
			table = chars.getDict().get(Character.toString(charsArr[charsArr.length-1]));
		
			for (int i = 0; i < charsArr.length-1; i++) {
				masuWord = masuWord.concat(Character.toString(charsArr[i]));
			}
			if (checkUVerb(word)) {
				masuWord = masuWord.concat("わ");
			} else {
				masuWord = masuWord.concat(table.get(0));
			}
			masuWord = masuWord.concat("れる");
			return masuWord;	
		}
		
	}
	
	public static String getCausative(String word, JapanCharacters chars) {
		
		char[] charsArr = word.toCharArray();
		String masuWord = "";
		ArrayList<String> table;
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("される");
			return suruWord;
			
		} else if (checkKuruVerb(word)){
			
			return "来させる";
		
		} else if (checkRuVerb(word)){
			
			String ruWord = word.substring(0, word.length() - 1);
			ruWord = ruWord.concat("させる");
			return ruWord;
			
		} else {
		
			table = chars.getDict().get(Character.toString(charsArr[charsArr.length-1]));
		
			for (int i = 0; i < charsArr.length-1; i++) {
				masuWord = masuWord.concat(Character.toString(charsArr[i]));
			}
			if (checkUVerb(word)) {
				masuWord = masuWord.concat("わ");
			} else {
				masuWord = masuWord.concat(table.get(0));
			}
			masuWord = masuWord.concat("せる");
			return masuWord;	
		}
		
	}
		
	public static String getPotential(String word, JapanCharacters chars) {
		
		char[] charsArr = word.toCharArray();
		String masuWord = "";
		ArrayList<String> table;
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("できる");
			return suruWord;
			
		} else if (checkKuruVerb(word)){
			
			return "来られる";
		
		} else if (checkRuVerb(word)){
			
			String ruWord = word.substring(0, word.length() - 1);
			ruWord = ruWord.concat("られる");
			return ruWord;
			
		} else {
		
			table = chars.getDict().get(Character.toString(charsArr[charsArr.length-1]));
		
			for (int i = 0; i < charsArr.length-1; i++) {
				masuWord = masuWord.concat(Character.toString(charsArr[i]));
			}
			//if (checkUVerb(word)) {
				//masuWord = masuWord.concat("わ");
			//} else {
			masuWord = masuWord.concat(table.get(3));
			//}
			masuWord = masuWord.concat("る");
			return masuWord;	
		}
		
	}
	
	private static boolean checkSuruVerb(String word) {
		
		if ( (word.equals("する") ) || (word.substring(word.length() - 2, word.length()).equals("する")) ) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean checkKuruVerb(String word) {
	
		if (word.equals("くる") || (word.equals("来る"))) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private static boolean checkUVerb(String word) {
		if (word.substring(word.length() - 1, word.length()).equals("う")) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean checkRuVerb(String word) {
	
		if (word.substring(word.length() - 2, 
				word.length()).equals("べる") || 
				word.substring(word.length() - 2, word.length()).equals("める") ||
				word.substring(word.length() - 2, word.length()).equals("える") ||
				word.substring(word.length() - 2, word.length()).equals("へる") ||
				word.substring(word.length() - 2, word.length()).equals("ける") ||
				word.substring(word.length() - 2, word.length()).equals("ぺる") ||
				word.substring(word.length() - 2, word.length()).equals("げる") ||
				word.substring(word.length() - 2, word.length()).equals("せる") ||
				word.substring(word.length() - 2, word.length()).equals("れる")
				) {
			return true;
		} else {
			return false;
		}
	}
}