package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * Created by Bas on 31-7-2016.
 */
public class Exc_1_3_27LinkedListMaxQueueTest {

    @org.junit.Test
    public void testEnqueue() {
        Exc_1_3_27LinkedListMaxQueue<String> queue = new Exc_1_3_27LinkedListMaxQueue<>();
        assertTrue(queue.size() == 0);
        queue.enqueue("hi");
        queue.enqueue("there");
        queue.enqueue("how");
        assertTrue(queue.size() == 3);
        queue.enqueue("are");
        queue.enqueue("you");
        assertTrue(queue.size() == 5);
        queue.dequeue();
        assertTrue(queue.size() == 4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("test");
        assertTrue(queue.size() == 3);
    }

    @org.junit.Test
    public void testDequeue() {
        Exc_1_3_27LinkedListMaxQueue<String> queue = new Exc_1_3_27LinkedListMaxQueue<>();
        queue.enqueue("hi");
        assertTrue(queue.dequeue() == "hi");
        assertTrue(queue.size() == 0);
        queue.enqueue("hi");
        queue.enqueue("how");
        queue.enqueue("are");
        assertTrue(queue.dequeue().equals("hi"));
        assertTrue(queue.size() == 2);
        assertTrue(queue.dequeue() == "how");
        assertTrue(queue.size() == 1);
        assertFalse(queue.isEmpty());
        assertTrue(queue.dequeue() == "are");
        assertTrue(queue.size() == 0);
        assertTrue(queue.isEmpty());
    }

    @org.junit.Test
    public void testMax() {
        Exc_1_3_27LinkedListMaxQueue<Integer> queue = new Exc_1_3_27LinkedListMaxQueue<>();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        assertTrue(queue.max() == 8);
        queue.enqueue(9);
        assertTrue(queue.max() == 9);
        queue.enqueue(2);
        assertTrue(queue.max() == 9);
        queue.enqueue(200);
        assertTrue(queue.max() == 200);
    }
}