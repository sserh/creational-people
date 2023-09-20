package ru.raccoon;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            System.out.println("Выполнение метода невозможно, так как возраст человека неизвестен.");
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder
                .setSurname(surname)
                .setAge(5)
                .setAddress(address);
        return personBuilder;
    }

    @Override
    public String toString() {
        return "[" + name
                + " " + surname
                + " Возраст: " + (getAge().isPresent() && getAge().getAsInt() >= 0 ? getAge().getAsInt() : "unknown")
                + " Адрес: " + (hasAddress() ? getAddress() : "unknown")
                + "]";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        String s = name + surname;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
        }
        return hash;
    }
}