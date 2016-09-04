package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 29-08-2016.
 *  1.3.41  Copy a queue. Create a new constructor so that
 Queue<Item> r = new Queue<Item>(q); makes r a reference to a new and
 independent copy of the queue q. You should be able to enqueue and dequeue
 from either q or r without inﬂuencing the other. Hint : Delete all
 of the elements from q and add these elements to both q and r.
 */
public class Exc_1_3_41_CopyQueueTest {
    @Test
    public void pop() throws Exception {
        Exc_1_3_41_CopyQueue<Integer> CQ = new Exc_1_3_41_CopyQueue();
        CQ.enqueue(1);
        CQ.enqueue(2);
        CQ.enqueue(3);
        CQ.enqueue(4);
        CQ.enqueue(5);
        Exc_1_3_41_CopyQueue<Integer> CQ2 = new Exc_1_3_41_CopyQueue(CQ);
        assertTrue(CQ.toString().equals("12345"));
        assertTrue(CQ2.toString().equals("12345"));
        assertTrue(CQ2.dequeue() == 1);
        assertTrue(CQ2.toString().equals("2345"));
        assertTrue(CQ.toString().equals("12345"));
        assertTrue(CQ2.dequeue() == 2);
        assertTrue(CQ2.dequeue() == 3);
        assertTrue(CQ2.dequeue() == 4);
        assertTrue(CQ2.toString().equals("5"));
        assertTrue(CQ.toString().equals("12345"));
        assertTrue(CQ.dequeue() == 1);
        assertTrue(CQ.dequeue() == 2);
        assertTrue(CQ2.toString().equals("5"));
        assertTrue(CQ.toString().equals("345"));
        assertTrue(CQ2.dequeue() == 5);
        assertTrue(CQ2.toString().equals(""));
        assertTrue(CQ.toString().equals("345"));
        assertTrue(CQ.dequeue() == 3);
        assertTrue(CQ.toString().equals("45"));

    }

    @Test
    public void push() throws Exception {
        Exc_1_3_41_CopyQueue<Integer> CQ = new Exc_1_3_41_CopyQueue();
        CQ.enqueue(1);
        CQ.enqueue(2);
        CQ.enqueue(3);
        CQ.enqueue(4);
        CQ.enqueue(5);
        Exc_1_3_41_CopyQueue<Integer> CQ2 = new Exc_1_3_41_CopyQueue(CQ);
        assertTrue(CQ2.toString().equals("12345"));
        CQ2.enqueue(6);
        assertTrue(CQ2.toString().equals("123456"));
        assertTrue(CQ.toString().equals("12345"));
        CQ.enqueue(6);
        assertTrue(CQ.toString().equals("123456"));
        assertTrue(CQ2.toString().equals("123456"));
        CQ.enqueue(7);
        CQ.enqueue(8);
        CQ.enqueue(9);
        assertTrue(CQ.toString().equals("123456789"));
        assertTrue(CQ2.toString().equals("123456"));
    }

}