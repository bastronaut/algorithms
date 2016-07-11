package algorithms;

import java.util.EmptyStackException;

/**
 * Implementation of a generic stack with a single Linked List data structure
 * api is as follows:
 * push(): add to top of stack
 * pop() : remove from top of stack
 * isEmpty(): check if theres things in the stack
 * size(): return the number of items on the stack
 */
public class CustomStack<T> implements Iterable<T>{

    private int N;

    public void push(T t) {
        N++;
        Node first;
        Node last; // tricky
    }

    // What to do when pop() is called on an empty stack?
    // seems that consensus is that caller should check that the stack is not empty (!ismpety())
    // before calling the function
    // http://stackoverflow.com/questions/7390126/what-should-the-pop-method-return-when-the-stack-is-empty
    // http://stackoverflow.com/questions/23465239/what-exception-to-throw-for-pop-when-stack-is-empty
    public T pop() throws EmptyStackException {
        if (N == 0) {
            throw new EmptyStackException();
        }
        N--;
//        return
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

//    public T Iterator() {
//
//    }

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
    }
}
