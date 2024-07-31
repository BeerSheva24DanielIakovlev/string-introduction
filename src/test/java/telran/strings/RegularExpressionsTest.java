package telran.strings;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import static telran.strings.Strings.*;

public class RegularExpressionsTest {
    @Test
    void javaVariableTest() {
        String[] trueStrings = {"VasFm$", "a99999", "$$$", "Testing"};
        String[] falseStrings = {"9ujk", "", "@#$%^&*", "KNU9**", "boolean", "_"};
        String regex = javaVariable();
        for (int i = 0; i < trueStrings.length; i++) {
            assertTrue(trueStrings[i].matches(regex));
        }

        for (int i = 0; i < falseStrings.length; i++) {
            assertFalse(falseStrings[i].matches(regex));
        }
    } 
    @Test
    void number0_300TrueTest() {
        String regex = Strings.number0_300();
        assertTrue("0".matches(regex));
        assertTrue("300".matches(regex));
        assertTrue("250".matches(regex));
        assertTrue("25".matches(regex));
        assertTrue("12".matches(regex));
        assertTrue("299".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("69".matches(regex));
    }
    @Test
    void number0_300FalseTest() {
        String regex = Strings.number0_300();
        assertFalse("00".matches(regex));
        assertFalse("301".matches(regex));
        assertFalse("01".matches(regex));
        assertFalse("000".matches(regex));
        assertFalse("1(".matches(regex));
        assertFalse("1000".matches(regex));
        assertFalse(" 20".matches(regex));
        assertFalse("1001".matches(regex));
        assertFalse("069".matches(regex));
    }
    @Test
    void ipV40ctetTrueTest() {
        String regex = Strings.ipV40ctet();
        assertTrue("0".matches(regex));
        assertTrue("00".matches(regex));
        assertTrue("000".matches(regex));
        assertTrue("10".matches(regex));
        assertTrue("100".matches(regex));
        assertTrue("255".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("249".matches(regex));
    }
    @Test
    void ipV40ctetFalseTest() {
        String regex = Strings.ipV40ctet();
        assertFalse("0000".matches(regex));
        assertFalse("t".matches(regex));
        assertFalse("-1".matches(regex));
        assertFalse("1111".matches(regex));
        assertFalse("0001".matches(regex));
        assertFalse("256".matches(regex));
        assertFalse("300".matches(regex));
        assertFalse("*".matches(regex));
        assertFalse("1 ".matches(regex));
    }
    @Test
    void ipV4AdressTrueTest() {
        String regex = Strings.ipV4Adress();
        assertTrue("0.0.0.0".matches(regex));
        assertTrue("255.255.255.255".matches(regex));
    }
    @Test
    void ipV4AdressFalseTest() {
        String regex = Strings.ipV4Adress();
        assertFalse("300.300.300.300".matches(regex));
        assertFalse("1565.255.255.255".matches(regex));
        assertFalse("0.0.0".matches(regex));
        assertFalse("0.0.0+0".matches(regex));
        assertFalse("0".matches(regex));
        assertFalse("0.-".matches(regex));
        assertFalse("0.0.0 0".matches(regex));
        assertFalse("0.0.0*0".matches(regex));
    }
    @Test
    void stringWithJavaNamesTest() {
        String names = "123 1a _ abs int enum null lmn";
        String expected = "abs lmn";
        assertEquals(expected, Strings.stringWithJavaNames(names));
    }
    @Test
    void TokensTest() {
        String names = "ASDadAD) * + -==(564564+=";
        String[] expected = {"ASDadAD", "564564"};
        String[] result = Strings.stringWithTokens(names);
        assertArrayEquals(expected, result);
    }
    @Test
    void bracketsTest() {
        String[] TrueStr = {"()", "(())", "()()"};
        String[] FalseStr = {"ASDadAD) * + -==(564564+=", "())", "()("};
        for (String str : TrueStr) {
            assertTrue(Strings.brackets(str));
        }

        for (String str : FalseStr) {
            assertFalse(Strings.brackets(str));
        }
        
    }
    @Test
    void isArithmeticExpressionTest() {
        String[] TrueAri = {"(play+1)*6", "12/6+perebor", "(sol+10)*(12-qwErty$)"};
        String[] FalseAri = {"ASDadAD) * + -==(564564+=", "())", "()("};
        for (String str : TrueAri) {
            assertTrue(Strings.isArithmeticExpression(str));
        }

        for (String str : FalseAri) {
            assertFalse(Strings.isArithmeticExpression(str));
        }
    }
}
