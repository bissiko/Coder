package serhii.ost.coder;

import serhii.ost.coder.startparams.StartCli;
import serhii.ost.coder.startparams.Starter;

public class Main {
    public static void main(String[] args) throws Exception {
        new Starter().starter(args);
        new StartCli().startCli();
        /*
        String src = "C:\\Users\\ASUS\\IdeaProjects\\SerhiiOstroushko.coder\\src\\main\\resources\\byron.txt";
        int key = 5;

        ReadFile file = new ReadFile(src);
        List<String> lines = file.readSourceFile(src);

        Encoder encoding = new Encoder();
        List<String> encodedText = encoding.encodingFile(lines, key);

        RenameFile desPathName = new RenameFile();
        Path desPath = desPathName.setDesPath(src, ENCRYPT_Mark);

        WriteFile fileCoded = new WriteFile();

        fileCoded.writeDesPath(desPath, encodedText);

        List<String> linesEncoded = file.readSourceFile(String.valueOf(desPath));

        Decoder decoding = new Decoder();
        List<String> decodedText = decoding.decodingFile(linesEncoded, key);

        Path desPathDecode = desPathName.setDesPath(String.valueOf(desPath), DECRYPT_Mark);
        fileCoded.writeDesPath(desPathDecode, decodedText);
        */
    }
}
