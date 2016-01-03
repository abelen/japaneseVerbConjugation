package conjugation;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that is used in able to translate from romaji to the proper japanese.
 */
public class RomajiTranslation {

    private static Map<String, String> romajiMap = new HashMap<String, String>();


    static {
        populateMap();
    }

    /**
     * Translates the romaji into its Japanese equivalent.
     *
     * @return The Japanese translation.
     */
    public static String translate(String word) {
        return null;
    }

    /**
     * Translates the romaji into its Japanese equivalent.
     * This is compatible with Hepburn or Kunrei-shiki romaji.
     *
     * @return The string has its Japanese equivalent.
     */
    private static void populateMap() {
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
        romajiMap.put("kuru", "くる");
        romajiMap.put("suru", "する");
    }

    /**
     * Finds the ending of the word.
     */
    private String findEnding(String word, int pos, String intermed) {

        // if it's a suru verb.
        if (word.contains("suru")) {
            return "する";
        }

        // if it's kuru.
        if (word.equals("kuru")) {
            return "くる";
        }

        // a possible recursive solution.
        String newIntermed = Character.toString(word.charAt(pos)) + intermed;
        if (newIntermed.equals("tu")) {
            return "つ";
        }

        if (newIntermed.equals("ru")) {
            return "る";
        }

        if (newIntermed.equals("ru")) {

            // check to see if it's a ru verb.

            return "る";
        }

        if (newIntermed.equals("ku")) {
            return "く";
        }

        if (newIntermed.equals("gu")) {
            return "ぐ";
        }

        return "";

    }

    private static boolean checkRuVerb(String word, String intermed, int pos) {
        return false;
    }
}