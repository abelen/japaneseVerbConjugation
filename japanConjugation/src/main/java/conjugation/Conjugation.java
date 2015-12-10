package conjugation;

/**
 * Handles the heavy lifting of doing the conjugations of the different Japanese verbs.
 * Throughout this class, each method goes through and checks to see if the verb is a 
 * する verb, くる, u-verb, ru-verb and conjugates them accordingly.
 */

import java.util.ArrayList;

public class Conjugation {
	
	/* Method that conjugates the masu form of the word */
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

	/**
	 * Returns the negative form of the verb.
	 *
	 * @param word The japanese word to be conjugated.
	 * @param chars The japan characters dictionary.
	 * @return The negative form of the verb.
	 */
	public static String getNegForm(String word, JapanCharacters chars) {
		String newWord = preNegForm(word,chars);
		newWord = newWord.concat("い");
		return newWord;
	}

	/**
	 * Returns the negative past form of the verb.
	 *
	 * @param word The japanese word to be conjugated.
	 * @param chars The Japanese characters dictionary.
	 * @return The negative past form of the verb.
	 */
	public static String getNegPastForm(String word, JapanCharacters chars) {
		String newWord = preNegForm(word,chars);
		newWord = newWord.concat("かった");
		return newWord;
	}

	/**
	 * Returns the passive form of the verb.
	 *
	 * @param word The japanese word to be conjugated.
	 * @param chars The japanese characters dictionary.
	 * @return The passive form of the verb.
	 */
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

	/**
	 * Returns the causative form of the verb.
	 *
	 * @param word The Japanese word to be conjugated.
	 * @param chars The Japanese Characters dictionary.
	 * @return The causative form of the verb.
	 */
	public static String getCausative(String word, JapanCharacters chars) {
		char[] charsArr = word.toCharArray();
		String masuWord = "";
		ArrayList<String> table;
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("させる");
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

	/**
	 * Returns the potential form of the verb.
	 *
	 * @param word The Japanese word to be conjugated.
	 * @param chars The Japanese characters dictionary.
	 * @return The potential form of the verb.
	 */
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
			masuWord = masuWord.concat(table.get(3));
			masuWord = masuWord.concat("る");
			return masuWord;	
		}
	}

	/**
	 * Returns the tai form of the verb.
	 *
	 * @param word The japanese word to be conjugated.
	 * @param chars The Japanese characters dictionary.
	 * @return The tai form of the verb.
	 */
	public static String getTaiForm(String word, JapanCharacters chars) {
		
		char[] charsArr = word.toCharArray();
		String masuWord = "";
		ArrayList<String> table;
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("したい");
			return suruWord;
		} else if (checkKuruVerb(word)){	
			return "きたい";
		} else if (checkRuVerb(word)){
			String ruWord = word.substring(0, word.length() - 1);
			ruWord = ruWord.concat("たい");
			return ruWord;
		} else {
			table = chars.getDict().get(Character.toString(charsArr[charsArr.length-1]));
		
			for (int i = 0; i < charsArr.length-1; i++) {
				masuWord = masuWord.concat(Character.toString(charsArr[i]));
			}
			masuWord = masuWord.concat(table.get(1));
			masuWord = masuWord.concat("たい");
			return masuWord;	
		}
	}

	/**
	 * Returns the conditional form of the verb.
	 *
	 * @param word The japanese word to be conjugated.
	 * @param chars The Japanese characters dictionary.
	 * @return
	 */
	public static String getConditional(String word, JapanCharacters chars) {
		char[] charsArr = word.toCharArray();
		String masuWord = "";
		ArrayList<String> table;
		
		/* to conjugate a suru verb */
		if (checkSuruVerb(word)) {
			String suruWord = word.substring(0, word.length() - 2);
			suruWord = suruWord.concat("すれば");
			return suruWord;
		} else if (checkKuruVerb(word)) {
			return "来れば";
		} else if (checkRuVerb(word)){
			String ruWord = word.substring(0, word.length() - 1);
			ruWord = ruWord.concat("れば");
			return ruWord;
		} else {
		
			table = chars.getDict().get(Character.toString(charsArr[charsArr.length-1]));
		
			for (int i = 0; i < charsArr.length-1; i++) {
				masuWord = masuWord.concat(Character.toString(charsArr[i]));
			}
			masuWord = masuWord.concat(table.get(3));
			masuWord = masuWord.concat("ば");
			return masuWord;	
		}
	}

    /**
     * Returns the te form of the verb.
     *
     * @param word The Japanese word to be conjugated.
     * @param chars The Japanese characters dictionary.
     * @return The Te form of the verb.
     */
    public static String getTe(String word, JapanCharacters chars) {
        String newWord = makeTeTa(word, chars);
        newWord = newWord.concat(addTa(word,chars));
        return newWord;
    }

    /**
     * Returns the Ta form of the verb.
     *
     * @param word The Japanese word to be conjugated.
     * @param chars The Japanese Characters dictionary.
     * @return The Ta form of the verb.
     */
    public static String getTa(String word, JapanCharacters chars) {
        String newWord = makeTeTa(word, chars);
        newWord = newWord.concat(addTe(word,chars));
        return newWord;
    }

    /*
     * Helper function to check if its a suru verb.
     */
    private static boolean checkSuruVerb(String word) {
		if ( (word.equals("する") ) || (word.substring(word.length() - 2, word.length()).equals("する")) ) {
			return true;
		} else {
			return false;
		}
	}

    /*
     * Helper function to check if its kuru.
     */
	private static boolean checkKuruVerb(String word) {
		if (word.equals("くる") || (word.equals("来る"))) {
			return true;
		} else {
			return false;
		}
	}

    /*
     * Helper function that is used to check to see if it's a u verb.
     */
	private static boolean checkUVerb(String word) {
		if (word.substring(word.length() - 1, word.length()).equals("う")) {
			return true;
		} else {
			return false;
		}
	}

    /*
     * Helper function that is used to check to see if it's a ru verb.
     */
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

	/* The combined method that is used in able to conjugate the common prefix that are used
	 * by the te and the past form of the verb.
	 */
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

	/* Adds the last bit of the te form to the verb in accordance to the Japanese
	 * rules of conjugating verbs.
	 */
	private static String addTe(String word,
								JapanCharacters chars) {
		if ((word.charAt(word.length() - 1) == 'う' ||
				word.charAt(word.length() - 1) == 'る' ||
				word.charAt(word.length() - 1) == 'つ' ||
				word.charAt(word.length() - 1) == 'く')) {
			return "て";
		} else  {
			/* if the verb is ends in ぐ */
			return "で";
		}
	}

	/* private helper function that is used to conjugate the た. */
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

    /* Method that conjugates the common prefix of the negative form and the past
    * negative form */
    private static String preNegForm(String word, JapanCharacters chars) {
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
}