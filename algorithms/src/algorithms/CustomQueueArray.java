package algorithms;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Implementation of a generic Queue (First in First out)
 * api:
 * item dequeue(): get the first item of the queue
 * void enqueue(item i): put i at the back of the queue
 * int size(): size of queue
 * bool isEmpty()
 */
public class CustomQueueArray<Item> implements Iterable {

    private int n;
    private int firstItem;
    private Item[] queue;

    public CustomQueueArray(int queueSize) {
        queue = (Item[]) new Object[queueSize];
    }

    public void enqueue(Item QueueItem) {
        if (n == queue.length) {
            resizeQueue(queue.length * 2);
        }

    }

    private void resizeQueue(int queueSize) {

    }

    public Item dequeue() {
        if (n <= 0) {
            throw new EmptyStackException();
        }
        return null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CustomQueueIterator();
    }

    private class CustomQueueIterator implements Iterator<Item> {
        public boolean hasNext() { return true;}
        public Item next() {
            return null;
        }
        public void remove() {}
    }


}
