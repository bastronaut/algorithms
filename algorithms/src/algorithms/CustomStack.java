package algorithms;

import java.util.EmptyStackException;

/**
 * Implementation of a generic stack with a Linked List data structure
 * api is as follows:
 * push(): add to top of stack
 * pop() : remove from top of stack
 * isEmpty(): check if theres things in the stack
 * size(): return the number of items on the stack
 */
public class CustomStack<T> implements Iterable<T>{

    private int N;

    public void push(T t) {

    }

    // throw an emptystack exception when pop is called on an empty stack?
    // seems that consensus is that caller should check that the stack is not empty (!ismpety())
    // before calling the function
    // http://stackoverflow.com/questions/7390126/what-should-the-pop-method-return-when-the-stack-is-empty
    // http://stackoverflow.com/questions/23465239/what-exception-to-throw-for-pop-when-stack-is-empty
    public T pop() throws EmptyStackException {
//        return T;
    }

    public boolean isEmpty() {

    }

    public int size() {
        return N;
    }

//    public T Iterator() {
//
//    }

    private class Node {
        T next;


        public void setNext(T next) {
            this.next = next;
        }
    }
}
