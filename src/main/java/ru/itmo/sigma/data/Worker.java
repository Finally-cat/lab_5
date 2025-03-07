package ru.itmo.sigma.data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Worker implements Comparable<Worker> {
    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long salary; //Значение поля должно быть больше 0
    private java.time.LocalDate startDate; //Поле не может быть null
    private java.time.LocalDate endDate; //Поле может быть null
    private Position position; //Поле может быть null
    private Person person; //Поле не может быть null

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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {

        if (name != null && name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("name не может быть null и пустой");
        }
    }

    public Coordinates getCoordinates() throws IllegalArgumentException {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) throws IllegalArgumentException {
        if (coordinates != null) {
            this.coordinates = coordinates;
        } else {
            throw new IllegalArgumentException("coordinates не может быть null");
        }
    }

    public ZonedDateTime getCreationDate() {

        return creationDate;
    }


    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) throws IllegalArgumentException {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Значение salary должно быть больше 0");
        }

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate != null) {
            this.startDate = startDate;
        } else {
            throw new IllegalArgumentException("startDate не может быть null");
        }
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate != null) {
            this.endDate = endDate;
        } else {
            throw new IllegalArgumentException("endDate не может быть null");
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position != null) {
            this.position = position;
        } else {
            throw new IllegalArgumentException("position не может быть null");
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
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

    public int hashCode() {
        return Objects.hash(id);
    }
    public void edit(Worker worker, String name, Coordinates coordinates, ZonedDateTime creationDate, long salary, LocalDate startDate, LocalDate endDate, Position position, Person person) throws IllegalArgumentException {
            this.setName(name);
            this.setCoordinates(coordinates);
            this.setSalary(salary);
            this.setStartDate(startDate);
            this.setEndDate(endDate);
            this.setPosition(position);
            this.setPerson(person);
    }

    public Worker create(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Считываем лишний перевод строки

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        Worker worker = new Worker(id, name, age);
    }

}
