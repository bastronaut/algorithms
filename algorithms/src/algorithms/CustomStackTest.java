package algorithms;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Implementation of a generic stack with a Linked List data structure
 * api is as follows:
 * push(): add to top of stack
 * pop() : remove from top of stack
 * isEmpty(): check if theres things in the stack
 * size(): return the number of items on the stack
 */

public class CustomStackTest {

    public void testPush() {
        CustomStack<String> stacktest = new CustomStack<>();
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
        assertTrue(stacktest.size() == 4);
    }

    @org.junit.Test
    public void testPop() {
        CustomStack<String> stacktest = new CustomStack<>();
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
        assertTrue(stacktest.pop().equals(new EmptyStackException()));
    }


}