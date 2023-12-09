package serhii.ost.coder.coders;

import serhii.ost.coder.languages.LangDetect;
import serhii.ost.coder.readwritefile.RenameFile;
import serhii.ost.coder.readwritefile.WriteFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static serhii.ost.coder.constants.Constants.ENCRYPT_MARK;

public class Encoder {

    public List<String> encodingFile(List<String> src, int key) {

        LangDetect langDetect = new LangDetect();
        ArrayList<Character> charsPack = langDetect.charsPackGet(src.get(0));

        List<String> encodedText = new ArrayList<>();

        for (int i = 0; i < src.size(); i++) {
            char[] chars = src.get(i).toCharArray();

            for (int j = 0; j < chars.length; j++) {
                char ch = chars[j];
                if (charsPack.contains(ch)) {
                    int k = charsPack.indexOf(ch);
                    chars[j] = charsPack.get((k + key) % charsPack.size());
                }
            }
            encodedText.add(new String(chars));
        }
        return encodedText;
    }
    public void writeEncodedFile(List<String> lines, String src, int key) throws IOException {
        Encoder encoding = new Encoder();
        List<String> encodedText = encoding.encodingFile(lines, key);

        RenameFile desPathName = new RenameFile();
        Path desPath = desPathName.setDesPath(src, ENCRYPT_MARK);

        WriteFile fileCoded = new WriteFile();
        fileCoded.writeDesPath(desPath, encodedText);

    }
}
