package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bas on 4-9-2016.
 */
public class Exc_1_3_42_CopyStackTest {

    @Test
    public void testPush() throws Exception {
        Exc_1_3_42_CopyStack<Integer> stack = new Exc_1_3_42_CopyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Exc_1_3_42_CopyStack<Integer> stackTwo = new Exc_1_3_42_CopyStack(stack);
        assertTrue(stack.toString().equals("54321"));
        assertTrue(stackTwo.toString().equals("54321"));
        stack.push(6);
        stack.push(7);
        assertTrue(stack.toString().equals("7654321"));
        assertTrue(stackTwo.toString().equals("54321"));
        stackTwo.push(8);
        stackTwo.push(9);
        assertTrue(stack.toString().equals("7654321"));
        assertTrue(stackTwo.toString().equals("9854321"));
    }

    @Test
    public void testPop() throws Exception {
        Exc_1_3_42_CopyStack<Integer> stack = new Exc_1_3_42_CopyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Exc_1_3_42_CopyStack<Integer> stackTwo = new Exc_1_3_42_CopyStack(stack);
        assertTrue(stack.toString().equals("54321"));
        assertTrue(stackTwo.toString().equals("54321"));
        assertTrue(stack.pop() == 5);
        assertTrue(stack.pop() == 4);
        assertTrue(stack.toString().equals("321"));
        assertTrue(stackTwo.toString().equals("54321"));
        assertTrue(stackTwo.pop() == 5);
        assertTrue(stackTwo.pop() == 4);
        assertTrue(stackTwo.pop() == 3);
        assertTrue(stackTwo.pop() == 2);
        assertTrue(stack.toString().equals("321"));
        assertTrue(stackTwo.toString().equals("1"));
    }


    @Test
    public void testPushPop() throws Exception {
        Exc_1_3_42_CopyStack<Integer> stack = new Exc_1_3_42_CopyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Exc_1_3_42_CopyStack<Integer> stackTwo = new Exc_1_3_42_CopyStack(stack);
        assertTrue(stack.toString().equals("54321"));
        assertTrue(stackTwo.toString().equals("54321"));
        assertTrue(stack.pop() == 5);
        stack.push(5);
        assertTrue(stack.pop() == 5);
        assertTrue(stack.pop() == 4);
        assertTrue(stack.toString().equals("321"));
        assertTrue(stackTwo.toString().equals("54321"));
        assertTrue(stackTwo.pop() == 5);
        assertTrue(stackTwo.pop() == 4);
        assertTrue(stackTwo.pop() == 3);
        assertTrue(stackTwo.pop() == 2);
        stackTwo.push(2);
        stackTwo.push(3);
        assertTrue(stack.toString().equals("321"));
        assertTrue(stackTwo.toString().equals("321"));
    }
}