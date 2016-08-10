package exercises.Chapter1_3;

/**
 * 1.3.31 Implement a nested class DoubleNode for building doubly-linked lists, where
 each node contains a reference to the item preceding it and the item following it in the
 list (null if there is no such item). Then implement static methods for the following
 tasks: insert at the beginning, insert at the end, remove from the beginning, remove
 from the end, insert before a given node, insert after a given node, and remove a given
 node.

 not implemented as static
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

    // Can insert an arbitrary node before a given node if it is in the
    // instance's LinkedList. If it is not in the instance's LL, it will
    // throw an exception
    public void insertBeforeNode(DoubleNode beforeNode, Item item) {
        if (isEmpty()) {
            throw new NullPointerException("Linked list is empty!");
        }
        DoubleNode node = firstQueueNode;
        while (node != beforeNode && node.next != null) {
            node = node.next;
        }
        if (node == beforeNode) {
            DoubleNode newNode = new DoubleNode();
            newNode.item = item;
            newNode.next = beforeNode;
            newNode.previous = beforeNode.previous;
            if (beforeNode == firstQueueNode) {
                firstQueueNode = newNode;
            } else {
                beforeNode.previous.next = newNode;
            }
            beforeNode.previous = newNode;
            N++;
        } else {
            throw new NullPointerException("node is not in LL");
        }
    }

    // Will not find the node in the linkedlist, simply insert it before
    // the given node and assume that the given node is in the instance's LinkedList
    public void insertBeforeNodeTwo(DoubleNode beforeNode, Item item) {
        if (isEmpty()) {
            throw new NullPointerException("Linked list is empty!");
        }
        DoubleNode node = new DoubleNode();
        node.item = item;
        node.next = beforeNode;
        node.previous = beforeNode.previous;

        if (beforeNode == firstQueueNode) {
            firstQueueNode = node;
        } else {
            beforeNode.previous.next = node;
            beforeNode.previous = node;
        }
        N++;
    }

    // Can insert an arbitrary node after a given node if it is in the
    // instance's LinkedList. If it is not in the instance's LL, it will
    // throw an exception
    public void insertAfterNode(DoubleNode afterNode, Item item) {
        if (isEmpty()) {
            throw new NullPointerException("Linked list is empty!");
        }
        DoubleNode node = firstQueueNode;
        while (node != afterNode && node.next != null) {
            node = node.next;
        }
        if (node.equals(afterNode)) {
            DoubleNode insertNode = new DoubleNode();
            insertNode.item = item;
            insertNode.next = node.next;
            insertNode.previous = node;
            node.next = insertNode;
            if (node == lastQueueNode) {
                lastQueueNode = insertNode;
            } else {
                node.next.previous = insertNode;
            }
            N++;
        } else {
            throw new NullPointerException("node was not found in LL");
        }

    }

    // Will not find the node in the linkedlist, simply insert it after
    // the given node and assume that the given node is in the instance's LinkedList
    public void insertAfterNodeTwo(DoubleNode afterNode, Item item) {
        if (isEmpty()) {
            throw new NullPointerException("Linked list is empty!");
        }
        DoubleNode insertNode = new DoubleNode();
        insertNode.item = item;
        insertNode.next = afterNode.next;
        insertNode.previous = afterNode;
        afterNode.next = insertNode;
        if (afterNode == lastQueueNode) {
            lastQueueNode = insertNode;
        } else {
            afterNode.next.previous = insertNode;
        }
        N++;
    }

    // assumes that the give node is in the linkedlist and
    // reduces the instance's N value
    public Item removeNode(DoubleNode node) {
        if (isEmpty()) {
            throw new NullPointerException("Linked list is empty!");
        }
        Item returnItem = node.item;
        // Pay attention to edge cases for first and last node in LL
        // to prevent nullpoiner exceptions
        if (node == lastQueueNode) {
            node.previous.next = null;
            lastQueueNode = node.previous;
        } else if (node == firstQueueNode) {
            node.next.previous = null;
            firstQueueNode = node.next;
        } else {
            node.next.previous = node.previous;
            node.previous.next = node.next;
        }
        N--;
        return returnItem;
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
