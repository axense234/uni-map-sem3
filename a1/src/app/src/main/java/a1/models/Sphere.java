package a1.models;

public class Sphere implements GeometricalObject {
    protected int id;
    protected int radius;

    public Sphere(int id, int radius) {
        this.id = id;
        this.radius = radius;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double calculateVolume() {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }
}
