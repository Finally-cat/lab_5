package ru.itmo.sigma.data;

public class Location {
    private int x;
    private Integer y; //Поле не может быть null
    private Double z; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 919, Поле может быть null

    public Location(int x, Integer y, Double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) throws IllegalArgumentException {
        if (y != null) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("y не может быть null");
        }
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) throws IllegalArgumentException {
        if (z != null) {
            this.z = z;
        } else {
            throw new IllegalArgumentException("z не может быть null");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name != null && name.length() <= 919) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Длина name не должна быть больше 919, name не может быть null");
        }
    }
}

