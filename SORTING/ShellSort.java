package SORTING;
import java.util.Comparator;
public class ShellSort<E> implements ISort<E> {
    protected int[] num_segment;
    public enum directionSort {Ascending, Descending};
    private directionSort mode;
    public directionSort getMode () {
        return mode;
    }
    public void setMode (directionSort mode) {
        this.mode = mode;
    }

    public ShellSort(int[] num_segment) {
        this.num_segment = num_segment;
        this.mode = directionSort.Ascending;
    }
    public ShellSort (int[] num_segment, directionSort mode) {
        this.num_segment = num_segment;
        this.mode = mode;
    }

    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        SegmentSort<E> segmentSort;

        //Ascending
        if (this.mode == directionSort.Ascending) {
            for (int k = num_segment.length - 1; k > 0; k--) {
                for (int segment_idx = 0; segment_idx < k; segment_idx++) {
                    segmentSort = new SegmentSort<>(segment_idx, k);
                    segmentSort.sort(array, comparator);
                }
            }
        }

        //Descending
        if (this.mode ==directionSort.Descending) {
            for (int k = num_segment.length - 1; k > 0; k--) {
                for (int segment_idx = 0; segment_idx < k; segment_idx++) {
                    segmentSort = new SegmentSort<>(segment_idx, k, SegmentSort.directionSort.Descending);
                    segmentSort.sort(array, comparator);
                }
            }
        }
    }
}
