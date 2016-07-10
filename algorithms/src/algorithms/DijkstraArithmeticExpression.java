package algorithms;

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
        String[] splitstring = s.split("");
        for (String spl : splitstring) {

        }
        return 1.0;
    }

}
