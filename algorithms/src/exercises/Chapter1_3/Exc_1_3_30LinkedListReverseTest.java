package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 01-08-2016.
 */
public class Exc_1_3_30LinkedListReverseTest {

    @org.junit.Test
    public void testEnqueue() {
        Exc_1_3_30LinkedListReverse<String> queue = new Exc_1_3_30LinkedListReverse<>();
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
        Exc_1_3_30LinkedListReverse<String> queue = new Exc_1_3_30LinkedListReverse<>();
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
    public void testReverseLinkedList() {
        Exc_1_3_30LinkedListReverse<Integer> queue = new Exc_1_3_30LinkedListReverse<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.reverseLinkedList();
        System.out.println(queue.printLinkedList());
        assertTrue(queue.printLinkedList().equals("54321"));
        assertTrue(queue.dequeue() == 5);
        assertTrue(queue.printLinkedList().equals("4321"));
        queue.reverseLinkedList();
        assertTrue(queue.printLinkedList().equals("1234"));

    }

}