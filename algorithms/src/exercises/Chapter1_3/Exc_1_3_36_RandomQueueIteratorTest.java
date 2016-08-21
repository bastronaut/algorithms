package exercises.Chapter1_3;

import org.junit.Test;

/**
 * Created by BSijtsma on 20-08-2016.
 */
public class Exc_1_3_36_RandomQueueIteratorTest {

    @Test
    public void sample() throws Exception {
        Exc_1_3_36_RandomQueueIterator<Integer> RandomQueue = new Exc_1_3_36_RandomQueueIterator<>();
        RandomQueue.enqueue(1);
        RandomQueue.enqueue(2);
        RandomQueue.enqueue(3);
//        RandomQueue.printRQ();
        for (Object i: RandomQueue) {
            System.out.println(i);
        }
    }

}