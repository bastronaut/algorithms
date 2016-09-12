package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 05-09-2016.
 */
public class Exc_1_3_44_TextEditorBufferTest {
    @Test
    public void insert() throws Exception {
        Exc_1_3_44_TextEditorBuffer buffer = new Exc_1_3_44_TextEditorBuffer();
        // gfedcba
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        assertTrue(buffer.toString().equals("abc"));
        buffer.insert('d');
        buffer.insert('e');
        buffer.insert('f');
        buffer.insert('g');
        assertTrue(buffer.toString().equals("abcdefg"));
    }

    @Test
    public void delete() throws Exception {
        Exc_1_3_44_TextEditorBuffer buffer = new Exc_1_3_44_TextEditorBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.insert('e');
        buffer.insert('f');
        buffer.insert('g');
        // start with abcdefg
        buffer.left(2);
        System.out.println(buffer.delete()); // removes 'f'. abcde|g

        assertTrue(buffer.toString().equals("abcdeg"));
        buffer.left(4);
        System.out.println(buffer.getCharAtCursor());
        buffer.delete();  // removes 'b', a|cdeg
        assertTrue(buffer.getCharAtCursor() == 'c');
        assertTrue(buffer.toString().equals("acdeg")); // removes c cursor at a|deg
        buffer.delete();
        assertTrue(buffer.toString().equals("adeg")); // a|deg
        buffer.delete();
        assertTrue(buffer.toString().equals("aeg")); // a|eg
        buffer.right(1);
        buffer.delete();
        assertTrue(buffer.toString().equals("ae"));
    }

    @Test
    public void left() throws Exception {
        Exc_1_3_44_TextEditorBuffer buffer = new Exc_1_3_44_TextEditorBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.insert('e');
        buffer.insert('f');
        buffer.insert('g');
        buffer.left(2);
        assertTrue(buffer.getCharAtCursor() == 'f'); //abcde|fg
        buffer.left(1); // abcd|efg
        buffer.insert('X'); // abcdXY|efg
        buffer.insert('Y'); // abcdXY|efg
        assertTrue(buffer.getCharAtCursor() == 'e');
        buffer.left(1); // abcdX|Yefg
        assertTrue(buffer.getCharAtCursor() == 'Y');
        buffer.left(2); // abc|dXYefg
        assertTrue(buffer.getCharAtCursor() == 'd');
        buffer.left(3);
        assertTrue(buffer.getCharAtCursor() == 'a');
    }

    @Test
    public void right() throws Exception {
        Exc_1_3_44_TextEditorBuffer buffer = new Exc_1_3_44_TextEditorBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.insert('e');
        buffer.insert('f');
        buffer.insert('g');
        assertTrue(buffer.toString().equals("abcdefg"));
        buffer.left(7); // |abcdefg
        assertTrue(buffer.getCharAtCursor() == 'a');
        buffer.right(1); // a|bcdefg
        assertTrue(buffer.getCharAtCursor() == 'b');
        buffer.right(2); // abc|defg
        System.out.println(buffer.getCharAtCursor());
        assertTrue(buffer.getCharAtCursor() == 'd');
        buffer.right(3); // abcdef|g
        assertTrue(buffer.getCharAtCursor() == 'g');

    }

}