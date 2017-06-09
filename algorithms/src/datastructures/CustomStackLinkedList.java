package datastructures;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Implementation of a generic stack (Last in First Out) with a single Linked List data structure
 * api is as follows:
 * push(): add to top of stack
 * pop() : remove from top of stack
 * isEmpty(): check if theres things in the stack
 * size(): return the number of items on the stack
 */
public class CustomStackLinkedList<T> implements Iterable<T>{

    private int N;
    private Node topStackNode;

    public CustomStackLinkedList() {

    }

    public void push(T t) {
        Node newNode = new Node();

        newNode.setItem(t);
        newNode.setNext(topStackNode);

        topStackNode = newNode;
        N++;
    }

    // What to do when pop() is called on an empty stack?
    // seems that consensus is that caller should check that the stack is not empty (!ismpety())
    // before calling the function
    // http://stackoverflow.com/questions/7390126/what-should-the-pop-method-return-when-the-stack-is-empty
    // http://stackoverflow.com/questions/23465239/what-exception-to-throw-for-pop-when-stack-is-empty
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node returnNode = topStackNode;
        topStackNode = topStackNode.getNext();
        N--;
        return returnNode.getItem();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomStackLinkedListIterator();
    }

    private class CustomStackLinkedListIterator implements Iterator<T> {

        Node iteratorTopStackNode = topStackNode;

        @Override
        public boolean hasNext() {
            System.out.println("does it have next?");
            return iteratorTopStackNode != null;
        }

        @Override
        public T next() {
            T returnItem = iteratorTopStackNode.getItem();
            iteratorTopStackNode = iteratorTopStackNode.getNext();
            return  returnItem;
        }

        @Override
        public void remove() {
        }
    }

    private class Node {
        private Node next;
        private T item;

        public void setNext(Node next) {
            this.next = next;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return this.item;
        }

        public Node getNext() {
            return this.next;
        }

        public String toString() {
            return "Node:" + item;
        }
    }
}
