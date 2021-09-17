package finder;

import java.io.*;
import java.nio.file.*;

/**
 * 1. Создать программу для поиска файла. Все классы, относящиеся к этому заданию должны быть в отдельном пакете
 * Важно! Допускается использование ранее созданных вами классов.
 * 2. Программа должна искать данные в заданном каталоге и подкаталогах.
 * 3. Имя файла может задаваться, целиком, по маске, по регулярному выражению(не обязательно).
 * 4. Программа должна собираться в jar и запускаться через java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt
 * Ключи
 * -d - директория, в которой начинать поиск.
 * -n - имя файла, маска, либо регулярное выражение.
 * -t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
 * -o - результат записать в файл.
 * 5. Программа должна записывать результат в файл.
 * 6. В программе должна быть валидация ключей и подсказка.
 */

public class FilesFinder {
    private ArgsName args;
    private Path root;
    private String name;
    private String mask;
    private String out;
    private File outFile;
    private boolean maskOrRegex = false;

    public FilesFinder(String[] values) {
        this.args = ArgsName.of(values);
        validate();
        try {
            outFile = createOutFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validate() {
        root = validatePath(validateInput("d", "root folder"));
        name = validateInput("n", "name");
        mask = validateInput("t", "name or mask or regex");
        validateNameTypeParam();
        getMaskType();
        out = validateInput("o", "file to output");
        validateOutPutFile();
    }

    private String validateInput(String key, String error) {
        String rsl;
        try {
            rsl = args.get(key);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Arguments not found \"-" + key + "\":" + error);
        }
        return rsl;
    }

    private Path validatePath(String s) {
        Path path = Path.of(s);
        if (!path.toFile().isDirectory()) {
            throw new IllegalArgumentException("The search directory isn't a directory");
        }
        return path;
    }

    private void validateOutPutFile() {
        Path path = Path.of(out);
        if (path.toFile().isDirectory()) {
            throw new IllegalArgumentException("Output file is Directory");
        }
        if (path.toFile().exists()) {
            throw new IllegalArgumentException("Output file is exist");
        }
    }

    private void validateNameTypeParam() {
        if (!(mask.equals("mask") || mask.equals("name") || mask.equals("regex"))) {
            throw new IllegalArgumentException("Parameter \"-t\" must be: \"name\" or \"mask\" or \"regex\"");
        }
    }

    private void getMaskType() {
        if (mask.equals("mask") || mask.equals("regex")) {
            maskOrRegex = true;
        }
        if (mask.equals("mask")) {
            name = maskToRegex();
        }
    }

    private File createOutFile() throws IOException {
        Path outFile = Path.of(out);
        try {
            boolean rsl = outFile.toFile().createNewFile();
        } catch (IOException e) {
            throw new IOException("Creating File Error");
        }
        return outFile.toFile();
    }

    private String maskToRegex() {
        String rsl = name.replace(".", "\\.")
                .replaceAll("\\*", ".*")
                .replaceAll("\\?", ".?");
        if (rsl.startsWith(".?")) {
            rsl = "^" + rsl;
        }
        if (!rsl.endsWith("\\*")) {
            rsl = rsl + "$";
        }
        return rsl;
    }

    private String searchingFile() throws IOException {
        Files.walkFileTree(root, new FilesFinderVisitor(name, maskOrRegex));
        return FilesFinderVisitor.getSearchedFiles();
    }

    private void outputWrite(String output) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(outFile))) {
            out.write(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FilesFinder find = new FilesFinder(args);
        String out = null;
        try {
            out = find.searchingFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        find.outputWrite(out);
        System.out.println("Done!");
    }
}
