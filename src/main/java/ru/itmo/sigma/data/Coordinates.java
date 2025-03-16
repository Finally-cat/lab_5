package ru.itmo.sigma.data;

public class Coordinates {
    private float x;
    private Double y; //Поле не может быть null
    public void setY(Double y) throws IllegalArgumentException{
        if (y == null) {
            throw new IllegalArgumentException("y < 0");
        } else {
            this.y = y;
        }
    }
    public Double getY() {
        return y;
    }
    public float getX() {
        return x;

    }
    public Coordinates(float x, Double y) {
        setX(x);
        setY(y);
    }

    private void setX(float x) {
        this.x = x;
    }
    public String toString() {
        return "Coordinates: "+ x + y;
    }
}
