package ru.itmo.sigma.data;

import ru.itmo.sigma.filemanaging.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/**
 * The type Worker.
 */
@XmlRootElement(name = "worker")
@XmlAccessorType(XmlAccessType.FIELD)

public class Worker implements Comparable<Worker> {
    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long salary; //Значение поля должно быть больше 0
    //private java.time.LocalDate startDate; //Поле не может быть null
    //private java.time.LocalDate endDate; //Поле может быть null
    private Position position; //Поле может быть null
    private Person person; //Поле не может быть null

    public Worker() {
        this.id = 0; // Или любое другое значение по умолчанию
        this.creationDate = ZonedDateTime.now(); // Или другое значение по умолчанию
    }

    /**
     * Instantiates a new Worker.
     *
     * @param id           the id
     * @param name         the name
     * @param coordinates  the coordinates
     * @param creationDate the creation date
     * @param salary       the salary
     * @param startDate    the start date
     * @param endDate      the end date
     * @param position     the position
     * @param person       the person
     * @throws IllegalArgumentException the illegal argument exception
     */

    public Worker(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, long salary, LocalDate startDate, LocalDate endDate, Position position, Person person) throws IllegalArgumentException {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id не может быть меньше 0");
        }
        this.setName(name);
        this.setCoordinates(coordinates);
        this.creationDate = ZonedDateTime.now(); // тут непонятно как валидировать и нужно ли?
        this.setSalary(salary);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setPosition(position);
        this.setPerson(person);
    }
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate hireDate;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate startDate;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate endDate;


    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name не может быть null или пустым");
        }
        this.name = name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     * @throws IllegalArgumentException the illegal argument exception
     */
    public Coordinates getCoordinates() throws IllegalArgumentException {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setCoordinates(Coordinates coordinates) throws IllegalArgumentException {
        if (coordinates != null) {
            this.coordinates = coordinates;
        } else {
            throw new IllegalArgumentException("coordinates не может быть null");
        }
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public ZonedDateTime getCreationDate() {

        return creationDate;
    }


    /**
     * Gets salary.
     *
     * @return the salary
     */
    public long getSalary() {
        return salary;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setSalary(long salary) throws IllegalArgumentException {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Значение salary должно быть больше 0");
        }

    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setStartDate(LocalDate startDate) throws IllegalArgumentException {
        if (startDate != null) {
            this.startDate = startDate;
        } else {
            throw new IllegalArgumentException("startDate не может быть null");
        }
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets end date.
     *
     * @param endDate the end date
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setEndDate(LocalDate endDate) throws IllegalArgumentException {
        if (endDate != null) {
            this.endDate = endDate;
        } else {
            throw new IllegalArgumentException("endDate не может быть null");
        }
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setPosition(Position position) throws IllegalArgumentException {
        if (position != null) {
            this.position = position;
        } else {
            throw new IllegalArgumentException("position не может быть null");
        }
    }

    /**
     * Gets person.
     *
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets person.
     *
     * @param person the person
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setPerson(Person person) throws IllegalArgumentException {
        if (person != null) {
            this.person = person;
        } else {
            throw new IllegalArgumentException("person не может быть null");
        }
    }

    @Override
    public int compareTo(Worker o) {
        return Long.compare(this.id, o.id);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o == null) {return false;}
        else if (!(o instanceof Worker)) {
            return false;
        }
        Worker worker = (Worker) o;
        return Objects.equals(worker.id, this.id);
    }

    public String toString() {
        return "Worker: "+"name: "+ name +" id: "+ id + " coordinates: " + coordinates.toString() +" creationDate: " +  creationDate +" salary: " + salary +" startDate: " + startDate +" endDate: " + endDate +" position: " + position + " person: " + person.toString();
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Edit.
     *
     * @param name        the name
     * @param coordinates the coordinates
     * @param salary      the salary
     * @param startDate   the start date
     * @param endDate     the end date
     * @param position    the position
     * @param person      the person
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void edit(String name, Coordinates coordinates, long salary, LocalDate startDate, LocalDate endDate, Position position, Person person) throws IllegalArgumentException {
            this.setName(name);
            this.setCoordinates(coordinates);
            this.setSalary(salary);
            this.setStartDate(startDate);
            this.setEndDate(endDate);
            this.setPosition(position);
            this.setPerson(person);
    }



}
