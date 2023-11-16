package serhii.ost.coder.readwritefile;

import java.io.FileOutputStream;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class WriteFile {

    public void writeDesPath(Path desPath, List<String> lines) throws IOException {
        if (Files.exists(desPath)) {
            Files.delete(desPath);
        }
        Files.createFile(desPath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(desPath), true)) {
            for (String s: lines) {
                fileOutputStream.write((s + "\n").getBytes());
            }
        }
    }
}
