package exercises.Chapter1_4;

import java.util.ArrayList;

/**
 1.4.12 Write a program that, given two sorted arrays of N int values, prints all elements
 that appear in both arrays, in sorted order. The running time of your program
 should be proportional to N in the worst case.
 */
public class Exc_1_4_12_PrintSortedDuplicates {

    private int[] firstArray;
    private int[] secondArray;

    public Exc_1_4_12_PrintSortedDuplicates(int[] firstArray, int[] secondArray) {
        this.firstArray = firstArray;
        this.secondArray = secondArray;
    }

    // start by implementing a basic version then check the runtime
    // if both arrays are sorted, you can look for the element in an array, and if its higher, stop searching
    // should save run time. worst case would still be runtime N
    public String printSortedDoubles() {
        ArrayList<Integer> sortedMatches = new ArrayList();
        for (int x : firstArray) {
            for (int y : secondArray) {
                if (x > y) {
                    break;
                } else if (x == y) {
//                    sortedMatches TODO
                }
            }
        }
        return "";
    }
}

