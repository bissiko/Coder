package serhii.ost.coder.coders;

import serhii.ost.coder.languages.LangDetect;
import serhii.ost.coder.readwritefile.RenameFile;
import serhii.ost.coder.readwritefile.WriteFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static serhii.ost.coder.constants.Constants.DECRYPT_Mark;

public class Decoder {
    public List<String> decodingFile (List<String> src, int key) {

        LangDetect langDetect = new LangDetect();
        ArrayList<Character> charsPack = langDetect.charsPackGet(src.get(0));

        List<String> decodedText = new ArrayList<>();

        for (int i = 0; i < src.size(); i++) {
            char[] chars = src.get(i).toCharArray();
            //System.out.println(new String(chars));

            for (int j = 0; j < chars.length; j++) {
                char ch = chars[j];
                if (charsPack.contains(ch)) {
                    int k = charsPack.indexOf(ch);
                    chars[j] = charsPack.get((k + charsPack.size() - key) % charsPack.size());
                }
            }
            decodedText.add(new String(chars));
        }
        return decodedText;
    }
    public void writeDecodedFile (List<String> lines, String src, int key) throws IOException {
        Decoder decoding = new Decoder();
        List<String> decodedText = decoding.decodingFile(lines, key);

        RenameFile desPathName = new RenameFile();
        Path desPathDecode = desPathName.setDesPath(src, DECRYPT_Mark);

        WriteFile fileCoded = new WriteFile();
        fileCoded.writeDesPath(desPathDecode, decodedText);
    }
}
