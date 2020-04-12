package SORTING;

import GEOM.Point2D;

public class ExecutionTimeDemo {

    public static void main (String[] args) {
        System.out.println("Straight Insertion Sort: Time measurement ");
        System.out.println("Size    Time (msec)");
        int NMax = 500;
        System.out.println(new String(new char[80]).replace('\0', '-'));

        //Compute Time of Sort
        StraightInsertionSort <Point2D> algSort = new StraightInsertionSort<>();
        Point2D[] sortPerfomance = new Point2D[NMax];
        sortPerfomance = SortingEval.timeit(algSort,10,100);

        //Print out the result
        for (int i = 0; i < sortPerfomance.length; i++) {

            String line = String.format("%d  |  %6.8f ", (int) sortPerfomance[i].getX(), sortPerfomance[i].getY());
            System.out.println(line);
        }
    }
}
/*
Shell sort allows swapping of indexes that are far apart, where bubble sort only swaps items that are adjacent.
Depend on each segment, shell sort be able to reduce more or less.
Bubble sort is the most slowest in 4 cases. Because it can only ever move an item by one position, take so much time.
Time Complexity of Bubble sort is O(N^2)
Time Complexity of Shell sort is depend on segment. If segment is 1 (insertion Sort). O(N^2), if segment is 2: O(logN)
 */
