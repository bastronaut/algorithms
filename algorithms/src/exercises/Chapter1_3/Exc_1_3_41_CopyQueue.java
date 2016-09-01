package exercises.Chapter1_3;

import java.util.Iterator;

/**
 1.3.41  Copy a queue. Create a new constructor so that
 Queue<Item> r = new Queue<Item>(q); makes r a reference to a new and
 independent copy of the queue q. You should be able to push and pop
 from either q or r without inﬂuencing the other. Hint : Delete all
 of the elements from q and add these elements to both q and r.

 */
public class Exc_1_3_41_CopyQueue <Item> implements Iterable {

    private int N;
    private Node frontNode;
    private Node backNode;

    public Exc_1_3_41_CopyQueue() {
        // default constructor
    }

    public Exc_1_3_41_CopyQueue(Exc_1_3_41_CopyQueue queueToCopy) {
        // To create a copy, completely pop the original queue,
        // and add all of the popped items back to it
        for (int i = 0; i < queueToCopy.size(); i++) {
            System.out.println(queueToCopy);
            System.out.println(frontNode);
            Node newCopyNode = new Node();
            Object newItem = queueToCopy.pop();
            this.push((Item) newItem);
            queueToCopy.push(newItem);
        }
    }

    public void push(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            frontNode = newNode;
            backNode = newNode;
        } else {
            backNode.next = newNode;
            backNode = newNode;
        }
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        Item returnItem = frontNode.item;
        frontNode = frontNode.next;
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
        Node tempNode = frontNode;
        while (tempNode != null) {
            sb.append(tempNode.item);
            tempNode = tempNode.next;
        }
        return sb.toString();
    }

    private class Node {
        Node next;
        Item item;

        public String toString() {
            return item.toString();
        }
    }

    @Override
    public Iterator iterator() {
        return new CopyQueueIterator();
    }

    private class CopyQueueIterator implements Iterator {

        Node iNode = frontNode;
        int iN = N;

        @Override
        public boolean hasNext() {
            return iN > 0;
        }

        @Override
        public Item next() {
            Item returnItem = iNode.item;
            iNode = iNode.next;
            N--;
            return returnItem;
        }
    }
}
