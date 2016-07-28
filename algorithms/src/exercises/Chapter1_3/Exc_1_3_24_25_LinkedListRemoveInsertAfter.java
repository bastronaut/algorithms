package exercises.Chapter1_3;

/**
 * 1.3.24 Write a method removeAfter() that takes a linked-list Node as
 * argument and removes the node following the given one
 * (and does nothing if the argument or the next ﬁeld in the argument node is null).
 *
 * 1.3.25 Write a method insertAfter() that takes two linked-list
 * Node arguments and inserts the second after the ﬁrst on its
 * list (and does nothing if either argument is null).
 *
 * -> Not fully clear, will be implemented as: if the first Node is
 * present in the linked list, add the second node after it.
 * If it is not present, do nothing.
 *

 */
public class Exc_1_3_24_25_LinkedListRemoveInsertAfter <Item> {

    private Node topStackNode;
    private int N;

    public Item pop() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        Item returnItem = topStackNode.item;
        topStackNode = topStackNode.next;
        N--;
        return returnItem;
    }

    public void push(Item item) {
        Node tempTopStackNode = new Node();
        tempTopStackNode.item = item;
        tempTopStackNode.next = topStackNode;
        topStackNode = tempTopStackNode;
        N++;
    }

    public void removeAfter(Node node) {
        if (isEmpty()) {
            throw new NullPointerException("Linked list is empty, node not in LL");
        }
        Node tempTopStackNode = topStackNode;
        while (!node.equals(tempTopStackNode)) {
            tempTopStackNode = tempTopStackNode.next;
        }
        if (tempTopStackNode.equals(node)) {
            tempTopStackNode.next = tempTopStackNode.next.next;
        }

    }

    public void insertAfter(Node node, Node insertNode) throws NullPointerException{
        if (node== null || insertNode == null) { throw new NullPointerException("nodes cannot be null"); }
        if (isEmpty()) { throw new NullPointerException("linked list is empty"); }
        Node tempTopStackNode = topStackNode;
        while (!tempTopStackNode.equals(node)) {
            tempTopStackNode = tempTopStackNode.next;
        }
        if (tempTopStackNode.equals(node)) {
            insertNode.next = tempTopStackNode.next;
            tempTopStackNode.next = insertNode;
        } else {
            throw new NullPointerException();
        }
    }

    public void printLinkedList() {
        Node tempTopStackNode = topStackNode;
        while (tempTopStackNode != null) {
            System.out.println(tempTopStackNode);
            tempTopStackNode = tempTopStackNode.next;
        }
    }

    public Node find(Item item) throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        Node tempTopStackNode = topStackNode;
        while (tempTopStackNode.item != item) {
            tempTopStackNode = tempTopStackNode.next;
        }
        if (tempTopStackNode.item == item) {
            N--;
            return tempTopStackNode;
        } else {
            throw new NullPointerException();
        }
    }

    public boolean isEmpty() {
        return topStackNode == null;
    }

    public int size() {
        return N;
    }

    class Node {
        private Node next;
        private Item item;

        public boolean equals(Node node) {
            return (this.item == node.item && this.next == node.next);
        }

        public String toString() {
            return item.toString();
        }
    }

//    class NodeNotFoundException extends Throwable {
//
//    }
}
