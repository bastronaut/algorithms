package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * TODO: check if you can instantiate another class' inner class
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
    public void testRemoveAfter() throws NullPointerException {
        Exc_1_3_24_25_LinkedListRemoveInsertAfter<String> stacktest = new Exc_1_3_24_25_LinkedListRemoveInsertAfter<>();
        stacktest.push("1");
        stacktest.push("2");
        stacktest.push("3");
        stacktest.push("4");
        stacktest.push("5");
        // remove node after "3", which is "2";
        Exc_1_3_24_25_LinkedListRemoveInsertAfter.Node thirdNode = stacktest.find("3");
        stacktest.removeAfter(thirdNode);
        assertTrue(stacktest.size() == 4);
        assertTrue(stacktest.pop() == "5");
        assertTrue(stacktest.pop() == "4");
        assertTrue(stacktest.pop() == "3");
        assertTrue(stacktest.pop() == "1");
        stacktest.push("1");
        stacktest.push("2");
        stacktest.push("3");
        stacktest.push("4");
        stacktest.push("5");
        Exc_1_3_24_25_LinkedListRemoveInsertAfter.Node fifthNode = stacktest.find("5");
        stacktest.removeAfter(fifthNode);
        assertTrue(stacktest.pop() == "5");
        assertTrue(stacktest.pop() == "3");
    }

    @org.junit.Test
    public void testInsertAfter() throws NullPointerException {
        Exc_1_3_24_25_LinkedListRemoveInsertAfter<String> stacktest = new Exc_1_3_24_25_LinkedListRemoveInsertAfter<>();
        stacktest.push("1");
        stacktest.push("2");
        stacktest.push("3");
        stacktest.push("4");
        stacktest.push("5");
        Exc_1_3_24_25_LinkedListRemoveInsertAfter.Node thirdNode = stacktest.find("3");
        Exc_1_3_24_25_LinkedListRemoveInsertAfter.Node fourthNode = stacktest.find("4");
        stacktest.removeAfter(fourthNode);
        stacktest.insertAfter(fourthNode, thirdNode);
        assertTrue(stacktest.pop().equals("5"));
        assertTrue(stacktest.pop().equals("4"));
        assertTrue(stacktest.pop().equals("3"));
    }
}