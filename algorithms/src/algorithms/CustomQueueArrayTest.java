package algorithms;



import java.util.EmptyStackException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by BSijtsma on 12-07-2016.
 */
public class CustomQueueArrayTest {

    @org.junit.Test
    public void testEnqueue() {
        CustomQueueArray<String> stacktest = new CustomQueueArray<>(5);
        assertTrue(stacktest.size() == 0);
        stacktest.enqueue("hi");
        stacktest.enqueue("there");
        stacktest.enqueue("how");
        assertTrue(stacktest.size() == 3);
        stacktest.enqueue("are");
        stacktest.enqueue("you");
        assertTrue(stacktest.size() == 5);
        stacktest.dequeue();
        assertTrue(stacktest.size() == 4);
        stacktest.dequeue();
        stacktest.dequeue();
        stacktest.enqueue("test");
        assertTrue(stacktest.size() == 3);
    }

    @org.junit.Test
    public void testDequeue() {
        CustomQueueArray<String> stacktest = new CustomQueueArray<>(5);
        stacktest.enqueue("hi");
        assertTrue(stacktest.dequeue() == "hi");
        assertTrue(stacktest.size() == 0);
        stacktest.enqueue("hi");
        stacktest.enqueue("how");
        stacktest.enqueue("are");
        assertTrue(stacktest.dequeue().equals("hi"));
        assertTrue(stacktest.size() == 2);
        assertTrue(stacktest.dequeue() == "how");
        assertTrue(stacktest.size() == 1);
        assertFalse(stacktest.isEmpty());
        assertTrue(stacktest.dequeue() == "are");
        assertTrue(stacktest.size() == 0);
        assertTrue(stacktest.isEmpty());
    }

    @org.junit.Test(expected = EmptyStackException.class)
    public void testEmptyStack() {
        CustomQueueArray<String> stacktest = new CustomQueueArray<>(5);
        stacktest.dequeue();
        stacktest.enqueue("hi");
        stacktest.dequeue();
        stacktest.dequeue();
    }

    @org.junit.Test
    public void testForEach() {
        CustomQueueArray<String> queue = new CustomQueueArray<>(5);
        queue.enqueue("hi");
        queue.enqueue("how");
        queue.enqueue("are");

        String[] queueItems = new String[3];
        int i = 0;

        for (Object item : queue) {
            queueItems[i] = (String) item;
            System.out.println(item);
            i++; // hacky to test the foreach
        }
        assertTrue(queueItems[0] == "hi");
        assertTrue(queueItems[1] == "how");
        assertTrue(queueItems[2] == "are");
    }
}
