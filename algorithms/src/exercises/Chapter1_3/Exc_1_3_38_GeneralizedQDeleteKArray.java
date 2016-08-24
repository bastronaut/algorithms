package exercises.Chapter1_3;

/**
 * 1.3.38  Delete kth element. Implement a class that supports the following API:
 public class    generalizedQueue<Item>
 generalizedQueue() create an empty queue
 boolean isEmpty() is the queue empty?
 void insert(Item x) add an item Item delete(int k) delete and return the kth least recently inserted item
 First, develop an implementation that uses an array implementation, and then develop one
 that uses a linked-list implementation.
 Note : the algorithms and data structures that we introduce in Chapter 3 make it possible
 to develop an implementation that can guarantee that both insert() and delete() take time
 proportional to the logarithm of the number of items in the queue—see Exercise 3.5.27.


 */
public class Exc_1_3_38_GeneralizedQDeleteKArray<Item> implements Exc_1_3_38_GeneralizedQDeleteInterface<Item> {

    Item[] generalizedQueue = (Item[]) new Object[2];
    private int backqueue;
    private int N;

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void insert(Item item) {
        if (backqueue == generalizedQueue.length) {
            resize(generalizedQueue.length * 2);
        }
        generalizedQueue[backqueue] = item;
        backqueue++;
        N++;

    }

    @Override
    public Item delete(int k) {
        if (k > backqueue) {
            throw new NullPointerException("kth element is bigger than the last item in the queue");
        }

        Item deleteItem = generalizedQueue[k];

        if (k == generalizedQueue.length-1) {
            // exception case for final it
            generalizedQueue[k] = null;
        } else {
            for (int i = k; i < backqueue; i++) {
                generalizedQueue[i] = generalizedQueue[i+1];
            }
        }
        backqueue--;
        N--;
        return deleteItem;
    }

    // works only enlargement for now
    private void resize(int size) {
        if (size < 0) {
            throw new RuntimeException("Size invalid");
        }
        Item[] newGeneralizedQueue = (Item[]) new Object[size];
        for (int i = 0; i < generalizedQueue.length; i++) {
            newGeneralizedQueue[i] = generalizedQueue[i];
        }
        generalizedQueue = newGeneralizedQueue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < backqueue; i++) {
            sb.append(generalizedQueue[i]);
        }
        return sb.toString();
    }


}