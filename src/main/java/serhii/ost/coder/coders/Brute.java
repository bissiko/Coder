package serhii.ost.coder.coders;

import serhii.ost.coder.languages.LangDetect;
import serhii.ost.coder.readwritefile.RenameFile;
import serhii.ost.coder.readwritefile.WriteFile;
import serhii.ost.coder.startparams.StartCli;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Brute {
    public void analyzerBrute(String line) {

        LangDetect langDetect = new LangDetect();
        ArrayList<Character> charsPack = langDetect.charsPackGet(line);

        char[] chars = line.toCharArray();
        String sline;

        for (int i = 1; i < charsPack.size() - 1; i++) {
            char[] charsBrute = Arrays.copyOf(chars, chars.length);
            for (int j = 0; j < chars.length; j++) {
                char ch = chars[j];
                if (charsPack.contains(ch)) {
                    int k = charsPack.indexOf(ch);
                    charsBrute[j] = charsPack.get((k + charsPack.size() - i) % charsPack.size());
                }
            }
            sline = new String(charsBrute);
            System.out.println("Key " + i + ". Text: " + sline);
        }
        System.out.println("Choose suitable Key ");
    }
    public void writeBruteDecodedFile (List<String> lines, String src) throws IOException {
        analyzerBrute(lines.get(0));
        int key = new StartCli().getKey();

        Decoder decoding = new Decoder();
        List<String> decodedText = decoding.decodingFile(lines, key);

        RenameFile desPathName = new RenameFile();
        Path desPathDecode = desPathName.setDesPath(src, String.valueOf(key));

        WriteFile fileCoded = new WriteFile();
        fileCoded.writeDesPath(desPathDecode, decodedText);
    }
}
