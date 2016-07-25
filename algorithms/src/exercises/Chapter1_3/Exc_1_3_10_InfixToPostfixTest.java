package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * Write a ﬁlter InfixToPostfix that converts an arithmetic expression from inﬁx to postﬁx.
 *
 * input: ( ( A * ( B + C ) ) / D )
 * output: ( (A ( B C +) *) D / )
 *
 * what happens: 2 stacks, one with values and one with operands
 * - go through each character. Put values on values stack and operands on operands stack
 * - when a ")" occurs:
 *  - build a new string. pop 2 values and an operand from stack
 *  - Place 2 values in FIFO order in string
 *  - Place operand at the end
 *  - Add brackets ( ) to the expression
 *  - Put the expression on the values stack, and continue
 *
 */
public class Exc_1_3_10_InfixToPostfixTest {

    @org.junit.Test
    public void testInfixToPostFix() {
        Exc_1_3_10_InfixToPostfix itpf = new Exc_1_3_10_InfixToPostfix();
        System.out.println(itpf.infixToPostfix("( ( A * ( B + C ) ) / D )"));
        assertTrue(itpf.infixToPostfix("( ( A * ( B + C ) ) / D )").equals("( ( A ( B C + ) * ) D / )"));
        assertTrue(itpf.infixToPostfix("( A + B )").equals("( A B + )"));
    }

}