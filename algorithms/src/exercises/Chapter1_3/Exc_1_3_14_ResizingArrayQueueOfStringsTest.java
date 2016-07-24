package exercises.Chapter1_3;

import algorithms.CustomQueueLinkedList;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 *   Develop a class ResizingArrayQueueOfStrings that implements the queue
 *   abstraction with a ﬁxed-size array, and then extend your implementation
 *   to use array resizing to remove the size restriction.
 */
public class Exc_1_3_14_ResizingArrayQueueOfStringsTest {
    @org.junit.Test
    public void testEnqueue() {
        Exc_1_3_14_ResizingArrayQueueOfStrings stacktest = new Exc_1_3_14_ResizingArrayQueueOfStrings();
        assertTrue(stacktest.size() == 0);
        stacktest.enqueue("hi");
        stacktest.enqueue("there");
        stacktest.enqueue("how");
        assertTrue(stacktest.size() == 3);
        stacktest.enqueue("are");
        stacktest.enqueue("you");
        assertTrue(stacktest.size() == 5);
        stacktest.dequeue();
        assertTrue(stacktest.size() == 4);
        stacktest.dequeue();
        stacktest.dequeue();
        stacktest.enqueue("test");
        assertTrue(stacktest.size() == 3);
    }

    @org.junit.Test
    public void testDequeue() {
        Exc_1_3_14_ResizingArrayQueueOfStrings stacktest = new Exc_1_3_14_ResizingArrayQueueOfStrings();
        stacktest.enqueue("hi");
        assertTrue(stacktest.dequeue().equals("hi"));
        assertTrue(stacktest.size() == 0);
        stacktest.enqueue("hi");
        stacktest.enqueue("how");
        stacktest.enqueue("are");
        assertTrue(stacktest.dequeue().equals("hi"));
        assertTrue(stacktest.size() == 2);
        assertTrue(stacktest.dequeue().equals("how"));
        assertTrue(stacktest.size() == 1);
        assertFalse(stacktest.isEmpty());
        assertTrue(stacktest.dequeue().equals("are"));
        assertTrue(stacktest.size() == 0);
        assertTrue(stacktest.isEmpty());
        stacktest.enqueue("hi");
        stacktest.enqueue("how");
        stacktest.enqueue("are");
        stacktest.enqueue("you");
        stacktest.enqueue("im");
        stacktest.enqueue("doing");
        stacktest.enqueue("ok");
        stacktest.enqueue("thanks");
        stacktest.enqueue("you?");
        assertTrue(stacktest.size() == 9);
        assertTrue(stacktest.dequeue().equals("hi"));
    }

    @org.junit.Test(expected = EmptyStackException.class)
    public void testEmptyStack() {
        Exc_1_3_14_ResizingArrayQueueOfStrings stacktest = new Exc_1_3_14_ResizingArrayQueueOfStrings();
        stacktest.dequeue();
        stacktest.enqueue("hi");
        stacktest.dequeue();
        stacktest.dequeue();
    }

    @org.junit.Test
    public void testForEach() {
        Exc_1_3_14_ResizingArrayQueueOfStrings queue = new Exc_1_3_14_ResizingArrayQueueOfStrings();
        queue.enqueue("hi");
        queue.enqueue("how");
        queue.enqueue("are");

        String[] queueItems = new String[3];
        int i = 0;

        for (Object item : queue) {
            queueItems[i] = (String) item;
            System.out.println(item);
            i++; // hacky to test the foreach
        }
        assertTrue(queueItems[0].equals("hi"));
        assertTrue(queueItems[1].equals("how"));
        assertTrue(queueItems[2].equals("are"));
    }
}