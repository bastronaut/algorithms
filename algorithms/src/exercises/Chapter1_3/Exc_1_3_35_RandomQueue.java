package exercises.Chapter1_3;

import java.util.Iterator;

/**
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

 */
public class Exc_1_3_35_RandomQueue<Item> implements Iterable{

    public Exc_1_3_35_RandomQueue() {

    }

    public boolean isEmpty() {
        return false;
    }

    public void enqueue(Item item) {

    }

    public Item dequeue() {
        return null;
    }

    public Item sample() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
