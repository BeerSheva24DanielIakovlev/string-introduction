package telran.strings;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import static telran.strings.Strings.*;

public class RegularExpressionsTest {
    @Test
    void javaVariableTest() {
        String[] trueStrings = {"VasFm$", "a99999", "$$$", "Testing"};
        String[] falseStrings = {"9ujk", "", "@#$%^&*", "KNU9**", "boolean"};
        String regex = javaVariable();
        for (int i = 0; i < trueStrings.length; i++) {
            assertTrue(trueStrings[i].matches(regex));
        }

        for (int i = 0; i < falseStrings.length; i++) {
            assertFalse(falseStrings[i].matches(regex));
        }
    } 


}
