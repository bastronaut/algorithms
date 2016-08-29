package exercises.Chapter1_3;

import java.util.Iterator;

/**
 1.3.41  Copy a queue. Create a new constructor so that
 Queue<Item> r = new Queue<Item>(q); makes r a reference to a new and
 independent copy of the queue q. You should be able to push and pop
 from either q or r without inﬂuencing the other. Hint : Delete all
 of the elements from q and add these elements to both q and r.

 */
public class Exc_1_3_41_CopyQueue <Item> implements Iterable {

    public Exc_1_3_41_CopyQueue() {

    }

    public Exc_1_3_41_CopyQueue(Exc_1_3_41_CopyQueue queueToCopy) {
        // return new queue
    }

    public void push(Item item) {

    }

    public Item pop() {

    }

    public String toString() {

    }


    @Override
    public Iterator iterator() {
        return new CopyQueueIterator();
    }

    private class CopyQueueIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
