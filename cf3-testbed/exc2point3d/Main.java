package gr.aueb.cf.ch11.exc2point3d;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x;
        int y;
        int z;

        System.out.println("Please give a value for x, y and z: ");
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();

        Point3D point3D = new Point3D(x, y, z);

        System.out.println("x = " +  point3D.getX());
        point3D.setX(y);
        System.out.println(point3D.convertToString());
    }
}
