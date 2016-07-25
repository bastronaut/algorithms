package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 25-07-2016.
 */
public class Exc_1_3_19_20_LinkedListDeleteTest {

    @org.junit.Test
    public void testPush() {
        Exc_1_3_19_20_LinkedListDelete<String> stacktest = new Exc_1_3_19_20_LinkedListDelete<>();
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
        Exc_1_3_19_20_LinkedListDelete<String> stacktest = new Exc_1_3_19_20_LinkedListDelete<>();
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
    public void testRemoveTopNode() {
        Exc_1_3_19_20_LinkedListDelete<String> stacktest = new Exc_1_3_19_20_LinkedListDelete<>();
        stacktest.push("hi");
        stacktest.push("how");
        stacktest.push("are");
        stacktest.push("you");
        stacktest.push("doing?");
        stacktest.removeTopNode();
        assertTrue(stacktest.pop().equals("you"));
        assertTrue(stacktest.size()== 3);
    }

    @org.junit.Test
    public void testRemoveBottomNode() {
        Exc_1_3_19_20_LinkedListDelete<String> stacktest = new Exc_1_3_19_20_LinkedListDelete<>();
        stacktest.push("hi");
        stacktest.push("how");
        stacktest.push("are");
        stacktest.push("you");
        stacktest.push("doing?");
        stacktest.removeBottomNode();
        assertTrue(stacktest.pop().equals("doing?"));
        assertTrue(stacktest.pop().equals("you"));
        assertTrue(stacktest.pop().equals("are"));
        assertTrue(stacktest.pop().equals("how"));
        assertTrue(stacktest.isEmpty());
        assertTrue(stacktest.size() == 0);
    }

    @org.junit.Test
    public void testDeleteKthElement() {
        Exc_1_3_19_20_LinkedListDelete<String> stacktest = new Exc_1_3_19_20_LinkedListDelete<>();
        stacktest.push("0");
        stacktest.push("1");
        stacktest.push("2");
        stacktest.push("3");
        stacktest.push("4");
        stacktest.push("5");
        stacktest.deleteKthElement(2);
        assertTrue(stacktest.pop().equals("5"));
        assertTrue(stacktest.pop().equals("4"));
        assertTrue(stacktest.size() == 4);
        stacktest.push("4");
        stacktest.push("5");
        stacktest.printLinkedList();
        stacktest.deleteKthElement(2);
        assertTrue(stacktest.pop().equals("5"));
        assertTrue(stacktest.pop().equals("4"));
        assertTrue(stacktest.pop().equals("1"));
    }
}