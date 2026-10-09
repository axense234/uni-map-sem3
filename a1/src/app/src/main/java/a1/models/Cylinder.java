package a1.models;

public class Cylinder implements GeometricalObject {
    protected int id;
    protected int radius;
    protected int height;

    public Cylinder(int id, int radius, int height) {
        this.id = id;
        this.radius = radius;
        this.height = height;
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

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * this.height;
    }
}
