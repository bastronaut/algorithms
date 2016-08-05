package exercises.Chapter1_3;

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
public class Exc_1_3_33_Deque <Item> {

    private int N;
    private Node leftNode;
    private Node rightNode;

    public Exc_1_3_33_Deque () {
        this.N = 0;
        leftNode = null;
        rightNode = null;
    }

    public void pushLeft(Item item) {

    }

    public void pushRight(Item item) {

    }

    public Item popLeft() {
        return null;
    }

    public Item popRight() {
        return null;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }


    private class Node {
        Item item;
        Node next;
        Node previous;
    }
}
