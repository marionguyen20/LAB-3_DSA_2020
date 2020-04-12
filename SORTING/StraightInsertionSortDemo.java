package SORTING;
import GEOM.Point2D;
import GEOM.PointComparator;
public class StraightInsertionSortDemo {
    public static void demo() {
        int N = 30;
        Point2D[] points = Point2D.generate(N, -10, 20);

        //Print Points
        System.out.println("DEMO FOR INSERTION SORT ");
        System.out.println(new String(new char[80]).replace('\0', '='));
        System.out.println("Unsorted List Point ");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < points.length; i++) {
            String line = String.format("%3d  |  %s ", i, points[i]);
            System.out.println(line);
        }

        //Sort: Insertion Sort
//        StraightInsertionSort<Point2D> sortAlg = new StraightInsertionSort<>();
//        BubbleSort<Point2D> sortAlg = new BubbleSort<>();
        StraightSelectionSort <Point2D> sortAlg = new StraightSelectionSort<>();
//        int[] num_segment = {1,5,6};
//        ShellSort<Point2D> sortAlg = new ShellSort<>(num_segment, ShellSort.directionSort.Descending);

        sortAlg.sort(points, new PointComparator());

        //Print Point
        System.out.println("\nSorted List of Points (x-coordinate) ");
        System.out.println(new String(new char[80]).replace('\0', '-'));
        for (int i = 0; i < points.length; i++) {
            String line = String.format("%3d  |  %s ", i, points[i]);
            System.out.println(line);
        }
    }
}
