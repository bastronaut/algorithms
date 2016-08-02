package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bas on 2-8-2016.
 */
public class Exc_1_3_31_DoublyLinkedListTest {

    @Test
    public void testEnqueue() {
        Exc_1_3_31_DoublyLinkedList<String> queue = new Exc_1_3_31_DoublyLinkedList<>();
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

    @Test
    public void testDequeue() {
        Exc_1_3_31_DoublyLinkedList<String> queue = new Exc_1_3_31_DoublyLinkedList<>();
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

    @Test
    public void testInsertAtBeginning() throws Exception {

    }

    @Test
    public void testInsertAtEnd() throws Exception {

    }

    @Test
    public void testRemoveAtBeginning() throws Exception {

    }

    @Test
    public void testRemoveAtEnd() throws Exception {

    }

    @Test
    public void testRemoveNode() throws Exception {

    }
}