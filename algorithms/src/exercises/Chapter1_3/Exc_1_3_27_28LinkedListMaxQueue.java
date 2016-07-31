package exercises.Chapter1_3;

/**
 * 1.3.27 Write a method max() that takes a reference to the first node in a linked list as
 argument and returns the value of the maximum key in the list. Assume that all keys are
 positive integers, and return 0 if the list is empty

 -> Implemented as:
 Write a linkedlist queue with a method max() that returns the highest key in the linked list.
 Assume that all keys are  positive integers, and return 0 if the list is empty

 Simple iteration and keeping the highest integer..

 1.3.28 Develop a recursive solution to the previous question
 */
public class Exc_1_3_27_28LinkedListMaxQueue<Item> {

    Node frontQueueNode; // returned on enqueue
    Node backQueueNode; // last node in the linkedlist
    int N;

    public Exc_1_3_27_28LinkedListMaxQueue() {
        frontQueueNode = null;
        backQueueNode = null;
        N = 0;
    }

    public void enqueueTwo(Item item) {
        Node oldBackNode = backQueueNode;
        backQueueNode = new Node();
        backQueueNode.item = item;
        backQueueNode.next = null;
        N++;
        if (frontQueueNode == null ) {
            frontQueueNode = backQueueNode;
        } else {
            oldBackNode.next = backQueueNode;
        }
    }

    public void enqueue(Item item) {
        Node newBackQueueNode = new Node();
        newBackQueueNode.item = item;
        newBackQueueNode.next = null;
        N++;
        if (frontQueueNode == null ) {
            frontQueueNode = newBackQueueNode;
        } else {
            backQueueNode.next = newBackQueueNode;
        }
        backQueueNode = newBackQueueNode;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("queue is empty");
        }
        Item returnItem = frontQueueNode.item;
        N--;
        frontQueueNode = frontQueueNode.next;
        return returnItem;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return frontQueueNode == null;
    }

    public int max() {
        int max = 0;
        Node tempFrontQueueNode = frontQueueNode;
        while (tempFrontQueueNode != null) {
            int key;

            try { key = (Integer) tempFrontQueueNode.item;
            } catch (ClassCastException e) {
                key = 0;
            }
            if (key > max) max = key;
            tempFrontQueueNode = tempFrontQueueNode.next;
        }
        return max;
    }

    // given the frontqueuenode, find the maximum key recursively
    public int recursiveMax() {
        int max = getRecursiveMax(frontQueueNode, 0);
        return max;
    }

    public int getRecursiveMax(Node node, int currentMax) {
        int i = getIntFromNode(node);
        if (i > currentMax) {
            currentMax = i;
        }
        if (node.next == null) {
            return currentMax;
        } else {
            return getRecursiveMax(node.next, currentMax);
        }
    }

    public int getIntFromNode(Node node) {
        int i;
        try {
            i = (Integer) node.item;
        } catch (ClassCastException e) {
            i = 0;
        }
        return i;
    }

    private class Node {
        Item item;
        Node next;

        public String toString() {
            return ""+ item;
        }
    }

}
