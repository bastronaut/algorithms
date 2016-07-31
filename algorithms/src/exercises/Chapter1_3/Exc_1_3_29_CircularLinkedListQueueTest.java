package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * Created by Bas on 31-7-2016.
 */
public class Exc_1_3_29_CircularLinkedListQueueTest {

    @org.junit.Test
    public void testEnqueue() {
        Exc_1_3_29_CircularLinkedListQueue<String> queue = new Exc_1_3_29_CircularLinkedListQueue<>();
        assertTrue(queue.size() == 0);
        queue.enqueue("hi");
        queue.enqueue("there");
        queue.enqueue("how");
        assertTrue(queue.size() == 3);
        queue.enqueue("are");
        queue.enqueue("you");
        assertTrue(queue.printLinkedList().equals("hi; there; how; are; you; "));

        assertTrue(queue.size() == 5);
        queue.dequeue();
        assertTrue(queue.size() == 4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("test");
        assertTrue(queue.size() == 3);
        assertTrue(queue.printLinkedList().equals("are; you; test; "));
    }

    @org.junit.Test
    public void testDequeue() {
        Exc_1_3_29_CircularLinkedListQueue<String> queue = new Exc_1_3_29_CircularLinkedListQueue<>();
        queue.enqueue("hi");
        assertTrue(queue.dequeue() == "hi");
        assertTrue(queue.size() == 0);
        queue.enqueue("hi");
        queue.enqueue("how");
        queue.enqueue("are");
        assertTrue(queue.dequeue().equals("hi"));
        assertTrue(queue.printLinkedList().equals("how; are; "));
        assertTrue(queue.size() == 2);
        assertTrue(queue.dequeue() == "how");
        assertTrue(queue.size() == 1);
        assertFalse(queue.isEmpty());
        assertTrue(queue.dequeue() == "are");
        assertTrue(queue.size() == 0);
        assertTrue(queue.isEmpty());
    }

}