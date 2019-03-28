public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double product(Point point){
        return x * point.y - y * point.x;
    }

    public Point plus(Point point){
        return new Point (x * point.y, y * point.x);
    }
}
