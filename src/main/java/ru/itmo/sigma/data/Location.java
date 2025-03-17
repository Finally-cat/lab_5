package ru.itmo.sigma.data;

/**
 * The type Location.
 */
public class Location {
    private int x;
    private Integer y; //Поле не может быть null
    private Double z; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 919, Поле может быть null

    public Location() {
    }

    public Location(int x, Integer y, Double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public Integer getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setY(Integer y) throws IllegalArgumentException {
        if (y != null) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("y не может быть null");
        }
    }

    /**
     * Gets z.
     *
     * @return the z
     */
    public Double getZ() {
        return z;
    }

    /**
     * Sets z.
     *
     * @param z the z
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setZ(Double z) throws IllegalArgumentException {
        if (z != null) {
            this.z = z;
        } else {
            throw new IllegalArgumentException("z не может быть null");
        }
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setName(String name) throws IllegalArgumentException {
        if (name != null && name.length() <= 919) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Длина name не должна быть больше 919, name не может быть null");
        }
    }

    public String toString() {
        return "Location: " + x + y + z + name;
    }

}

