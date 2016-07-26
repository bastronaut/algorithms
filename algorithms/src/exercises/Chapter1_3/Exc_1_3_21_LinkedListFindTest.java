package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 26-07-2016.
 */
public class Exc_1_3_21_LinkedListFindTest {

    @Test
    public void push() throws Exception {

        Exc_1_3_21_LinkedListFind<String> stacktest = new Exc_1_3_21_LinkedListFind<>();
        assertTrue(stacktest.size() == 0);
        stacktest.push("hi");
        stacktest.push("there");
        stacktest.push("how");
        assertTrue(stacktest.size() == 3);
        stacktest.push("are");
        stacktest.push("you");
        assertTrue(stacktest.size() == 5);
        stacktest.pop();
        assertTrue(stacktest.size() == 4);
        stacktest.pop();
        stacktest.pop();
        stacktest.push("test");
        assertTrue(stacktest.size() == 3);
    }

    @Test
    public void pop() throws Exception {
        Exc_1_3_21_LinkedListFind<String> stacktest = new Exc_1_3_21_LinkedListFind<>();
        stacktest.push("hi");
        assertTrue(stacktest.pop() == "hi");
        assertTrue(stacktest.size() == 0);
        stacktest.push("hi");
        stacktest.push("how");
        stacktest.push("are");
        assertTrue(stacktest.pop() == "are");
        assertTrue(stacktest.size() == 2);
        assertTrue(stacktest.pop() == "how");
        assertTrue(stacktest.size() == 1);
        assertFalse(stacktest.isEmpty());
        assertTrue(stacktest.pop() == "hi");
        assertTrue(stacktest.size() == 0);
        assertTrue(stacktest.isEmpty());
    }

    @Test
    public void find() throws Exception {
        Exc_1_3_21_LinkedListFind<String> stacktest = new Exc_1_3_21_LinkedListFind<>();
        stacktest.push("0");
        stacktest.push("1");
        stacktest.push("2");
        stacktest.push("3");
        stacktest.push("4");
        stacktest.push("5");
        assertTrue(stacktest.find(stacktest, "3"));
        assertTrue(stacktest.find(stacktest, "1"));
        assertTrue(stacktest.find(stacktest, "0"));
        assertTrue(stacktest.find(stacktest, "5"));
        assertFalse(stacktest.find(stacktest, "99999"));
        assertFalse(stacktest.find(stacktest, "9"));
        assertFalse(stacktest.find(stacktest, "hjhgjhk"));
    }

}