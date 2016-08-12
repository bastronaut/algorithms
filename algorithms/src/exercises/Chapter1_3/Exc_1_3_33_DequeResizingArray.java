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
