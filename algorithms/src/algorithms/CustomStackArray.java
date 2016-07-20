package algorithms;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Implementation of a generic stack (Last in First Out) with an array data structure
 * api is as follows:
 * push(): add to top of stack
 * pop() : remove from top of stack
 * isEmpty(): check if theres things in the stack
 * size(): return the number of items on the stack
 */
public class CustomStackArray<T> implements Iterable<T>{

    private int N;
    private T[] stack;

    public CustomStackArray(int size) {
        stack = (T[]) new Object[size];
    }

    public void push(T stackItem) {
        if (N == stack.length-1) {
            resizeStack(stack.length*2);
        }
        stack[N++] = stackItem;
    }

    // What to do when pop() is called on an empty stack?
    // seems that consensus is that caller should check that the stack is not empty before calling
    // http://stackoverflow.com/questions/7390126/what-should-the-pop-method-return-when-the-stack-is-empty
    public T pop() throws EmptyStackException {
        if (N == 0) {
            throw new EmptyStackException();
        }
        T temp = stack[--N];
        stack[N] = null; // for garbage collection
        return temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resizeStack(int size) {
        T[] newstack = (T[]) new Object[size];
        System.arraycopy(stack, 0, newstack, 0, stack.length);
        stack = newstack;
    }


    @Override
    public Iterator<T> iterator() {
        return new CustomStackArrayIterator();
    }

    private class CustomStackArrayIterator implements Iterator<T> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return stack[--i];
        }

        public void remove() {}
    }




}

