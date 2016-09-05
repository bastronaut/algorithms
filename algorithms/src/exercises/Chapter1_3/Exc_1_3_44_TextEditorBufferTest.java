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
        // abcdefg
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

    }

    @Test
    public void right() throws Exception {

    }

}