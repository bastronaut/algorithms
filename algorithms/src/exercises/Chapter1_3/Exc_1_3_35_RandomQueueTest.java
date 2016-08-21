package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 20-08-2016.
 */
public class Exc_1_3_35_RandomQueueTest {

    @Test
    public void sample() throws Exception {
        Exc_1_3_35_RandomQueue<Integer> RandomQueue = new Exc_1_3_35_RandomQueue<>();
        RandomQueue.enqueue(1);
        RandomQueue.enqueue(2);
        RandomQueue.enqueue(3);
        RandomQueue.printRQ();
        System.out.println(RandomQueue.sample());
        System.out.println(RandomQueue.sample());
        System.out.println(RandomQueue.sample());
        System.out.println(RandomQueue.sample());
        System.out.println(RandomQueue.sample());
        System.out.println(RandomQueue.sample());
    }

}