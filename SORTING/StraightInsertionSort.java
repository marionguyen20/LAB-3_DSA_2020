package SORTING;
import java.util.Comparator;

public class StraightInsertionSort <E> implements ISort<E>{
    /* Time Complexity
     iteration        #comparison
    -----------------------
    1:          1
    2:          2
    3:          3
    ...
    N-1:        N-1
    Total: 1 + 2+ 3 + ... + (N-1) = [(N-1)N]/2
        = 0.5*N^2 - 0.5*N
     So Time Complexity is O(N^2)

     Space Complexity
     - Store N elements in input array
     - Store other temporary variable ( constant)
     So Space Complexity is O(N) + c = O(N)
    * */
    public enum directionSort {Ascending, Descending};
    private directionSort mode;
    public directionSort getMode () {
        return mode;
    }
    public void setMode (directionSort mode) {
        this.mode = mode;
    }
    public StraightInsertionSort (directionSort mode) {
        this.mode = mode;
    }
    public StraightInsertionSort () {
        this.mode = directionSort.Ascending;
    }


    @Override
    public void sort(E[] array, Comparator<E> comparator) {

        int current, walker;
        E temp;
        current = 1;

        //Ascending
        if (this.mode == directionSort.Ascending) {
            while (current < array.length) {
                walker = current - 1;
                temp = array[current];
                while (walker >= 0 && comparator.compare(temp, array[walker]) < 0) {
                    array[walker + 1] = array[walker];
                    walker--;
                }
                array[walker + 1] = temp;
                current++;
            }
        } else if (this.mode == directionSort.Descending) {

            //Descending
            while (current < array.length) {
                walker = current - 1;
                temp = array[current];
                while (walker >= 0 && comparator.compare(temp, array[walker]) > 0) {
                    array[walker + 1] = array[walker];
                    walker--;
                }
                array[walker + 1] = temp;
                current++;
            }
        }

    }
}
