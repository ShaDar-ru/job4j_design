package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 27.08.2021
 */
public class AnalizyTest {
//    @Rule
//    public TemporaryFolder folder = new TemporaryFolder();
//
//    @Test
//    public void whenGetLog() throws IOException {
//        File source = folder.newFile("ServerLog");
//        File result = folder.newFile("OfflineTime");
//        try (PrintWriter printWriter = new PrintWriter(source)) {
//            printWriter.println("200 14:55:27");
//            printWriter.println("300 12:22:55");
//            printWriter.println("400 21:50:23");
//            printWriter.println("300 12:21:15");
//            printWriter.println("500 17:35:37");
//            printWriter.println("300 09:11:16");
//            printWriter.println("200 13:00:29");
//            printWriter.println("300 16:02:43");
//        }
//        Analizy analizy = new Analizy();
//        analizy.unavailable(source.getAbsolutePath(), result.getAbsolutePath());
//        StringBuilder stbl = new StringBuilder();
//        try (BufferedReader in = new BufferedReader(new FileReader(result))) {
//            in.lines().forEach(x -> {
//                if (stbl.length() != 0 && stbl.length() % 2 == 0) {
//                    stbl.append(System.lineSeparator());
//                }
//                stbl.append(x);
//            });
//        }
//        assertThat(stbl.toString(), is("21:50:23;12:21:15;"
//                + System.lineSeparator()
//                + "17:35:37;09:11:16;"));
//    }

}