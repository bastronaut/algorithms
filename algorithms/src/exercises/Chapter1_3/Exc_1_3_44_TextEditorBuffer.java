package exercises.Chapter1_3;

import algorithms.CustomStackArray;

import java.util.EmptyStackException;

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

    private CustomStackArray<Character> firstBuffer = new CustomStackArray<>(3); // arbitrary initial size
    private CustomStackArray<Character> secondBuffer = new CustomStackArray<>(3);


    public void insert(char c) {
        firstBuffer.push(c);
    }

    // think about the deletion when the stack is empty..
    // exception will be thrown, TODO: handle exception
    public char delete()  {
        return firstBuffer.pop();
    }


    public void left(int k) {
        secondBuffer.push(firstBuffer.pop());
    }

    // if k is larger than the remaining items to the right of it, .. what to do
    public void right(int k) {
        firstBuffer.push(secondBuffer.pop());
    }

    public int size() {
        return firstBuffer.size() + secondBuffer.size();
    }

    public char getCharAtCursor() {
        char returnChar = firstBuffer.pop();
        firstBuffer.push(returnChar);
        return returnChar;
    }

    // the stack is printed in LIFO order
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char c : firstBuffer) {
            sb.append(c);
        }
        for (char d : secondBuffer) {
            sb.append(d);
        }
        return sb.toString();
    }

}
