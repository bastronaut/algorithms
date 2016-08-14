package exercises.Chapter1_3;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Write a class RandomBag that implements the API:
 * RandomBag()
 * boolean isEmpty()
 * int Size()
 * void add(Item item)
 *
 * Note that this API is the same as for Bag, except for the adjective random,
 * which indicates that the iteration should provide the items in random order
 * (all N! permutations equally likely, for each iterator).
 *
 * Hint: Put the items in an array and randomize their order in the iterators constructor
 */
public class Exc_1_3_34_RandomBag<Item> implements Iterable {

    public Exc_1_3_34_RandomBag() {

    }

    public boolean size() {

    }

    public void add(Item item) {

    }

    @Override
    public Iterator iterator() {
        return new RandomBagIterator();
    }

    @Override
    public void forEach(Consumer action) {

    }

    private class RandomBagIterator implements Iterator {

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
