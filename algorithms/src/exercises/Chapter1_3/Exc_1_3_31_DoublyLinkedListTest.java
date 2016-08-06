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
        assertTrue(dll.size() == 1);
        dll.insertAtBeginning(2);
        assertTrue(dll.toString().equals("23"));
        dll.insertAtBeginning(1);
        assertTrue(dll.toString().equals("123"));
        dll.insertAtEnd(1);
        assertTrue(dll.toString().equals("1231"));
        dll.insertAtBeginning(0);
        assertTrue(dll.toString().equals("01231"));
        assertTrue(dll.size() == 5);
    }

    @Test
    public void testInsertAtEnd() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtEnd(3);
        assertTrue(dll.toString().equals("3"));
        assertTrue(dll.size() == 1);
        dll.insertAtEnd(2);
        assertTrue(dll.toString().equals("32"));
        dll.insertAtEnd(1);
        assertTrue(dll.toString().equals("321"));
        dll.insertAtBeginning(0);
        assertTrue(dll.toString().equals("0321"));
        dll.insertAtEnd(0);
        assertTrue(dll.toString().equals("03210"));
        assertTrue(dll.size() == 5);

    }

    @Test
    public void testRemoveAtBeginning() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(3);
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);
        assertTrue(dll.toString().equals("123"));
        assertTrue(dll.removeAtBeginning() == 1);
        assertTrue(dll.toString().equals("23"));
        assertTrue(dll.removeAtBeginning()== 2);
        assertTrue(dll.toString().equals("3"));
    }

    @Test
    public void testRemoveAtEnd() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(3);
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);
        dll.insertAtEnd(4);
        assertTrue(dll.removeAtEnd() == 4);
        assertTrue(dll.toString().equals("123"));
        assertTrue(dll.removeAtEnd() == 3);
        assertTrue(dll.toString().equals("12"));
        assertTrue(dll.removeAtEnd() == 2);
        assertTrue(dll.toString().equals("1"));

    }

    @Test
    public void testRemoveNode() throws Exception {

    }

    @Test
    public void testInsertRemoveCombinations() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(3);
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);
        dll.insertAtEnd(4);
        dll.insertAtEnd(5);
        dll.insertAtEnd(6);
        assertTrue(dll.toString().equals("123456"));
        assertTrue(dll.removeAtBeginning() == 1);
        assertTrue(dll.toString().equals("23456"));
        assertTrue(dll.removeAtEnd() == 6);
        assertTrue(dll.toString().equals("2345"));
        assertTrue(dll.removeAtBeginning()== 2);
        assertTrue(dll.toString().equals("345"));
    }

}