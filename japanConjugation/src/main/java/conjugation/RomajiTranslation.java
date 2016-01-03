package conjugation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that is used in able to translate from romaji to the proper japanese.
 */
public class RomajiTranslation {

    private static Map<String, String> romajiMap = new HashMap<String, String>();

    private static int pos;

    static {
        populateMap();
    }

    /**
     * Translates the romaji into its Japanese equivalent.
     *
     * @return The Japanese translation.
     */
    public static String translate(String word) {

        if (word.equals("kuru")) {
            return "くる";
        } else {
           List<String> syllables = split(word);
            System.out.println(syllables);
            // transform the list into japanese equivalents.
            StringBuffer newWord = new StringBuffer();
            for (String s : syllables) {
                newWord = newWord.append(romajiMap.get(s));
            }
            return newWord.toString();
        }
    }

    /**
     * Translates the romaji into its Japanese equivalent.
     * This is compatible with Hepburn or Kunrei-shiki romaji.
     *
     * @return The string has its Japanese equivalent.
     */
    private static void populateMap() {

        // accomodate hepburn and kunrei-shiki romanization.
        romajiMap.put("u", "う");
        romajiMap.put("tu", "つ");
        romajiMap.put("tsu", "つ");
        romajiMap.put("ru", "る");
        romajiMap.put("ku", "く");
        romajiMap.put("gu", "ぐ");
        romajiMap.put("dzu", "づ");
        romajiMap.put("du", "づ");
        romajiMap.put("su", "す");
        romajiMap.put("zu", "ず");
        romajiMap.put("bu", "ぶ");
        romajiMap.put("nu", "ぬ");
        romajiMap.put("a", "あ");
        romajiMap.put("i", "い");
        romajiMap.put("u", "う");
        romajiMap.put("o", "お");
        romajiMap.put("e", "え");
        romajiMap.put("sa", "さ");
        romajiMap.put("shi", "し");
        romajiMap.put("su", "す");
        romajiMap.put("se", "せ");
        romajiMap.put("so", "そ");
        romajiMap.put("sa", "ざ");
        romajiMap.put("ji", "じ");
        romajiMap.put("ze", "ぜ");
        romajiMap.put("zo", "ぞ");
        romajiMap.put("zu", "ず");
        romajiMap.put("chi", "ち");
        romajiMap.put("ti", "ち");
        romajiMap.put("di", "ぢ");
        romajiMap.put("tu", "つ");
        romajiMap.put("tsu", "つ");
        romajiMap.put("du", "づ");
        romajiMap.put("wa", "わ");
        romajiMap.put("wo", "を");
        romajiMap.put("ta", "た");
        romajiMap.put("te", "て");
        romajiMap.put("to", "と");
        romajiMap.put("da", "だ");
        romajiMap.put("de", "で");
        romajiMap.put("do", "ど");
        romajiMap.put("fu", "ふ");
        romajiMap.put("hu", "ふ");
        romajiMap.put("bu", "ぶ");
        romajiMap.put("pu", "ぷ");
        romajiMap.put("ra", "ら");
        romajiMap.put("ri", "り");
        romajiMap.put("ru", "る");
        romajiMap.put("ro", "ろ");
        romajiMap.put("re", "れ");
        romajiMap.put("ya", "や");
        romajiMap.put("yo", "よ");
        romajiMap.put("ji", "じ");
        romajiMap.put("ma", "ま");
        romajiMap.put("mi", "み");
        romajiMap.put("mu", "む");
        romajiMap.put("me", "め");
        romajiMap.put("mo", "も");
        romajiMap.put("na", "な");
        romajiMap.put("nu","ぬ");
        romajiMap.put("ne", "ね");
        romajiMap.put("no", "の");
        romajiMap.put("ni", "に");
        romajiMap.put("ka", "か");
        romajiMap.put("ki", "き");
        romajiMap.put("ko", "こ");
        romajiMap.put("ke", "け");
        romajiMap.put("ku", "く");
        romajiMap.put("ga", "が");
        romajiMap.put("gi", "ぎ");
        romajiMap.put("gu", "ぐ");
        romajiMap.put("ge", "げ");
        romajiMap.put("go", "ご");
        romajiMap.put("ha", "は");
        romajiMap.put("hi", "ひ");
        romajiMap.put("ho", "ほ");
        romajiMap.put("he", "へ");
        romajiMap.put("ba", "ば");
        romajiMap.put("bi", "び");
        romajiMap.put("bo", "ぼ");
        romajiMap.put("be", "べ");
        romajiMap.put("pa", "ぱ");
        romajiMap.put("pi", "ぴ");
        romajiMap.put("po", "ぽ");
        romajiMap.put("pe", "ぺ");
    }

    /**
     * Splits the romaji words into their japanese syllables.
     *
     * @return The syllables that make up the word.
     */
    private static List<String> split(String word) {

        List<String> syllableList = new ArrayList<String>();

        pos = word.length() - 1;
        while (pos >= 0) {
            syllableList.add(0, splitHelper(word, ""));
        }
        return syllableList;
    }

    private static String splitHelper(String word, String intermed) {

        if (pos >= 0) {
            // check the intermed value to see if it exists in the map
            String newWord = Character.toString(word.charAt(pos)) + intermed;
            if (romajiMap.containsKey(newWord)) {
                // if the value is a,i,e, o or u then we have to check the value before it
                if (newWord.equals("a") || newWord.equals("i") || newWord.equals("e") ||
                        newWord.equals("u") || newWord.equals("o") || newWord.equals("su") ||
                        newWord.equals("hi") || newWord.equals("zu")) {
                    // proceed to the next call.
                    pos--;
                    return splitHelper(word, newWord);
                } else {
                    pos--;
                    return newWord;
                }
            } else {
                // if moving the character pointer over doesn't get a valid syllable,
                // then return that intermed value.
                if (intermed.equals("a") || intermed.equals("i") || intermed.equals("e") ||
                        intermed.equals("u") || intermed.equals("o") || intermed.equals("su") ||
                        intermed.equals("hi") || intermed.equals("zu")) {
                    return intermed;
                } else {
                    pos--;
                    return splitHelper(word, newWord);
                }
            }
        } else {
            return intermed;
        }
    }
}