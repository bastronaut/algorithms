package exercises.Chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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

    private int N;
    Item[] RandomBag;

    public Exc_1_3_34_RandomBag() {
        this.N = 0;
        this.RandomBag = (Item[]) new Object[3]; // default arbitrary init size to make testing easier
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N >= RandomBag.length-1) {
            resizeRandomBag(RandomBag.length * 2);
        }
        RandomBag[N] = item;
        N++;
    }

    @Override
    public Iterator iterator() {
        return new RandomBagIterator();
    }

    // Double the randombag array in size when the array is full
    private void resizeRandomBag(int size) {
        if (size < 0) {
            throw new RuntimeException("size must be posiive");
        }
        Item[] newRandomBag = (Item[]) new Object[size];
        System.arraycopy(RandomBag, 0, newRandomBag, 0, RandomBag.length);
        RandomBag = newRandomBag;
    }

    private class RandomBagIterator implements Iterator {

        private int iN = N;

        public RandomBagIterator() {
            Random rnd = ThreadLocalRandom.current();
            for (int i = 0; i < iN; i++) {
                int index = rnd.nextInt(i+1);
                Item tempitem = RandomBag[i];
                RandomBag[i] = RandomBag[index];
                RandomBag[index] = tempitem;
            }
        }

        @Override
        public boolean hasNext() {
            return iN > 0;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return RandomBag[--iN];
        }
    }
}
