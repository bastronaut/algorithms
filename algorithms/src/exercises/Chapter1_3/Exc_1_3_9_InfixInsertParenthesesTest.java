package exercises.Chapter1_3;

import static junit.framework.TestCase.assertTrue;

/**
 * Write a program that takes from standard input an expression without left
 * parentheses and prints the equivalent inﬁx expression with the parentheses
 * inserted. For example, given the input:
 *   1 + 2 ) * 3 - 4 ) * 5 - 6 ) )  your program should print ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
 */
public class Exc_1_3_9_InfixInsertParenthesesTest {

    @org.junit.Test
    public void testInsertParentheses() {
        Exc_1_3_9_InfixInsertParentheses IIP = new Exc_1_3_9_InfixInsertParentheses();
        String testOneInput = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String testOneOutput = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        assertTrue(IIP.insertParentheses(testOneInput).equals(testOneOutput));

        assertTrue(IIP.insertParentheses("1 + 2 )").equals("( 1 + 2 )"));
        assertTrue(IIP.insertParentheses("3 * 4 + 2 ) )").equals("( 3 * ( 4 + 2 ) )"));
    }
}