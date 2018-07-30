package connectP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CheckFile {
    public static void main(String[] args) throws IOException {
        Predicate<Path> checkFile = p -> {
            try (Stream<String> stream = Files.lines(p)) {
                return stream.anyMatch(line -> line.toUpperCase().contains("hello"));
            } catch (IOException ioe) {
                return false;
            }
        };
        Path path = Paths.get("C:\\Users\\dawon-016");
        Files.walk(path)
                .filter(p -> p.toString().toLowerCase().endsWith(".txt"))
                .filter(checkFile)
                .forEach(System.out::println);
    }
}