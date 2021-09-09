package ru.job4j.serialization.xml;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.09.2021
 */
public class Person {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;
    private final String sl = System.lineSeparator();
    private final String tab = "    ";

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public String toXML() {
        List<String> returnedStr = Arrays.stream(statuses)
                .map(x -> tab + tab + "<status>" + x + "</status>" + sl)
                .collect(Collectors.toList());
        StringBuilder stbl = new StringBuilder();
        stbl.append("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>").append(sl)
                .append("<person>").append(sl)
                .append(tab).append("<sex=").append(sex).append("/>").append(sl)
                .append(tab).append("<age=").append(age).append("/>").append(sl)
                .append(tab).append("<contact phone=\"").append(contact.getPhone()).append("\"/>").append(sl)
                .append(tab).append("<statuses>").append(sl);
        for (String s : returnedStr) {
            stbl.append(s);
        }
        stbl.append(tab).append("</statuses>").append(sl).append("</person>");
        return stbl.toString();
    }

    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        System.out.println(person.toXML());
    }
}
