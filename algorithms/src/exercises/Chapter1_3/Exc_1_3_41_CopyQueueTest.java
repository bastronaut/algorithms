package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 29-08-2016.
 *  1.3.41  Copy a queue. Create a new constructor so that
 Queue<Item> r = new Queue<Item>(q); makes r a reference to a new and
 independent copy of the queue q. You should be able to push and pop
 from either q or r without inﬂuencing the other. Hint : Delete all
 of the elements from q and add these elements to both q and r.
 */
public class Exc_1_3_41_CopyQueueTest {
    @Test
    public void pop() throws Exception {
        Exc_1_3_41_CopyQueue<Integer> CQ = new Exc_1_3_41_CopyQueue();
        CQ.push(1);
        CQ.push(2);
        CQ.push(3);
        CQ.push(4);
        CQ.push(5);
        Exc_1_3_41_CopyQueue<Integer> CQ2 = new Exc_1_3_41_CopyQueue(CQ);
        assertTrue(CQ.toString().equals("12345"));
        assertTrue(CQ2.toString().equals("12345"));
        assertTrue(CQ2.pop() == 1);
        assertTrue(CQ2.toString().equals("2345"));
        assertTrue(CQ.toString().equals("12345"));
        assertTrue(CQ2.pop() == 2);
        assertTrue(CQ2.pop() == 3);
        assertTrue(CQ2.pop() == 4);
        assertTrue(CQ2.toString().equals("5"));
        assertTrue(CQ.toString().equals("12345"));
        assertTrue(CQ.pop() == 1);
        assertTrue(CQ.pop() == 2);
        assertTrue(CQ2.toString().equals("5"));
        assertTrue(CQ.toString().equals("345"));
        assertTrue(CQ2.pop() == 5);
        assertTrue(CQ2.toString().equals(""));
        assertTrue(CQ.toString().equals("345"));
        assertTrue(CQ.pop() == 3);
        assertTrue(CQ.toString().equals("45"));

    }

    @Test
    public void push() throws Exception {
        Exc_1_3_41_CopyQueue<Integer> CQ = new Exc_1_3_41_CopyQueue();
        CQ.push(1);
        CQ.push(2);
        CQ.push(3);
        CQ.push(4);
        CQ.push(5);
        Exc_1_3_41_CopyQueue<Integer> CQ2 = new Exc_1_3_41_CopyQueue(CQ);
        assertTrue(CQ2.toString().equals("12345"));
        CQ2.push(6);
        assertTrue(CQ2.toString().equals("123456"));
        assertTrue(CQ.toString().equals("12345"));
        CQ.push(6);
        assertTrue(CQ.toString().equals("123456"));
        assertTrue(CQ2.toString().equals("123456"));
        CQ.push(7);
        CQ.push(8);
        CQ.push(9);
        assertTrue(CQ.toString().equals("123456789"));
        assertTrue(CQ2.toString().equals("123456"));
    }

}