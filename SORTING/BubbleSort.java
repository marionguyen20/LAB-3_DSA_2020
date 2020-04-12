package SORTING;
import java.util.Comparator;
public class BubbleSort <E> implements ISort <E> {
    public enum directionSort {Ascending, Descending};
    private directionSort mode  ;

    public directionSort getMode () {
        return mode;
    }
    public void setMode (directionSort mode) {
        this.mode = mode;
    }
    public BubbleSort (directionSort mode) {
        this.mode = mode;
    }
    public BubbleSort () {
        this.mode = directionSort.Ascending;
    }

    @Override
    public void sort(E[] array, Comparator<E> comparator) {

        int frag;

//        //Ascending
        if (this.mode == directionSort.Ascending) {
            for (int i = 0; i < array.length; i++) {
                frag = 0;
                for (int j = 0; j < array.length - 1; j++) {
                    if (comparator.compare(array[j], array[j + 1]) > 0) {
                        //Swap a[i] and a[i+1]
                        E temp;
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        frag++;

                    }
                }
                if (frag == 0) break;
            }
        } else if (this.mode == directionSort.Descending) {

            // Descending
            for (int i = 0; i < array.length; i++) {
                frag = 0;
                for (int j = 0; j < array.length - 1; j++) {
                    if (comparator.compare(array[j], array[j + 1]) < 0) {
                        //Swap a[i] and a[i+1]
                        E temp;
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        frag++;

                    }
                }
                if (frag == 0) break;
            }
        }
    }
}


