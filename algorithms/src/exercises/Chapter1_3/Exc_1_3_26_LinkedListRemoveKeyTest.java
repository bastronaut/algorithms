package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * Created by Bas on 30-7-2016.
 */
public class Exc_1_3_26_LinkedListRemoveKeyTest {

    @org.junit.Test
    public void testPush() {
        Exc_1_3_26_LinkedListRemoveKey<String> stacktest = new Exc_1_3_26_LinkedListRemoveKey<>();
        assertTrue(stacktest.size() == 0);
        stacktest.push("hi");
        stacktest.push("there");
        stacktest.push("how");
        assertTrue(stacktest.size() == 3);
        stacktest.push("are");
        stacktest.push("you");
        assertTrue(stacktest.size() == 5);
        stacktest.pop();
        assertTrue(stacktest.size() == 4);
        stacktest.pop();
        stacktest.pop();
        stacktest.push("test");
        assertTrue(stacktest.size() == 3);
    }

    @org.junit.Test
    public void testPop() {
        Exc_1_3_26_LinkedListRemoveKey<String> stacktest = new Exc_1_3_26_LinkedListRemoveKey<>();
        stacktest.push("hi");
        assertTrue(stacktest.pop() == "hi");
        assertTrue(stacktest.size() == 0);
        stacktest.push("hi");
        stacktest.push("how");
        stacktest.push("are");
        assertTrue(stacktest.pop() == "are");
        assertTrue(stacktest.size() == 2);
        assertTrue(stacktest.pop() == "how");
        assertTrue(stacktest.size() == 1);
        assertFalse(stacktest.isEmpty());
        assertTrue(stacktest.pop() == "hi");
        assertTrue(stacktest.size() == 0);
        assertTrue(stacktest.isEmpty());
    }

    @org.junit.Test
    public void testRemove() {
        Exc_1_3_26_LinkedListRemoveKey<String> stacktest = new Exc_1_3_26_LinkedListRemoveKey<>();
        stacktest.push("1");
        stacktest.push("2");
        stacktest.push("3");
        stacktest.push("4");
        stacktest.push("5");
        stacktest.push("6");
        stacktest.push("5");
        stacktest.push("7");
        stacktest.push("8");
        stacktest.push("9");
        stacktest.push("10");
        stacktest.push("5");
        stacktest.remove("10");
        String remove10result = "5; 9; 8; 7; 5; 6; 5; 4; 3; 2; 1; ";
        assertTrue(stacktest.toString().equals(remove10result));
        stacktest.remove("5");
        String remove5result = "9; 8; 7; 6; 4; 3; 2; 1; ";
        assertTrue(stacktest.toString().equals(remove5result));
        stacktest.remove("999");
        assertTrue(stacktest.toString().equals(remove5result));
        String remove9876result = "4; 3; 2; 1; ";
        stacktest.remove("9");
        stacktest.remove("8");
        stacktest.remove("7");
        stacktest.remove("6");
        assertTrue(stacktest.toString().equals(remove9876result));
        stacktest.remove("1");
        String remove1result = "4; 3; 2; ";
        assertTrue(stacktest.toString().equals(remove9876result));
    }

}