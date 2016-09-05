package exercises.Chapter1_3;

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

 The assignment wants to use two stacks for this. Probably also
 a good (better?) idea to implement this with a single doubly Linked List, as
 the main operations (insert and delete) can run in constant time..
 However, accessing (left(k) / right(k) ) with a LL will be slower

 Instead, will do this with Array because excercise seems to want it to?
 */
public class Exc_1_3_44_TextEditorBuffer {

    private char[] buffer = new char[3];
    private int cursor;

    public void insert(char c) {

    }

    public char delete() {

    }

    public void left(int k) {

    }

    public void right(int k) {

    }

    public int size() {

    }

    private void enlargeBuffer(int n) {

    }

    public char getCharAtCursor() {

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
    }

}
