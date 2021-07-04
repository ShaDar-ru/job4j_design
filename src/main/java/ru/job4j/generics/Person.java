package ru.job4j.generics;

import java.util.Date;
import java.util.Objects;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 04.07.2021
 */
public class Person {
    private String name;
    private int age;
    private Date birthday;

    public Person(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person p = (Person) o;
        return Objects.equals(name, p.name) && Objects.equals(age, p.age) && Objects.equals(birthday, p.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

    public String toString() {
        return "Person{"
                + "name='" + getName() + "', "
                + "age=" + getAge() + ", "
                + "birthday=" + getBirthday()
                + "}";
    }
}
