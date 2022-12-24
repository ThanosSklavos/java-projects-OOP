package gr.aueb.cf.ch11.immutableproject;

public class Main {

    public static void main(String[] args) {
        ImmutablePoint point = new ImmutablePoint(10, 20);
        Point point2 = new Point();
        Point3D point3D = new Point3D(point2, 10);
        point2.setX(40);
    }
}
