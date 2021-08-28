package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 26.08.2021
 */
public class ConfigTest {

//    @Test
//    public void whenPairWithoutComment() {
//        String path = "./data/pair_without_comment.properties";
//        Config config = new Config(path);
//        config.load();
//        assertThat(config.value("name"), is("Petr Arsentev"));
//        //assertNull(config.value("surname"));
//    }
//
//    @Test
//    public void whenGetCommentsInFile() {
//        String path = "./data/pair_with_comment.properties";
//        Config config = new Config(path);
//        config.load();
//        assertThat(config.value("name"), is("Ivan Ivanov"));
//        //assertNull(config.value("surname"));
//        assertThat(config.value("id"), is("124633"));
//        assertThat(config.value("mail"), is("IvanovIvan@mail.com"));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void whenGetErrorsInValue() {
//        String path = "./data/pair_with_comment.properties";
//        Config config = new Config(path);
//        config.load();
//        assertThat(config.value("name"), is("Ivan Ivanov"));
//        //assertNull(config.value("surname"));
//        assertThat(config.value("id"), is("124633"));
//        assertThat(config.value("mail"), is("IvanovIvan@mail.com"));
//        assertThat(config.value("access level"), is("user"));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void whenGetErrorsInKey() {
//        String path = "./data/pair_with_comment.properties";
//        Config config = new Config(path);
//        config.load();
//        assertThat(config.value("name"), is("Ivan Ivanov"));
//        //assertNull(config.value("surname"));
//        assertThat(config.value("id"), is("124633"));
//        assertThat(config.value("mail"), is("IvanovIvan@mail.com"));
//        assertThat(config.value("access level"), is("user"));
//    }
}