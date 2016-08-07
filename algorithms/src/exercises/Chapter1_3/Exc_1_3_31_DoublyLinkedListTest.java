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
    public void testGetNthNode() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(3);
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);
        dll.insertAtBeginning(0);
        assertTrue(dll.getNthDoubleNode(1).toString().equals("1"));
        assertTrue(dll.getNthDoubleNode(3).toString().equals("3"));
    }

    @Test
    public void testRemoveNode() throws Exception {

    }

    @Test
    public void testInsertBeforeNode() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(6); // first get this node to put before
        dll.insertAtBeginning(4); // then this node to put before
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);
        dll.insertAtBeginning(0);
        Exc_1_3_31_DoublyLinkedList.DoubleNode node = dll.getNthDoubleNode(4);
        dll.insertBeforeNode(node, 5);
        System.out.println(dll.toString());
        assertTrue(dll.toString().equals("012456"));
        node = dll.getNthDoubleNode(3);
        dll.insertBeforeNode(node, 3);
        assertTrue(dll.toString().equals("0123456"));
        node = dll.getNthDoubleNode(0);
        dll.insertBeforeNode(node, -1);
        assertTrue(dll.toString().equals("-10123456"));
    }

    @Test
    public void testInsertBeforeNodeTwo() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(6); // first get this node to put before
        dll.insertAtBeginning(4); // then this node to put before
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);
        dll.insertAtBeginning(0);
        Exc_1_3_31_DoublyLinkedList.DoubleNode node = dll.getNthDoubleNode(4);
        dll.insertBeforeNodeTwo(node, 5);
        System.out.println(dll.toString());
        assertTrue(dll.toString().equals("012456"));
        node = dll.getNthDoubleNode(3);
        dll.insertBeforeNodeTwo(node, 3);
        assertTrue(dll.toString().equals("0123456"));
        node = dll.getNthDoubleNode(0);
        dll.insertBeforeNodeTwo(node, -1);
        assertTrue(dll.toString().equals("-10123456"));
    }

    @Test
    public void testInsertAfterNode() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(6);
        dll.insertAtBeginning(4); // then this node to put before
        dll.insertAtBeginning(2); // first get this node to put before
        dll.insertAtBeginning(1);
        dll.insertAtBeginning(0);
        Exc_1_3_31_DoublyLinkedList.DoubleNode node = dll.getNthDoubleNode(2);
        dll.insertAfterNode(node, 3);
        assertTrue(dll.toString().equals("012346"));
        node = dll.getNthDoubleNode(4);
        dll.insertAfterNode(node, 5);
        assertTrue(dll.toString().equals("0123456"));
        node = dll.getNthDoubleNode(6);
        dll.insertAfterNode(node, 7);
        assertTrue(dll.toString().equals("01234567"));
    }

    @Test
    public void testInsertAfterNodeTwo() throws Exception {
        Exc_1_3_31_DoublyLinkedList<Integer> dll = new Exc_1_3_31_DoublyLinkedList<>();
        dll.insertAtBeginning(6);
        dll.insertAtBeginning(4); // then this node to put before
        dll.insertAtBeginning(2); // first get this node to put before
        dll.insertAtBeginning(1);
        dll.insertAtBeginning(0);
        Exc_1_3_31_DoublyLinkedList.DoubleNode node = dll.getNthDoubleNode(2);
        dll.insertAfterNodeTwo(node, 3);
        assertTrue(dll.toString().equals("012346"));
        node = dll.getNthDoubleNode(4);
        dll.insertAfterNodeTwo(node, 5);
        assertTrue(dll.toString().equals("0123456"));
        node = dll.getNthDoubleNode(6);
        dll.insertAfterNodeTwo(node, 7);
        assertTrue(dll.toString().equals("01234567"));
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