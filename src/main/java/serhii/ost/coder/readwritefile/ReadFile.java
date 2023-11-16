package serhii.ost.coder.readwritefile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;

public class ReadFile {
    public ReadFile(String srcFile) {
        this.srcFile = srcFile;
    }

    String srcFile;

    public List<String> readSourceFile(String srcFile) throws IOException {
        Path path = Paths.get(srcFile);
        if (!Files.exists(path)) {
            return Collections.emptyList();
        }
        return Files.readAllLines(path, UTF_8);
    }
}
