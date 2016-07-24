package exercises.Chapter1_3;

import java.util.EmptyStackException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 Write a Queue client that takes a command-line argument k and prints the
 kth from the last string found on standard input
 (assuming that standard input has k or more strings).

 Changed to: provide it a number of items to put into the queue.
 Then, given a function returnKthFromLast(int k), return the kth
 from last element in the queue
 will also implement size check to ensure that there is no out of bounds error
 */
public class Exc_1_3_15_QueueKToLastElementTest {
    @org.junit.Test
    public void testReturnKthFromLast() {
        Exc_1_3_15_QueueKToLastElement stacktest = new Exc_1_3_15_QueueKToLastElement();
        stacktest.enqueue("1");
        stacktest.enqueue("2");
        stacktest.enqueue("3");
        stacktest.enqueue("4");
        assertTrue(stacktest.returnKthFromLast(2).equals("2"));
        stacktest.enqueue("5");
        stacktest.enqueue("6");
        stacktest.enqueue("7");
        stacktest.enqueue("8");
        stacktest.enqueue("9");
        stacktest.enqueue("10");
        assertTrue(stacktest.returnKthFromLast(9).equals("1"));
        assertTrue(stacktest.returnKthFromLast(5).equals("5"));
    }

}