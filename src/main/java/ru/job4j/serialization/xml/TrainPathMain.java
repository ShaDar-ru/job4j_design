package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 10.09.2021
 */
public class TrainPathMain {
    public static void main(String[] args) throws Exception {
        TrainPath path = new TrainPath(
                new Train("Поезд", 28),
                true, "Санкт-Петербург", "Великий Новгород", "Москва");
        JAXBContext context = JAXBContext.newInstance(TrainPath.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(path, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            TrainPath resul = (TrainPath) unmarshaller.unmarshal(reader);
            System.out.println(resul);
        }
    }
}
