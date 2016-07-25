package exercises.Chapter1_3;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * 1.3.19  Give a code fragment  that removes the last node in a linked list
 * whose ﬁrst node is first. - implemented 2 functions that removes the 'last' node in the stack:
 * - removeTopNode()
 * - removeBottomNode()
 *
 * 1.3.20 Write a method delete() that takes an
 * int argument k and deletes the kth element in a linked list, if it exists.
 * *
 * ADDITIONAL PRACTISE:
 * create a method removeMiddle() that removes the middle node in a linked list, while only
 * doing a single pass over the entire set
 *
 */
public class Exc_1_3_19_20_LinkedListDelete <Item> implements Iterable{

    private Node topStackNode;

    private int N;

    public void push(Item item) {
        Node newnode = new Node();
        newnode.item = item;
        newnode.next = topStackNode;
        topStackNode = newnode;
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Item returnItem = topStackNode.item;
        topStackNode = topStackNode.next;
        N--;
        return returnItem;
    }

    public void removeTopNode() {
        if (isEmpty()) {
            return;
        }
        // easiest is to call pop then not return anything.
        // pop(); // or:
        topStackNode = topStackNode.next;
        N--;
    }

    public void removeBottomNode() {
        if (isEmpty()) {
            return;
        }
        Node tempTopStackNode = topStackNode;
        Node prevNode = tempTopStackNode;
        while (tempTopStackNode.next != null) {
            prevNode = tempTopStackNode;
            tempTopStackNode = tempTopStackNode.next;
        }
        prevNode.next = null;
        N--;
    }

    public void printLinkedList() {
        Node tempTopStackNode = topStackNode;
        while (tempTopStackNode != null) {
            System.out.println(tempTopStackNode.item);
            tempTopStackNode = tempTopStackNode.next;
        }
    }


    // Delete the kth element from the top of the linked list,
    // where k=2 is the third element from the top and 0 is the top element
    public void deleteKthElement(int k) {

        Node tempTopStackNode = topStackNode;
        for (int i = 1; i < k; i++) {
            if (tempTopStackNode.next == null) {
                throw new EmptyStackException();
            }
            tempTopStackNode = tempTopStackNode.next;
        }
        tempTopStackNode.next = tempTopStackNode.next.next;
    }


    public boolean isEmpty() {
        if (topStackNode == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class Node {
        private Item item;
        private Node next;

        public String toString() {
            return (String) this.item;
        }
    }

    private class LinkedListIterator implements Iterator <Item> {
        private Node iteratorTopNode = topStackNode;

        @Override
        public boolean hasNext() {
            return (iteratorTopNode != null);
        }

        @Override
        public Item next() {
            Item returnItem = iteratorTopNode.item;
            iteratorTopNode = iteratorTopNode.next;
            return returnItem;
        }
    }
}
