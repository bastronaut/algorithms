package exercises.Chapter1_3;

import datastructures.CustomStackLinkedList;

/**
 * Write a program that takes from standard input an expression without left
 * parentheses and prints the equivalent inﬁx expression with the parentheses
 * inserted. For example, given the input:
 *   1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) your program should print ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 *
 * solution: add numbers and operations to a seperate stack. whenever a ")" occurs, pop a number, operation and
 * another number from the stack, and prefix it with a "(".
 *
 * Return the new prefixed expression on the stack of values as 1 value, and continue
 *
 */
public class Exc_1_3_9_InfixInsertParentheses {
    public String insertParentheses(String infixExpression) {
        CustomStackLinkedList<String> operations = new CustomStackLinkedList<>();
        CustomStackLinkedList<String> values = new CustomStackLinkedList<>();

        String[] characters = infixExpression.split(" ");

        for (String character : characters) {
            if (character.equals("*") || character.equals("/") ||
                character.equals("+") || character.equals("-")) {
                operations.push(character);
            } else if (character.equals(")")) {
                String prefixedExpression = prefixExpressionWithBracket(values.pop(), operations.pop(), values.pop());
                values.push(prefixedExpression);
            } else {
                values.push((character));
            }
        }

        String returnValue = values.pop();
        System.out.println(returnValue);
        return returnValue;
    }

    private String prefixExpressionWithBracket(String secondValue, String operator, String firstValue) {
        return "( "+ firstValue + " " + operator + " " + secondValue + " )";
    }
}
