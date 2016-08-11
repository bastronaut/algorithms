package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 11-08-2016.
 */
public class Exc_1_3_30_ReverseLinkedListTest {
    @org.junit.Test
    public void testEnqueue() {
        Exc_1_3_30_ReverseLinkedList<String> queue = new Exc_1_3_30_ReverseLinkedList<>();
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
        Exc_1_3_30_ReverseLinkedList<String> queue = new Exc_1_3_30_ReverseLinkedList<>();
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
        Exc_1_3_30_ReverseLinkedList<Integer> queue = new Exc_1_3_30_ReverseLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Exc_1_3_30_ReverseLinkedList.Node frontNode = queue.getFrontNode();
        queue.reverseLinkedList(frontNode);
        System.out.println(queue);
        assertTrue(queue.toString().equals("54321"));
        assertTrue(queue.dequeue() == 5);
        assertTrue(queue.toString().equals("4321"));
        queue.reverseLinkedList(frontNode);
        assertTrue(queue.toString().equals("1234"));
        queue.dequeue();
        queue.dequeue();
        frontNode = queue.getFrontNode();
        queue.reverseLinkedList(frontNode);
        assertTrue(queue.toString().equals("43"));
        queue.dequeue();
        frontNode = queue.getFrontNode();
        queue.reverseLinkedList(frontNode);
        assertTrue(queue.toString().equals("3"));


    }
}