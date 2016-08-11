package exercises.Chapter1_3;

/**
 * 1.3.30 Write a function that takes the ﬁrst Node in a linked
 * list  as argument and (destructively)   reverses the list,
 * returning the ﬁrst Node in the result.
 *
 * Implemented as function on the object itself, operating not
 * on the arguments but on the object members.
 */
public class Exc_1_3_30_ReverseLinkedList <Item> {

    private int N;
    private Node frontNode;
    private Node lastNode;

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            frontNode = node;
        } else {
            lastNode.next = node;
        }
        lastNode = node;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("queue empty");
        }
        Item returnItem = frontNode.item;
        if (frontNode == lastNode) {
            frontNode = null;
            lastNode = null;
        } else {
            frontNode = frontNode.next;
        }
        N--;
        return returnItem;
    }

    public void reverseLinkedList(Node node) {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        lastNode = frontNode;
        Node previousNode = null;
        Node nextNode = null;
        Node currentNode = frontNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        frontNode = previousNode;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Node getFrontNode() {
        return frontNode;
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

    public class Node {
        Item item;
        Node next;

        public String toString() {
            return item.toString();
        }
    }


}
