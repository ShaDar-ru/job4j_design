package finder;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesFinderVisitor extends SimpleFileVisitor<Path> {
    private static String name;
    private static boolean maskOrRegex;
    private static StringBuilder stbl = new StringBuilder();

    public FilesFinderVisitor(String searchingFileName, boolean maskOrRegex) {
        name = searchingFileName;
        FilesFinderVisitor.maskOrRegex = maskOrRegex;
    }

    public static String getSearchedFiles() {
        return stbl.toString();
    }

    private static void checkPath(Path path) {
        if (maskOrRegex) {
            Pattern pattern = Pattern.compile(name);
            Matcher matcher = pattern.matcher(path.toFile().getName());
            if (matcher.find()) {
                stbl.append(path);
                stbl.append(System.lineSeparator());
            }
        } else {
            if (path.getFileName().toString().equals(name)) {
                stbl.append(path);
                stbl.append(System.lineSeparator());
            }
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        checkPath(file);
        return super.visitFile(file, attrs);
    }
}
