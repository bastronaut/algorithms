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
    private Node frontNode;
    private Node lastNode;

    public Exc_1_3_33_Deque () {
        this.N = 0;
        frontNode = null;
        lastNode = null;
    }

    // push to front of the deque, before he front node
    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            lastNode = node;
        } else {
            node.next = frontNode;
            frontNode.previous = node;
        }
        frontNode = node;
        N++;
    }

    // push to back of the deque, behind the last node
    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            frontNode = node;
        } else {
            node.previous = lastNode;
            lastNode.next = node;
        }
        lastNode = node;
        N++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            throw new NullPointerException("Deque is empty");
        }
        Item returnItem = frontNode.item;
        if (frontNode == lastNode) {
            frontNode = null;
            lastNode = null;
        } else {
            frontNode.next.previous = null;
            frontNode = frontNode.next;
        }
        N--;
        return returnItem;
    }

    public Item popRight() {
        if (isEmpty()) {
            throw new NullPointerException("Deque is empty");
        }
        Item returnItem = lastNode.item;
        if (frontNode == lastNode) {
            frontNode = null;
            lastNode = null;
        } else {
            lastNode.previous.next = null;
            lastNode = lastNode.previous;
        }
        N--;
        return returnItem;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = frontNode;
        while (node != null) {
            sb.append(node);
            node = node.next;
        }
        return sb.toString();
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
