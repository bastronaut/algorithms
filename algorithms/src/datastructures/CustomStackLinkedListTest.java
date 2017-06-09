package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Implementation of a generic stack with a Linked List data structure
 * api is as follows:
 * push(): add to top of stack
 * pop() : remove from top of stack
 * isEmpty(): check if theres things in the stack
 * size(): return the number of items on the stack
 */

public class CustomStackLinkedListTest {

    @org.junit.Test
    public void testPush() {
        CustomStackLinkedList<String> stacktest = new CustomStackLinkedList<>();
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
        CustomStackLinkedList<String> stacktest = new CustomStackLinkedList<>();
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
        assertTrue(stacktest.pop() == "hi");
        assertTrue(stacktest.size() == 0);
    }

    @Test
    public void testForEach() {
        CustomStackLinkedList<String> stack = new CustomStackLinkedList<>();
        stack.push("hi");
        stack.push("how");
        stack.push("are");

        String[] queueItems = new String[3];
        int i = 0;

        for (Object item : stack) {
            queueItems[i] = (String) item;
            System.out.println(item);
            i++; // hacky to test the foreach
        }
        assertTrue("test queueitem = are", queueItems[0] == "are");
        assertTrue("test queueitem = how", queueItems[1] == "how");
        assertTrue("test queueitem = hi", queueItems[2] == "hi");

        stack.pop();
        stack.pop();


        String[] emptyQueueItems = new String[1];
        i = 0;

        for (Object item : stack) {
            emptyQueueItems[i] = (String) item;
            i++; // hacky to test the foreach
        }

        assertTrue(emptyQueueItems[0] == "hi");

    }

}