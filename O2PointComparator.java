package GEOM;

import java.util.Comparator;

public class O2PointComparator implements Comparator <Point2D> {

    @Override
    public int compare(Point2D o1, Point2D o2) {
        Point2D origin = new Point2D(0,0);
        if (Math.abs(origin.PointDistance(o1) - origin.PointDistance(o2)) < 1e-7) return 0;
        else if (origin.PointDistance(o1) < origin.PointDistance(o2)) return -1;
        else return 1;
    }
}
