package SORTING;
import java.util.Comparator;
public class StraightSelectionSort <E> implements ISort <E> {
    public enum directionSort {Ascending, Descending};
    private directionSort mode;
    public directionSort getMode () {
        return mode;
    }
    public void setMode (directionSort mode) {
        this.mode = mode;
    }
    public StraightSelectionSort (directionSort mode) {
        this.mode = mode;
    }
    public StraightSelectionSort () {
        this.mode = directionSort.Ascending;
    }
    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        E temp;

        //Ascending
        if (this.mode == directionSort.Ascending) {
            for (int i = 0; i < array.length - 1; i++) {
                int iMin = i;

                //Fine the index of min value
                for (int j = i + 1; j < array.length; j++)
                    if (comparator.compare(array[iMin], array[j]) > 0) iMin = j;

                // Swap a[i] with a[iMin]
                temp = array[iMin];
                array[iMin] = array[i];
                array[i] = temp;
            }
        }
        //Descending
        else if (this.mode == directionSort.Descending) {
            for (int i = 0; i < array.length - 1; i++) {
                int iMax = i;

                //Fine the index of max value
                for (int j = i + 1; j < array.length; j++)
                    if (comparator.compare(array[iMax], array[j]) < 0) iMax = j;

                // Swap a[i] with a[iMin]
                temp = array[iMax];
                array[iMax] = array[i];
                array[i] = temp;
            }
        }
    }
}
