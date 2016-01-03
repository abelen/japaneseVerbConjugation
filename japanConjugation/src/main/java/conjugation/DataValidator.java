package conjugation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class that does all the data validation.
 */
public class DataValidator {

    private static Set<String> romajiSet = new HashSet<String>();

    private static Set<String> japaneseSet = new HashSet<String>();

    static {
        populateRomajiSet();
        populateJapaneseSet();
    }

    public static boolean validate(String word) {

        // check to see if there's japanese text first
        if (validateJapanese(word)) {
            return true;
        } else {
            if (validateRomaji(word)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean validateRomaji(String word) {
        // go thru each character to see if it's in the set

        char[] wordCharacters = word.toCharArray();
        List<String> charList = new ArrayList<String>();

        for (int i = 0; i < wordCharacters.length; i++) {
            charList.add(Character.toString(wordCharacters[i]));
        }

        for (String s : charList) {
            if (! (romajiSet.contains(s))) {
                return false;
            }
        }
        return true;

        // TODO: will need to further validate more, with letter combinations.
    }

    /**
     * Validates the data to see if it's a japanese verb. If so, return true
     * Otherwise, fail with a message.
     *
     * @param word The word that needs to be validated.
     */
    public static boolean validateJapanese(String word) {

        // checks to see all if the characters are japanese.
        // split up the word into their characters.
        char[] wordCharacters = word.toCharArray();
        List<String> charList = new ArrayList<String>();

        for (int i = 0; i < wordCharacters.length; i++) {
            charList.add(Character.toString(wordCharacters[i]));
        }

        for (String s : charList) {
            if (! (japaneseSet.contains(s))) {
                return false;
            }
        }

        // check to see if it's a japanese.
        char lastCharacter = word.charAt(word.length() - 1);
        if (lastCharacter == 'う' || lastCharacter == 'く' ||
                lastCharacter == 'ぐ' || lastCharacter == 'る' ||
                lastCharacter == 'つ' || lastCharacter == 'づ'||
                lastCharacter == 'す' || lastCharacter == 'ず' ||
                lastCharacter == 'ふ' || lastCharacter == 'ぶ' ||
                lastCharacter == 'ぷ' || lastCharacter == 'む') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Populate the romajiSet.
     */
    private static void populateRomajiSet() {
        romajiSet.add("a");
        romajiSet.add("s");
        romajiSet.add("i");
        romajiSet.add("u");
        romajiSet.add("o");
        romajiSet.add("r");
        romajiSet.add("t");
        romajiSet.add("y");
        romajiSet.add("p");
        romajiSet.add("f");
        romajiSet.add("b");
        romajiSet.add("n");
        romajiSet.add("k");
        romajiSet.add("g");
        romajiSet.add("z");
        romajiSet.add("m");
        romajiSet.add("d");
        romajiSet.add("h");
        romajiSet.add("w");
    }

    /**
     * Populates the Japanese character map.
     */
    private static void populateJapaneseSet() {
        japaneseSet.add("あ");
        japaneseSet.add("い");
        japaneseSet.add("う");
        japaneseSet.add("お");
        japaneseSet.add("え");
        japaneseSet.add("さ");
        japaneseSet.add("し");
        japaneseSet.add("す");
        japaneseSet.add("せ");
        japaneseSet.add("そ");
        japaneseSet.add("ざ");
        japaneseSet.add("じ");
        japaneseSet.add("ぜ");
        japaneseSet.add("ぞ");
        japaneseSet.add("ず");
        japaneseSet.add("ち");
        japaneseSet.add("ぢ");
        japaneseSet.add("つ");
        japaneseSet.add("づ");
        japaneseSet.add("わ");
        japaneseSet.add("を");
        japaneseSet.add("た");
        japaneseSet.add("て");
        japaneseSet.add("と");
        japaneseSet.add("だ");
        japaneseSet.add("で");
        japaneseSet.add("ど");
        japaneseSet.add("ふ");
        japaneseSet.add("ぶ");
        japaneseSet.add("ぷ");
        japaneseSet.add("ら");
        japaneseSet.add("り");
        japaneseSet.add("る");
        japaneseSet.add("ろ");
        japaneseSet.add("れ");
        japaneseSet.add("や");
        japaneseSet.add("よ");
        japaneseSet.add("じ");
        japaneseSet.add("ま");
        japaneseSet.add("み");
        japaneseSet.add("む");
        japaneseSet.add("め");
        japaneseSet.add("も");
        japaneseSet.add("な");
        japaneseSet.add("ぬ");
        japaneseSet.add("ね");
        japaneseSet.add("の");
        japaneseSet.add("に");
        japaneseSet.add("か");
        japaneseSet.add("き");
        japaneseSet.add("こ");
        japaneseSet.add("け");
        japaneseSet.add("く");
        japaneseSet.add("が");
        japaneseSet.add("ぎ");
        japaneseSet.add("ぐ");
        japaneseSet.add("げ");
        japaneseSet.add("ご");
        japaneseSet.add("は");
        japaneseSet.add("ひ");
        japaneseSet.add("ほ");
        japaneseSet.add("へ");
        japaneseSet.add("ば");
        japaneseSet.add("び");
        japaneseSet.add("ぼ");
        japaneseSet.add("べ");
        japaneseSet.add("ぱ");
        japaneseSet.add("ぴ");
        japaneseSet.add("ぽ");
        japaneseSet.add("ぺ");
    }
}
