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
        assertTrue(buffer.toString().equals("cba"));
        buffer.insert('d');
        buffer.insert('e');
        buffer.insert('f');
        buffer.insert('g');
        assertTrue(buffer.toString().equals("gfedcba"));
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
        buffer.left(2);
        buffer.delete();
        assertTrue(buffer.toString().equals("abcdeg"));
        buffer.left(4);
        buffer.delete();
        assertTrue(buffer.toString().equals("acdeg"));
        buffer.delete();
        assertTrue(buffer.toString().equals("adeg"));
        buffer.delete();
        assertTrue(buffer.toString().equals("aeg"));
        buffer.right(1);
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
        assertTrue(buffer.getCharAtCursor() == 'f');
        buffer.left(1);
        buffer.insert('X');
        buffer.insert('Y');
        assertTrue(buffer.getCharAtCursor() == 'e');
        buffer.left(1);
        assertTrue(buffer.getCharAtCursor() == 'Y');
        buffer.left(2);
        assertTrue(buffer.getCharAtCursor() == 'd');
        buffer.left(5);
        assertTrue(buffer.getCharAtCursor() == 'a');
    }

    @Test
    public void right() throws Exception {

    }

}