package serhii.ost.coder.startparams;

import serhii.ost.coder.Coders.Decoder;
import serhii.ost.coder.Coders.Encoder;
import serhii.ost.coder.readwritefile.ReadFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Starter {
    public void starter(String[] args) throws IOException {
        String command, src;
        int key;
        if ((args.length >= 2) && (Path.of(args[1]).isAbsolute())) {
            command = args[0];
            src = args[1];
            if (args.length == 3) {
                key = Integer.parseInt(args[2]);
                ReadFile file = new ReadFile(src);
                List<String> lines = file.readSourceFile(src);

                if (command.equalsIgnoreCase("ENCRYPT")) {
                    //Encoder encoding = new Encoder();
                    new Encoder().writeEncodedFile(lines, src, key);
                    System.out.println("File is encrypted!");

                } else if (command.equalsIgnoreCase("DECRYPT")) {
                    //Decoder decoding = new Decoder();
                    new Decoder().writeDecodedFile(lines, src, key);
                    System.out.println("File is decrypted!");

                } else {
                    System.out.println("Command is not accepted! Must be ENCRYPT or DECRYPT");
                    return;
                }
            } else if (args.length == 2) {
                if (command.equalsIgnoreCase("BRUTE_FORCE")) {

                    System.out.println("File is analysyred!");
                } else {
                    System.out.println("Command is not accepted! Must be BRUTE_FORCE");
                    return;
                }
            } else {
                return;
            }
        } else if ((args.length >= 2) && (!Path.of(args[1]).isAbsolute())) {
            System.out.println("Path is not absolute!");
        }else {
            System.out.println("Arguments is clear!");
            return;
        }
    }
}
