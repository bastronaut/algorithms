package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 02-08-2016.
 */
public class Exc_1_3_33_DequeLinkedListTest {
    @Test
    public void pushLeft() throws Exception {
        Exc_1_3_33_DequeLinkedList<Integer> deque = new Exc_1_3_33_DequeLinkedList<>();
        deque.pushLeft(3);
        assertTrue(deque.toString().equals("3"));
        deque.pushLeft(2);
        deque.pushLeft(1);
        deque.pushLeft(0);
        assertTrue(deque.toString().equals("0123"));
        deque.pushLeft(-1);
        assertTrue(deque.toString().equals("-10123"));
    }

    @Test
    public void pushRight() throws Exception {
        Exc_1_3_33_DequeLinkedList<Integer> deque = new Exc_1_3_33_DequeLinkedList<>();
        deque.pushRight(3);
        assertTrue(deque.toString().equals("3"));
        deque.pushRight(2);
        deque.pushRight(1);
        deque.pushRight(0);
        assertTrue(deque.toString().equals("3210"));
        deque.pushRight(-1);
        assertTrue(deque.toString().equals("3210-1"));
    }

    @Test
    public void popLeft() throws Exception {
        Exc_1_3_33_DequeLinkedList<Integer> deque = new Exc_1_3_33_DequeLinkedList<>();
        deque.pushRight(2);
        deque.pushRight(1);
        deque.pushRight(0);
        deque.pushLeft(3);
        deque.pushLeft(4);
        assertTrue(deque.toString().equals("43210"));
        assertTrue(deque.popLeft() == 4);
        assertTrue(deque.toString().equals("3210"));
        assertTrue(deque.popLeft() == 3);
        assertTrue(deque.popLeft() == 2);
        assertTrue(deque.popLeft() == 1);
        deque.pushLeft(1);
        assertTrue(deque.popLeft() == 1);
        assertTrue(deque.popLeft() == 0);
    }

    @Test
    public void popRight() throws Exception {
        Exc_1_3_33_DequeLinkedList<Integer> deque = new Exc_1_3_33_DequeLinkedList<>();deque.pushRight(2);
        deque.pushRight(1);
        deque.pushRight(0);
        deque.pushLeft(3);
        deque.pushLeft(4);
        assertTrue(deque.toString().equals("43210"));
        System.out.println(deque);
        assertTrue(deque.popRight() == 0);
        System.out.println(deque);
        assertTrue(deque.toString().equals("4321"));
        assertTrue(deque.popRight() == 1);
        assertTrue(deque.popRight() == 2);
        assertTrue(deque.popRight() == 3);
        deque.pushRight(3);
        assertTrue(deque.popRight() == 3);
        assertTrue(deque.popRight() == 4);
    }

}