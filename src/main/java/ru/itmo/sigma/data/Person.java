package ru.itmo.sigma.data;

import java.util.Date;

/**
 * The type Person.
 */
public class Person {
    private final Date birthday; //Поле может быть null
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле может быть null

    /**
     * Instantiates a new Person.
     *
     * @param birthday    the birthday
     * @param eyeColor    the eye color
     * @param hairColor   the hair color
     * @param nationality the nationality
     * @param location    the location
     */
    public Person(Date birthday, Color eyeColor, Color hairColor, Country nationality, Location location) {
    this.birthday = birthday;
    this.setEyeColor(eyeColor);
    this.setHairColor(hairColor);
    this.setNationality(nationality);
    this.setLocation(location);
 }
    public Person() {
        birthday = null;
    }


    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setLocation(Location location) throws IllegalArgumentException {
        if (location != null) {
            this.location = location;
        } else throw new IllegalArgumentException("Location не может быть nul");
    }

    /**
     * Gets nationality.
     *
     * @return the nationality
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Sets nationality.
     *
     * @param nationality the nationality
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setNationality(Country nationality) throws IllegalArgumentException{
       if (nationality != null){
           this.nationality = nationality;
       } else throw new IllegalArgumentException("Nationality не может быть null");
    }

    /**
     * Gets hair color.
     *
     * @return the hair color
     */
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * Sets hair color.
     *
     * @param hairColor the hair color
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setHairColor(Color hairColor) throws IllegalArgumentException{
        if (hairColor != null) {
            this.hairColor = hairColor;
        } else throw new IllegalArgumentException("hairColor не может быть null");
    }

    /**
     * Gets eye color.
     *
     * @return the eye color
     */
    public Color getEyeColor() {
        return eyeColor;
    }

    /**
     * Sets eye color.
     *
     * @param eyeColor the eye color
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setEyeColor(Color eyeColor) throws IllegalArgumentException{
       if (eyeColor != null) {
           this.eyeColor = eyeColor;
       } else throw new IllegalArgumentException("eyeColor не может быть null");
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    public String toString() {
        return "Person: "+ "birthday: " + birthday + " eyeColor: " + eyeColor + " hairColor: " + hairColor + " nationality: " + nationality +" location: " + location.toString();
    }

}
