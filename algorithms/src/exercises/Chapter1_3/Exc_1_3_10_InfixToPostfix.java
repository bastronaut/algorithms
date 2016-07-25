package exercises.Chapter1_3;

import algorithms.CustomStackLinkedList;

/**
 * Write a ﬁlter InfixToPostfix that converts an arithmetic expression from inﬁx to postﬁx.
 *
 * input: ( ( A * ( B + C ) ) / D )
 * output: ( (A ( B C +) *) D /)
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
public class Exc_1_3_10_InfixToPostfix {


    public String infixToPostfix(String infixExpression) {
        CustomStackLinkedList<String> values = new CustomStackLinkedList<>();
        CustomStackLinkedList<String> operands = new CustomStackLinkedList<>();

        String[] splitInfixExpression = infixExpression.split(" ");

        for (String character : splitInfixExpression) {
            if (character.equals("+") || character.equals("-") || character.equals("*") ||
                    character.equals("/")) {
                operands.push(character);
            } else if (character.equals(")")) {
                String secondValue = values.pop();
                String firstValue = values.pop();
                String operand = operands.pop();
                String tempExpression = "( " + firstValue + " " + secondValue + " " + operand + " )";
                values.push(tempExpression);
            } else if(character.equals("(")) { }
            else { values.push(character); }
        }
        return values.pop();
    }

}
