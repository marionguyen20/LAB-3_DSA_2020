package SORTING;
import GEOM.Point2D;
import GEOM.PointComparator;
public class SortingEval {

    public static Point2D[] timeit (ISort algorithm, int nElementMax, int nExec) {
        Point2D[] algPerfomance = new Point2D[nElementMax];
        algPerfomance[0] = new Point2D (0,0);
        for (int i = 1; i < nElementMax; i++) {
            double timeElapsed = 0;
            for (int j = 0; j < nExec; j++) {
                Point2D[] points = Point2D.generate(i,-10,20);

                long startTime = System.nanoTime();
//                System.out.println("StartTime is: %d "+ startTime);
                algorithm.sort(points, new PointComparator());
                long endTime = System.nanoTime();
//                System.out.println("EndTime is: %d " + endTime);
                timeElapsed += (double)(endTime - startTime)/(nExec*1000000);
            }
            algPerfomance[i] = new Point2D(i,timeElapsed);
//            System.out.println(algPerfomance[i]);
        }
        return algPerfomance;
    }
}
