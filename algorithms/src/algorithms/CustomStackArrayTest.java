package algorithms;

import java.util.EmptyStackException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Implementation of a generic stack with a Linked List data structure
 * api is as follows:
 * push(): add to top of stack
 * pop() : remove from top of stack
 * isEmpty(): check if theres things in the stack
 * size(): return the number of items on the stack
 */

public class CustomStackArrayTest {

    @org.junit.Test
    public void testPush() {
        CustomStackArray<String> stacktest = new CustomStackArray<>(5);
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
        CustomStackArray<String> stacktest = new CustomStackArray<>(5);
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

    @org.junit.Test(expected = EmptyStackException.class)
    public void testEmptyStack() {
        CustomStackArray<String> stacktest = new CustomStackArray<>(5);
        stacktest.pop();
    }


}