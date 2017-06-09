package algorithms;

import datastructures.CustomStackLinkedList;

/**
 * Implementation of Dijkstra's algorithm that can compute arithmetic expressions
 * using the 'preference' rules. Solve e.g. ( 1 + ( ( 2 + 3) * (4 * 5) ) ) to 101
 * Uses two stacks: one stack to keep operators, one stack to keep operands.
 * The process works as follows:
 * Go trough a string char by char
 * Push operators into the operator stack
 * push operands into the operands stack
 * if character is "(", ignore it
 * if character is ")", pop the requisite number from the stack, pop an operator,
 * apply the operation and push it back on the stack
 */
public class DijkstraArithmeticExpression {

    public double calculate(String s) {
        String[] splitstring = s.split(" ");

        CustomStackLinkedList<Double> values = new CustomStackLinkedList<>();
        CustomStackLinkedList<String> operations = new CustomStackLinkedList<>();

        for (String character : splitstring) {
            if (character.equals("(")) ;
            else if (character.equals("+") || character.equals("/") || character.equals("-") ||
                     character.equals("*")) {
                operations.push(character);
            }
            else if (character.equals(")")) {
                double result = performCalculation(values.pop(), operations.pop(), values.pop());
                values.push(result);
            } else {
                values.push(Double.parseDouble(character)); // too lazy to error catch
            }
        }
        double result = values.pop();
        System.out.println(result);
        return result;
    }

    private double performCalculation(Double secondvalue, String operation, Double firstvalue) {
        if (operation.equals("+")) return firstvalue + secondvalue;
        else if (operation.equals("-")) return firstvalue - secondvalue;
        else if (operation.equals("/")) return firstvalue / secondvalue;
        else if (operation.equals("*")) return firstvalue * secondvalue;
        else {
            return 0; // invalid operation for this example -- does not compute
        }
    }



}
