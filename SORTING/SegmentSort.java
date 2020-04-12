package SORTING;


import java.util.Comparator;

public class SegmentSort <E> implements ISort <E> {
    public enum directionSort {Ascending, Descending};
    private directionSort mode;
    public directionSort getMode () {
        return mode;
    }
    public void setMode (directionSort mode) {
        this.mode = mode;
    }
    private int segment_idx;
    private int num_segment;

    public SegmentSort (int segment_idx, int num_segment, directionSort mode) {
        this.segment_idx = segment_idx;
        this.num_segment = num_segment;
        this.mode = mode;
    }
    //Constructor
    public SegmentSort (int segment_idx, int num_segment) {
        this.segment_idx = segment_idx;
        this.num_segment = num_segment;
        this.mode = directionSort.Ascending;
    }
    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        int current;
        int walker;
        current = segment_idx + num_segment;

        //Ascending
        if (this.mode == directionSort.Ascending) {
            while (current < array.length) {
                E temp = array[current];
                walker = current - num_segment;
                while (walker >= 0 && comparator.compare(temp, array[walker]) < 0) {
                    array[walker + num_segment] = array[walker];
                    walker -= num_segment;
                }
                array[walker + num_segment] = temp;
                current += num_segment;
            }
        }

        //Descending
        if (this.mode == directionSort.Descending) {
            while (current < array.length) {
                E temp = array[current];
                walker = current - num_segment;
                while (walker >= 0 && comparator.compare(temp, array[walker]) > 0) {
                    array[walker + num_segment] = array[walker];
                    walker -= num_segment;
                }
                array[walker + num_segment] = temp;
                current += num_segment;
            }
        }
    }
}
