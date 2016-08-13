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

 */
public class Exc_1_3_33_DequeResizingArray<Item> {

    private int starterArraySize = 2;
    private int N;
    private int lastItemIndex;
    private int firstItemIndex;
    private Item[] deque;

    public Exc_1_3_33_DequeResizingArray() {
        this.N = 0;
        this .lastItemIndex = 0;
        this.firstItemIndex = 0;
        deque = (Item[]) new Object[starterArraySize];
    }

    public void pushLeft(Item item) {

        N++;
    }

    public void pushRight(Item item) {

        N++;
    }

    // TODO: think about checking if firstindex is bigger than second and what that means
    // TODO: verify nullpointerexceptions
    // TODO: check for isEmpty
    // TODO: Maybe phase out int N, its duplicate information so not quite needed but its convenient
    public Item popLeft() {
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

    private Array[] resize(int size) {
        Array newArray[] = new Array[size];
        return newArray;
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public String toString() {
            return item.toString();
        }
    }
}
