package exercises.Chapter1_3;

/**
 * 1.3.30 Write a function that takes the ﬁrst Node in a linked
 * list as argument and (destructively)   reverses the list,
 * returning the ﬁrst Node in the result.
 *
 * Implemented as function on the object itself, operating not
 * on the arguments but on the object members
 */
public class Exc_1_3_30LinkedListReverse <Item> {
    private int N;
    private Node firstNode;
    private Node lastNode;

    public Exc_1_3_30LinkedListReverse() {
        this.N = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    public void enqueue(Item item) {
        Node newLastNode = new Node();
        newLastNode.item = item;
        newLastNode.next = null;
        if (isEmpty()) {
            firstNode = newLastNode;
        } else {
            lastNode.next = newLastNode;
        }
        lastNode = newLastNode;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("LL is empty");
        }
        Item returnItem = firstNode.item;
        firstNode = firstNode.next;
        N--;
        return returnItem;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty(){
        return firstNode == null;
    }

    public void reverseLinkedList() {
        Node currentNode = firstNode;
        Node previousNode = null;
        Node nextNode = null;
        while (currentNode.next != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        currentNode.next = previousNode;
        firstNode = currentNode;
    }

    public String printLinkedList() {
        StringBuilder sb = new StringBuilder();
        Node tempFirstNode = firstNode;
        while (tempFirstNode != null) {
            sb.append(tempFirstNode);
            tempFirstNode = tempFirstNode.next;
        }
        return sb.toString();
    }

    private class Node {
        Item item;
        Node next;

        public String toString() {
            return item.toString();
        }
    }
}
