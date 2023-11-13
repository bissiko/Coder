package serhii.ost.coder.readwritefile;

import java.nio.file.Path;

public class RenameFile {
    public Path setDesPath(String srcFile, String desFileMark) {

        int dotIndex = srcFile.lastIndexOf(".");
        return Path.of(srcFile.substring(0, dotIndex) + desFileMark + srcFile.substring(dotIndex));

    }

}
