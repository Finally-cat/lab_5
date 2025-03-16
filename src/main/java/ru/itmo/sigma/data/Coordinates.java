package ru.itmo.sigma.data;

/**
 * The type Coordinates.
 */
public class Coordinates {
    private float x;
    private Double y; //Поле не может быть null

    /**
     * Sets y.
     *
     * @param y the y
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setY(Double y) throws IllegalArgumentException{
        if (y == null) {
            throw new IllegalArgumentException("y < 0");
        } else {
            this.y = y;
        }
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public Double getY() {
        return y;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public float getX() {
        return x;

    }

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
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
