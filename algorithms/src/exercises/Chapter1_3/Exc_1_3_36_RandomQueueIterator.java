package exercises.Chapter1_3;

import java.util.Iterator;
import java.util.Random;

/**
 * ### builds on 1.3.35:
 * Random queue. A random queue stores a collection of items and supports the following API:

 public class    RandomQueue<Item>
 RandomQueue() create an empty random queue
 boolean isEmpty() is the queue empty?
 void enqueue(Item item) add an item
 Item dequeue() remove and return a random item (sample without replacement)
 Item sample() return a random item, but do not remove (sample with replacement)

 * Write a class RandomQueue that implements this API. Hint : Use an array representation
 * (with resizing). To remove an item, swap one at a random position (indexed 0 through N-1)
 * with the one at the last position (index N-1). Then delete and return the last object,
 * as in ResizingArrayStack. Write a client that deals bridge hands (13 cards each) using RandomQueue<Card>.

 1.3.36  Random iterator. Write an iterator for RandomQueue<Item> from the previous
 exercise that returns the items in random order.
 */
public class Exc_1_3_36_RandomQueueIterator<Item> implements Iterable{

    private int N;
    private int frontQueue;
    private int backQueue;
    @SuppressWarnings("unchecked")
    private Item[] RandomQueue = (Item[]) new Object[2];

    public Exc_1_3_36_RandomQueueIterator() {
        N = 0;
        frontQueue = 0;
        backQueue = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        if (backQueue >= RandomQueue.length) {
            resize(RandomQueue.length * 2);
        }
        RandomQueue[backQueue] = item;
        N++;
        backQueue++;
    }

    public Item dequeueRandom() {
        if (isEmpty()) {
            throw new NullPointerException("randomq empty");
        }
        // get a randomindex between frontqueue and backqueue and swap
        // the item at index with the frontqueue item
        Random rand = new Random();
        int randy = rand.nextInt(backQueue - frontQueue) + frontQueue;
        Item returnItem = RandomQueue[randy];
        RandomQueue[randy] = RandomQueue[frontQueue];
        RandomQueue[frontQueue] = null;
        frontQueue++;
        N--;
        return returnItem;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        Random rand = new Random();
        int randy = rand.nextInt(backQueue - frontQueue) + frontQueue;
        return RandomQueue[randy];
    }

    public void printRQ() {
        for (int i = 0; i < RandomQueue.length; i++) {
            System.out.println(i + " " + RandomQueue[i]);
        }
    }
    private void resize(int size) {
        Item[] newRandomQueue = (Item[]) new Object[size];
        System.arraycopy(RandomQueue, 0, newRandomQueue, 0, RandomQueue.length);
        RandomQueue = newRandomQueue;
    }

    @Override
    public Iterator iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator {

        int iN = N;
        int iFrontQueue = frontQueue;
        int iBackQueue = backQueue;
        Item[] iRandomQueue = RandomQueue;

        @Override
        public boolean hasNext() {
            return iN > 0;
        }

        @Override
        public Object next() {
            Random rand = new Random();
            int randy = rand.nextInt(iBackQueue - iFrontQueue) + iFrontQueue;
            Item returnItem = iRandomQueue[randy];
            iRandomQueue[randy] = iRandomQueue[iFrontQueue];
            iRandomQueue[iFrontQueue] = null;
            iFrontQueue++;
            iN--;
            return returnItem;
        }
    }
}
