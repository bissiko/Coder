package serhii.ost.coder.readwritefile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;

public class ReadFile {
    public ReadFile(String srcFile) throws IOException {
        this.srcFile = srcFile;
    }

    String srcFile;

    public List<String> readSourceFile(String srcFile) throws IOException {
        if (!Files.exists(Paths.get(srcFile))) {
            return null;
        }
        List<String> lines = Files.readAllLines(Paths.get(srcFile), UTF_8);
        return lines;
    }
}
