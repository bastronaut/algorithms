package exercises.Chapter1_3;

/**
 * 1.3.31 Implement a nested class DoubleNode for building doubly-linked lists, where
 each node contains a reference to the item preceding it and the item following it in the
 list (null if there is no such item). Then implement static methods for the following
 tasks: insert at the beginning, insert at the end, remove from the beginning, remove
 from the end, insert before a given node, insert after a given node, and remove a given
 node.
 */
public class Exc_1_3_31_DoublyLinkedList <Item> {

    private int N;
    private Node firstQueueNode;
    private Node lastQueueNode;

    public Exc_1_3_31_DoublyLinkedList() {
        this.N = 0;
        firstQueueNode = null;
        lastQueueNode = null;
    }

    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.previous = null;
        if (isEmpty()) {
            firstQueueNode = newNode;
        } else {
            newNode.next = lastQueueNode;
        }
        lastQueueNode.previous = newNode;
        lastQueueNode = newNode;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        N--;
        Item returnItem = firstQueueNode.item;
        firstQueueNode = firstQueueNode.next;
        return returnItem;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return firstQueueNode == null;
    }

    public void insertAtBeginning() {

    }

    public void insertAtEnd() {

    }

    public void removeAtBeginning() {

    }

    public void removeAtEnd() {

    }

    public void removeNode(Node node) {

    }

    public String printLinkedList() {
        return "";
    }

    private class Node {
        Node next;
        Node previous;
        Item item;
    }
}
