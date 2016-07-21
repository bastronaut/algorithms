package exercises;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 21-07-2016.
 */
public class Exc_1_3_4_BalancedParanethesesTest {

    @Test
    public void testPositiveIsBalanced() {
        Exc_1_3_4_BalancedParanetheses BP = new Exc_1_3_4_BalancedParanetheses();
        assertTrue(BP.isBalanced("[()]{}{[()()]()}"));
        assertTrue(BP.isBalanced("{({})}[]"));
        assertTrue(BP.isBalanced("()(){}[[]]"));
        assertTrue(BP.isBalanced("(AAAvas)(fdgfd){3424asd}[[3]21]"));
    }

    @org.junit.Test
    public void testNegativeIsBalanced() {
        Exc_1_3_4_BalancedParanetheses BP = new Exc_1_3_4_BalancedParanetheses();
        assertFalse(BP.isBalanced("[(])"));
        assertFalse(BP.isBalanced("{[{{)"));
        assertFalse(BP.isBalanced("{}[]{"));
        assertFalse(BP.isBalanced("[{{]}}"));
        assertFalse(BP.isBalanced("{{]["));
    }
}
