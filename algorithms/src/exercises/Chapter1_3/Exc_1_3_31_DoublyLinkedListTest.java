package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bas on 2-8-2016.
 */
public class Exc_1_3_31_DoublyLinkedListTest {


    @Test
    public void testInsertAtBeginning() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(3);
        assertTrue(dll.toString().equals("3"));
        dll.insertAtBeginning(2);
        assertTrue(dll.toString().equals("23"));
        dll.insertAtBeginning(1);
        assertTrue(dll.toString().equals("123"));
        dll.insertAtEnd(1);
        assertTrue(dll.toString().equals("1231"));
        dll.insertAtBeginning(0);
        assertTrue(dll.toString().equals("01231"));
    }

    @Test
    public void testInsertAtEnd() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtEnd(3);
        assertTrue(dll.toString().equals("3"));
        dll.insertAtEnd(2);
        assertTrue(dll.toString().equals("32"));
        dll.insertAtEnd(1);
        assertTrue(dll.toString().equals("321"));
        dll.insertAtBeginning(0);
        assertTrue(dll.toString().equals("0321"));
        dll.insertAtEnd(0);
        assertTrue(dll.toString().equals("03210"));

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