package exercises.Chapter1_3;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.lang.String;

/**
 *  Develop a class ResizingArrayQueueOfStrings that implements
 *  the queue abstraction with a ﬁxed-size array, and then
 *  extend your implementation to use array resizing to remove the size restriction
 *

 */
public class Exc_1_3_14_ResizingArrayQueueOfStrings implements Iterable {

    private int N;
    private int firstItem;
    private final int DEFAULTSIZE = 2;
    private String[] queue;

    public Exc_1_3_14_ResizingArrayQueueOfStrings() {
        queue = new String[DEFAULTSIZE];
    }

    public void enqueue(String item) {
        if (N == queue.length ) {
            resizeQueue(queue.length * 2);

        }
        queue[N] = item;
        N++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException(); // should be empty queue exception but is fine for exercise
        }
        String returnItem = queue[firstItem];
        firstItem++;
        return returnItem;
    }

    public int size() {
        return N - firstItem;
    }

    public boolean isEmpty() {
        return firstItem == N;
    }

    private void resizeQueue(int size) {
        String[] newQueue = new String[size];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        queue = newQueue;
    }

    @Override
    public Iterator iterator() {
        return new ResizingQueueIterator();
    }

    private class ResizingQueueIterator implements Iterator {
        private int iteratorN = N;
        private int iteratorFirstItem = firstItem;


        @Override
        public boolean hasNext() {
            return iteratorFirstItem < N;
        }

        @Override
        public String next() {
            String returnString = queue[iteratorFirstItem];
            iteratorFirstItem++;
            return returnString;
        }

        @Override
        public void remove() {}
    }
}
