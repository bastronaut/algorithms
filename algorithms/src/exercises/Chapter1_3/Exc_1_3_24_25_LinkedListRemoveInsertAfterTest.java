package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 *
 */
public class Exc_1_3_24_25_LinkedListRemoveInsertAfterTest {

    @org.junit.Test
    public void testPush() {
        Exc_1_3_24_25_LinkedListRemoveInsertAfter<String> stacktest = new Exc_1_3_24_25_LinkedListRemoveInsertAfter<>();
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

    @org.junit.Test
    public void testPop() {
        Exc_1_3_24_25_LinkedListRemoveInsertAfter<String> stacktest = new Exc_1_3_24_25_LinkedListRemoveInsertAfter<>();
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


    @org.junit.Test
    public void testRemoveAfter() {
        Exc_1_3_24_25_LinkedListRemoveInsertAfter<String> stacktest = new Exc_1_3_24_25_LinkedListRemoveInsertAfter<>();
        stacktest.push("1");
        stacktest.push("2");
        stacktest.push("3");
        stacktest.push("4");
        stacktest.push("5");
    }
}