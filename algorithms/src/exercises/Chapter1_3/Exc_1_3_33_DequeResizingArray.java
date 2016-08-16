package exercises.Chapter1_3;

import java.lang.reflect.Array;

/**
 * 1.3.33 Deque. A double-ended queue or deque (pronounced
 * “deck”) is like a stack or a queue but supports adding
 * and removing items at both ends. A deque stores a
 * collection of items and supports the following API:

 Deque()
 boolean isEmpty()
 int size()
 void pushLeft(Item item)
 void pushRight(Item item)
 Item popLeft()
 item popRight()

 Write a class  Deque that uses a doubly-linked list to
 implement this API and a class ResizingArrayDeque that
 uses a resizing array.

 Implemented: an array that starts from the middle. Elements
 are appended on both sides (pushleft / pushright). Whenever
 either side is reached, the size is resized to twice
 its size + 1, to ensure the array always maintains uneven
 length. Uneven size is done so that there is an absolute middle
 and thereby preventing index errors.
 */
public class Exc_1_3_33_DequeResizingArray<Item> {

    private int starterArraySize = 3;
    private int N;
    private int lastItemIndex;
    private int firstItemIndex;
    private Item[] deque;

    public Exc_1_3_33_DequeResizingArray() {
        this.N = 0;
        deque = (Item[]) new Object[starterArraySize];
        lastItemIndex = 1; // Middle of deque with size 3
        firstItemIndex = 1; //
    }



    public void pushLeft(Item item) {
        // boundary of array reached
        if (firstItemIndex <= 0) {
            resizeDeque((deque.length*2) + 1);
        }
        // on empty array, the firstItemIndex should remain in the middle
        if (!isEmpty()) {
            firstItemIndex--;
        }
        deque[firstItemIndex] = item;
        N++;
    }

    public void pushRight(Item item) {
        // boundary of array reached
        if (lastItemIndex >= deque.length-1) {
            resizeDeque((deque.length*2) + 1);
        }
        // on empty array, the lastItemIndex should remain in the middle
        if (!isEmpty()) {
            lastItemIndex++;
        }
        deque[lastItemIndex] = item;
        N++;
    }

    // TODO: think about checking if firstindex is bigger than second and what that means
    // TODO: Maybe phase out int N, its duplicate information so not quite needed but its convenient
    public Item popLeft() {
        if (isEmpty()) {
            throw new NullPointerException("deque is empty");
        }
        // keep index in the same location if first and last have caught up
        if (firstItemIndex > lastItemIndex) {
            throw new NullPointerException("deque is emptied");
        }
        Item returnItem = deque[firstItemIndex];
        firstItemIndex++;
        N--;
        return returnItem;
    }

    public Item popRight() {
        Item returnItem = deque[lastItemIndex];
        lastItemIndex--;
        N--;
        return returnItem;
    }
    // TODO end todo

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() { return N; }

    // The items are placed from within the middle of the array. Therefore,
    // it is useful to have the array size be an uneven number: there will
    // be an exact center, and easier to prevent off by one errors. Integer
    // division is always rounded down so middle is length/2+1.
    // The new index is therefore the newsize - oldsize / 2
    private void resizeDeque(int newSize) {
        if (newSize % 2 == 0) {
            throw new RuntimeException("Should only resizeDeque with uneven numbers");
        }
        int oldSize = deque.length;
        int indexAddition = (newSize - oldSize) / 2;
        Item[] newDeque = (Item[]) new Object[newSize];
        for (int i = 0; i <= lastItemIndex; i++) {
            newDeque[i + indexAddition] = deque[i];
        }
        firstItemIndex = firstItemIndex + indexAddition;
        lastItemIndex = lastItemIndex + indexAddition;
        deque = newDeque;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = firstItemIndex; i <= lastItemIndex; i++) {
            if (deque[i] != null) {
                sb.append(deque[i]);
            }
        }
        return sb.toString();
    }

}
