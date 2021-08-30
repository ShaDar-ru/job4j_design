package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 30.08.2021
 */
public class Zip {
    private final ArgsName args;
    private Path directory;
    private String exclude;
    private Path output;

    //считать ресурсы
    //проверить на валидность
    //получить файлы
    public Zip(String[] args) {
        this.args = validateResources(getResources(args));
        exclude = this.args.get("e");
    }

    public ArgsName getResources(String[] args) {
        return ArgsName.of(args);
    }


    public ArgsName validateResources(ArgsName args) {
        directory = Paths.get(args.get("d"));
        if (!directory.toFile().isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", directory.toAbsolutePath()));
        }
        output = Paths.get(args.get("o"));
        if (output.toFile().isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not file %s", output.toAbsolutePath()));
        }
        return args;
    }

    public List<File> getFiles() throws IOException {
        List<Path> paths = new ArrayList<>(
                Search.search(
                        directory, p -> !p.toFile().getName().contains(exclude)));
        List<File> files = new ArrayList<>();
        for (Path p : paths) {
            files.add(p.toFile());
        }
        return files;
    }

    public static void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File f : sources) {
                zip.putNextEntry(new ZipEntry(f.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(f))) {
                    zip.write(out.readAllBytes());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip(args);
        List<File> files = zip.getFiles();
        packFiles(files, new File(zip.output.toFile().toString()));
    }
}
