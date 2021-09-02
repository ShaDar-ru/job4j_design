package ru.job4j.scanner;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 02.09.2021
 */
public class CSVReader {
    /**
     * Ознакомиться с форматом CSV.
     * <p>
     * 2. Создать класс CSVReader. Задача класса прочитать данные из CSV файла и вывести их. В качестве входных данных
     * задается путь к файлу path, разделитель delimiter, приемник данных out и фильтр по столбцам filter.
     * Ключ -out имеет только два допустимых значения stdout или путь к файлу, куда нужно вывести. Например, если есть
     * файл CSV со столбцами name, age, birthDate, education, children и программа запускается таким образом:
     * <p>
     * java -jar target/csvReader.jar -path=file.csv -delimiter=";"  -out=stdout -filter=name,age
     * <p>
     * то программа должна прочитать файл по пути file.txt и вывести только столбцы name, age в консоль.
     * В качестве разделителя данных выступает ;
     * <p>
     * 3. Для чтения аргументов использовать класс Args и задания "5.1. Именованные аргументы".
     * <p>
     * 4. Программа должна запускаться с консоли в виде jar файла как показано в примере.
     * <p>
     * 5. Для чтения файла использовать класс Scanner.
     * <p>
     * 6. Добавить валидацию аргументов, как в классе Search.
     */

    // Считать данные с аргументов
    //Разбить ключи по разделителю
    //Считать файл

    private final Path path;
    private final String delimiter;
    private final Path out;
    private final List<String> filterCol;

    private List<List<String>> table;
    private List<Integer> colNumbers;

    public CSVReader(String[] args) {
        ArgsName argsN = ArgsName.of(args);
        this.path = validateIn(Path.of(argsN.get("path")));
        this.out = validateOut(argsN.get("out"));
        this.delimiter = argsN.get("delimiter");
        this.filterCol = List.of(argsN.get("filter").split(","));
    }

    public static void run(String[] args) {
        CSVReader reader = new CSVReader(args);
        reader.createTable();
        reader.dataOutPut(reader.out);
    }

    private Path validateIn(Path path) {
        if (!path.toFile().isFile()) {
            throw new IllegalArgumentException(String.format("Not a File %s", path.toFile().getAbsolutePath()));
        }
        return path;
    }

    private Path validateOut(String path) {
        Path p;
        if (path.equals("stdout")) {
            return null;
        } else {
            p = Path.of(path);
            if (p.toFile().exists()) {
                throw new IllegalArgumentException(String.format("File %s exist", p.toFile().getAbsolutePath()));
            }
        }
        return p;
    }

    private void validateData(List<String> list) {
        for (String str : filterCol) {
            if (!list.contains(str)) {
                throw new IllegalArgumentException("Invalid filter data");
            }
        }
    }


    private void createTable() {
        List<List<String>> table = new ArrayList<>();
        try (Scanner sc = new Scanner(
                new BufferedReader(new FileReader(path.toFile())))) {
            while (sc.hasNextLine()) {
                String[] temp = sc.nextLine().split(delimiter);
                List<String> list = new ArrayList<>(Arrays.asList(temp));
                table.add(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        validateData(table.get(0));
        this.table = table;
        generateHeadAndColumnsNum();
    }

    private void generateHeadAndColumnsNum() {
        List<String> head = table.get(0);
        colNumbers = new ArrayList<>();
        for (String filter : filterCol) {
            colNumbers.add(head.indexOf(filter));
        }
    }

    private String getData() {
        StringBuilder stbl = new StringBuilder();
        for (int i = 1; i < table.size(); i++) {
            for (int index : colNumbers) {
                stbl.append(table.get(i).get(index))
                        .append(" ");
            }
            stbl.append(System.lineSeparator());
        }
        return stbl.toString();
    }

    private void dataOutPut(Path out) {
        if (out != null) {
            saveData();
        } else {
            printData();
        }
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out.toFile()))) {
            bw.write(getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printData() {
        System.out.println(getData());
    }

    public static void main(String[] args) {
        run(args);
    }
}
