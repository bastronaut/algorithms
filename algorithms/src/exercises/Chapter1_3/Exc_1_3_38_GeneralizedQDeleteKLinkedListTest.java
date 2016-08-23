package exercises.Chapter1_3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 23-08-2016.
 */
public class Exc_1_3_38_GeneralizedQDeleteKLinkedListTest {
    @Test
    public void insert() throws Exception {
        Exc_1_3_38_GeneralizedQDeleteKLinkedList<Integer> GQ = new Exc_1_3_38_GeneralizedQDeleteKLinkedList();
        GQ.insert(1);
        GQ.insert(2);
        GQ.insert(3);
        GQ.insert(4);
        GQ.toString();
    }

    @Test
    public void delete() throws Exception {
        Exc_1_3_38_GeneralizedQDeleteKLinkedList<Integer> GQ = new Exc_1_3_38_GeneralizedQDeleteKLinkedList();
        GQ.insert(1);
        GQ.insert(2);
        GQ.insert(3);
        GQ.insert(4);

        GQ.delete(3);
        assertTrue(GQ.toString().equals("123"));
        GQ.insert(4);
        GQ.insert(5);
        GQ.insert(6);
        assertTrue(GQ.toString().equals("123456"));
        GQ.delete(0);
        assertTrue(GQ.toString().equals("23456"));
        GQ.delete(2);
        assertTrue(GQ.toString().equals("2356"));
        GQ.delete(3);
        assertTrue(GQ.toString().equals("235"));
    }

}