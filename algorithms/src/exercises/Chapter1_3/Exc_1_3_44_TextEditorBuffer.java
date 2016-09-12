package exercises.Chapter1_3;

import algorithms.CustomStackArray;

/**
 1.3.44 Text editor buffer. Develop a data type for a buffer in a text
 editor that implements the following API:

 public class Buffer
 Buffer() create an empty buffer
 void insert(char c) insert c at the cursor position
 char delete() delete and return the character at the cursor
 void left(int k) move the cursor k positions to the left
 void right(int k) move the cursor k positions to the right
 int size() number of characters in the buffer
 API for a text buffer

 Two stacks will be good for this: when you move the cursor left, pop it from the first stack
 and push it onto the second. When you move right, you pop it from the second stack, and push
 it back onto the first!

 When you want to insert, we simply push on top of the first stack. To get the char at cursor,
 we pop from the stack, get the item, push it back onto the stack, and return the item.



 */
public class Exc_1_3_44_TextEditorBuffer {

    private CustomStackArray<Character> firstStack = new CustomStackArray<>(3); // arbitrary initial size
    private CustomStackArray<Character> secondStack = new CustomStackArray<>(3);


    public void insert(char c) {
        firstStack.push(c);
    }

    // the deletion will work as a backspace?
    public char delete()  {
        return firstStack.pop();
    }


    public void left(int k) {
        for (int i = 0; i < k; i++) {
            secondStack.push(firstStack.pop());
        }
    }

    // if k is larger than the remaining items to the right of it, .. what to do
    public void right(int k) {
        firstStack.push(secondStack.pop());
    }

    public int size() {
        return firstStack.size() + secondStack.size();
    }

    public char getCharAtCursor() {
        char returnChar = firstStack.pop();
        firstStack.push(returnChar);
        return returnChar;
    }

    // although we're using a stack, the buffer should print
    // in FIFO order, as if its a text editor. The firstStack
    // is in LIFO order, so uses a temp stack to reverse it.
    public String toString() {
        CustomStackArray<Character> tempStack = new CustomStackArray<>(3); // arbitrary initial size
        StringBuilder sb = new StringBuilder();
        for (char c : firstStack) {
            tempStack.push(c);
        }
        for (char d : tempStack) {
            sb.append(d);
        }
        for (char e : secondStack) {
            sb.append(e);
        }

        return sb.toString();
    }

}
