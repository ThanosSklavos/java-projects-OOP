package gr.aueb.cf.ch11.exc2point3d;

public class Point3D {
    private int x;
    private int y;
    private int z;

    public Point3D(){}

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String convertToString() {
        return "(x = " + x + ", y = " + y + ", z = " + z + ")";
    }
}
