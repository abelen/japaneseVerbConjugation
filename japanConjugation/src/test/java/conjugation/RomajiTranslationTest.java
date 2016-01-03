package conjugation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the {@link RomajiTranslation}.
 */
public class RomajiTranslationTest {

    @Test
    public void test() {
        JapanCharacters jpnChars = new JapanCharacters();

        assertEquals(RomajiTranslation.translate("yameru"), "やめる");
    }
}