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
    private DoubleNode firstQueueNode;
    private DoubleNode lastQueueNode;

    public Exc_1_3_31_DoublyLinkedList() {
        this.N = 0;
        firstQueueNode = null;
        lastQueueNode = null;
    }


    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return firstQueueNode == null;
    }

    public void insertAtBeginning(Item item) {
        DoubleNode node = new DoubleNode();
        node.item = item;

        if (isEmpty()) {
            firstQueueNode = node;
            lastQueueNode = node;
        } else {
            node.next = firstQueueNode;
            firstQueueNode.previous = node;
            firstQueueNode = node;
        }
        N++;
    }

    public void insertAtEnd(Item item) {
        DoubleNode node = new DoubleNode();
        node.item = item;
        if (isEmpty()) {
            firstQueueNode = node;
            lastQueueNode = node;
        } else {
            node.previous = lastQueueNode;
            lastQueueNode.next = node;
            lastQueueNode = node;
        }
        N++;
    }

    public Item removeAtBeginning() {
        if (isEmpty()) {
            throw new NullPointerException("queue is empty");
        }
        Item returnItem = firstQueueNode.item;
        if (firstQueueNode.next == null) {
            firstQueueNode = null;
            lastQueueNode = null;
        } else {
            firstQueueNode.next.previous = null;
            firstQueueNode = firstQueueNode.next;
        }
        N--;
        return returnItem;
    }

    public Item removeAtEnd() {
        if (isEmpty()) {
            throw new NullPointerException("queue is empty");
        }
        Item returnItem = lastQueueNode.item;
        if (lastQueueNode.previous == null) {
            lastQueueNode = null;
            firstQueueNode = null;
        } else {
            lastQueueNode.previous.next = null;
            lastQueueNode = lastQueueNode.previous;
        }
        N--;
        return returnItem;
    }

    public void insertBeforeNode(DoubleNode beforeNode, Item item) {
        if (isEmpty()) {
            throw new NullPointerException("linkedlist is empty, needs at least 1 node to insert before");
        }
        // TODO
    }

    public void insertAfterNode(DoubleNode afterNode, Item item) {

    }

    public void removeNode(DoubleNode node) {

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode tempFirstQueueNode = firstQueueNode;
        while (tempFirstQueueNode != null) {
            sb.append(tempFirstQueueNode.toString());
            tempFirstQueueNode = tempFirstQueueNode.next;
        }
        return sb.toString();
    }

    // a doublenode getter to get an object to pass into insertBeforeNode and insertAfterNode
    public DoubleNode getNthDoubleNode(int n) {
        if (n > N || n < 0) {
            throw new NullPointerException("No nth element in the linked list for n: " + n);
        }
        int i = 0;
        DoubleNode returnNode = firstQueueNode;

        while (i < n) {
            returnNode = returnNode.next;
            i++;
        }
        System.out.println(returnNode);
        return returnNode;
    }

    public class DoubleNode {
        DoubleNode next;
        DoubleNode previous;
        Item item;

        public String toString() {
            return item.toString();
        }
    }
}
