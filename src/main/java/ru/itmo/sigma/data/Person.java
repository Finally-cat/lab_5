package ru.itmo.sigma.data;

import java.util.Date;

public class Person {
    private final java.util.Date birthday; //Поле может быть null
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле может быть null

    public Person(java.util.Date birthday, Color eyeColor, Color hairColor, Country nationality, Location location) {
    this.birthday = birthday;
    this.setEyeColor(eyeColor);
    this.setHairColor(hairColor);
    this.setNationality(nationality);
    this.setLocation(location);
 }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) throws IllegalArgumentException {
        if (location != null) {
            this.location = location;
        } else throw new IllegalArgumentException("Location не может быть nul");
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) throws IllegalArgumentException{
       if (nationality != null){
           this.nationality = nationality;
       } else throw new IllegalArgumentException("Nationality не может быть null");
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) throws IllegalArgumentException{
        if (hairColor != null) {
            this.hairColor = hairColor;
        } else throw new IllegalArgumentException("hairColor не может быть null");
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) throws IllegalArgumentException{
       if (eyeColor != null) {
           this.eyeColor = eyeColor;
       } else throw new IllegalArgumentException("eyeColor не может быть null");
    }

    public Date getBirthday() {
        return birthday;
    }

}
