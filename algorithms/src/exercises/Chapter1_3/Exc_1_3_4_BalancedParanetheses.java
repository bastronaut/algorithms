package exercises.Chapter1_3;

import algorithms.CustomStackLinkedList;
/**
 1.3.4 Write a stack client Parentheses that reads in a text stream
 from standard input and uses a stack to determine whether its
 parentheses are properly balanced. For example, your program
 should print true for [()]{}{[()()]()} and false for [(])
 */
public class Exc_1_3_4_BalancedParanetheses {
    final String ALLOWEDCHARS = "({[]})";

    public boolean isBalanced(String parantheses) {
        CustomStackLinkedList<String> stack = new CustomStackLinkedList();
        String[] parenthesesSplit = parantheses.split("");

        for (String character : parenthesesSplit) {

            // ignore non bracket characters
            if (!ALLOWEDCHARS.contains(character)) {
                continue;
            }

            if (character.equals("}")) {
                if (!stack.pop().equals("{")) {
                    return false;
                }

            } else if (character.equals(")")){
                if (!stack.pop().equals("(")) {
                    return false;
                }

            } else if (character.equals("]")) {
                if (!stack.pop().equals("[")) {
                return false;
                }

            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }
}
