package ru.itmo.sigma.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coordinates {
    private float x;
    private Double y; // Поле не может быть null

    public Coordinates() {
        this.x = 0;
        this.y = 0.0;
    }

    public Coordinates(float x, Double y) {
        setX(x);
        setY(y);
    }

    @XmlElement
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    @XmlElement
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        if (y == null) {
            throw new IllegalArgumentException("y не может быть null");
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates: x=" + x + ", y=" + y;
    }
}
