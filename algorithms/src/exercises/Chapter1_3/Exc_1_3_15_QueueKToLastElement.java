package exercises.Chapter1_3;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 Write a Queue client that takes a command-line argument k and prints the
 kth from the last string found on standard input
 (assuming that standard input has k or more strings).

 Changed to: provide it a number of items to put into the queue.
 Then, given a function returnKthFromLast(int k), return the kth
 from last element in the queue
 will also implement size check to ensure that there is no out of bounds error
 */
public class Exc_1_3_15_QueueKToLastElement implements Iterable {

    private int N;
    private int firstItem;
    private final int DEFAULTSIZE = 2;
    private String[] queue;

    public Exc_1_3_15_QueueKToLastElement() {
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

    public String returnKthFromLast(int k) {
        if (k > N - firstItem) {
            throw new NullPointerException("K is bigger than the number of elements in the queue");
        }
        int kthfromlastIndex = N - firstItem - k - 1;
        System.out.println(queue[kthfromlastIndex]);
        return queue[kthfromlastIndex];
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
