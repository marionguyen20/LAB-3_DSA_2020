package GEOM;

import java.util.Comparator;

public class M2PointComparator implements Comparator<Point2D> {
    private Point2D[] points;
    double x,y;
    Point2D centerPoint;
    //Constructor
    public M2PointComparator (Point2D[] points) {
        this.points = points;
        centerPoint = centerPoint();
    }
    @Override
    public int compare(Point2D o1, Point2D o2) {
        if(Math.abs(centerPoint.PointDistance(o1)-centerPoint.PointDistance(o2))<1e-7) return 0;
        else if(centerPoint.PointDistance(o1)<centerPoint.PointDistance(o2)) return -1;
        else return 1;
    }
    public Point2D centerPoint () {

        //Compute the coordinate of center point
        for (int i = 0; i < points.length; i++ ) {
             x = x + points[i].getX();
             y = y + points[i].getY();
        }
        x = x / points.length;
        y = y / points.length;
        return new Point2D(x,y);
    }
}
