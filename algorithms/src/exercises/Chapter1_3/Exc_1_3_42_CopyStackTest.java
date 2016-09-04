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
        assertTrue(stack.toString().equals("12345"));
        assertTrue(stackTwo.toString().equals("12345"));
        stack.push(6);
        stack.push(7);
        assertTrue(stack.toString().equals("1234567"));
        assertTrue(stackTwo.toString().equals("12345"));
        stackTwo.push(8);
        stackTwo.push(9);
        assertTrue(stack.toString().equals("1234567"));
        assertTrue(stackTwo.toString().equals("1234589"));
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
        assertTrue(stack.toString().equals("12345"));
        assertTrue(stackTwo.toString().equals("12345"));
        assertTrue(stack.pop() == 5);
        assertTrue(stack.pop() == 4);
        assertTrue(stack.toString().equals("123"));
        assertTrue(stackTwo.toString().equals("12345"));
        assertTrue(stackTwo.pop() == 5);
        assertTrue(stackTwo.pop() == 4);
        assertTrue(stackTwo.pop() == 3);
        assertTrue(stackTwo.pop() == 2);
        assertTrue(stack.toString().equals("123"));
        assertTrue(stackTwo.toString().equals("1"));
    }


    @Test
    public void testPushPop() throws Exception {

    }
}