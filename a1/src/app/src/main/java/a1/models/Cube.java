package a1.models;

public class Cube implements GeometricalObject {
    protected int id;
    protected int side;

    public Cube(int id, int side) {
        this.id = id;
        this.side = side;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSide() {
        return this.side;
    }

    public void setSide(int height) {
        this.side = height;
    }

    public double calculateVolume() {
        return Math.pow(side, 3);
    }
}
