package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 25-08-2016.
 */
public class Exc_1_3_39_RingBufferTest {
    @Test
    public void deposit() throws Exception {
        Exc_1_3_39_RingBuffer RB = new Exc_1_3_39_RingBuffer(new Integer[]{1, 3, 5, 10});
        try {
            RB.deposit(999);
        } catch (Exception e) {
            boolean caught = true;
            assertTrue(caught);
        }
        assertTrue((int) RB.read() == 1);
        RB.deposit(50);
        assertTrue((int) RB.read() == 3);
        RB.deposit(60);
        assertTrue((int) RB.read() == 5);
        assertTrue((int) RB.read() == 50);
        assertTrue((int) RB.read() == 60);
        RB.deposit(100);
        RB.deposit(200);
        assertTrue((int) RB.read() == 100);
        assertTrue((int) RB.read() == 200);
        try {
            boolean caught = false;
            RB.deposit(999);
        } catch (Exception e) {
            boolean caught = true;
            assertTrue(caught);
        }
    }

    @Test
    public void read() throws Exception {
        Exc_1_3_39_RingBuffer RB = new Exc_1_3_39_RingBuffer(new Integer[]{1, 3, 5, 10});
        assertTrue((int) RB.read() == 1);
        assertTrue((int) RB.read() == 3);
        assertTrue((int) RB.read() == 5);
        assertTrue((int) RB.read() == 10);
        RB.deposit(2);
        assertTrue((int) RB.read() == 2);
        RB.deposit(20);
        RB.deposit(21);
        RB.deposit(22);
        RB.deposit(23);
        assertTrue((int) RB.read() == 20);
        assertTrue((int) RB.read() == 21);
        assertTrue((int) RB.read() == 22);
        assertTrue((int) RB.read() == 23);
        try {
            RB.read();
        } catch (Exception e) {
            boolean caught = true;
            assertTrue(caught);
        }
    }

}