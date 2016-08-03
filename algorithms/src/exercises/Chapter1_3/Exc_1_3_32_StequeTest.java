package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 02-08-2016.
 */
public class Exc_1_3_32_StequeTest {

    @org.junit.Test
    public void testEnqueuePushCombination() {
        Exc_1_3_32_Steque<Integer> steque = new Exc_1_3_32_Steque<>();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        assertTrue(steque.toString().equals("321"));
        steque.enqueue(4);
        assertTrue(steque.toString().equals("3214"));
        steque.enqueue(-1);
        assertTrue(steque.toString().equals("3214-1"));
        steque.pop();
        steque.pop();
        steque.pop();
        steque.pop();
        System.out.println(steque);
        assertTrue(steque.toString().equals("-1"));
        steque.pop();
        steque.enqueue(99);
        assertTrue(steque.toString().equals("99"));
        steque.push(100);
        assertTrue(steque.toString().equals("10099"));
    }

    @org.junit.Test
    public void testPush() {
        Exc_1_3_32_Steque<Integer> steque = new Exc_1_3_32_Steque<>();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        assertTrue(steque.toString().equals("321"));
        steque.pop();
        steque.push(4);
        assertTrue(steque.toString().equals("421"));
    }

    @org.junit.Test
    public void testDequeue() {
        Exc_1_3_32_Steque<Integer> steque = new Exc_1_3_32_Steque<>();
        steque.enqueue(1);
        steque.enqueue(2);
        steque.enqueue(3);
        assertTrue(steque.toString().equals("421"));
    }
}