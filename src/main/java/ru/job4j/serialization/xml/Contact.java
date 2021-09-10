package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.09.2021
 */

@XmlRootElement(name = "contact")
public class Contact {
    private String phone;

    public Contact() {

    }

    public Contact(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
