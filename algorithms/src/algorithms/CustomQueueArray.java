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
    private int firstQueueItem;
    private Item[] queue;

    public CustomQueueArray(int queueSize) {
        queue = (Item[]) new Object[queueSize];
    }

    public void enqueue(Item queueItem) {
        if (n == queue.length) {
            resizeQueue(queue.length * 2);
        }
        queue[n] = queueItem;
        n++;
    }

    private void resizeQueue(int queueSize) {
        Item[] newqueue = (Item[]) new Object[queueSize];
        System.arraycopy(queue, 0, newqueue, 0, queue.length);
        queue = newqueue;
    }

    public Item dequeue() {
        if (firstQueueItem > n) {
            throw new EmptyStackException();
        }
        Item returnItem = queue[firstQueueItem];
        firstQueueItem++;
        return returnItem;
    }

    public boolean isEmpty() {
        return firstQueueItem >= n;
    }

    public int size() {
        return n-firstQueueItem;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CustomQueueIterator();
    }

    private class CustomQueueIterator implements Iterator<Item> {
        private int iteratorN = n;
        private int iteratorFirstQueueItem = firstQueueItem;

        public boolean hasNext() { return iteratorFirstQueueItem < iteratorN;}

        public Item next() {
            Item returnItem = queue[iteratorFirstQueueItem];
            iteratorFirstQueueItem++;
            return returnItem;
        }
        public void remove() {}
    }


}
