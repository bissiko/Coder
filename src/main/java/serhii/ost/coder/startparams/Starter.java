package serhii.ost.coder.startparams;

import serhii.ost.coder.coders.Brute;
import serhii.ost.coder.coders.Decoder;
import serhii.ost.coder.coders.Encoder;
import serhii.ost.coder.readwritefile.ReadFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static serhii.ost.coder.constants.Constants.*;

public class Starter {
    // run with arguments
    public boolean starter(String[] args) throws IOException {
        String command;
        String src;
        int key;
        if (args.length >= 2) {
            command = args[0];
            src = args[1];
            if (!Path.of(args[1]).isAbsolute()) {
                System.out.println("Path is not absolute!");
                return false;
            }
            ReadFile file = new ReadFile(src);
            List<String> lines = file.readSourceFile(src);
            if (args.length == 3) {
                key = Integer.parseInt(args[2]);

                if (command.equalsIgnoreCase(ENCRYPT)) {
                    //Encode file
                    new Encoder().writeEncodedFile(lines, src, key);
                    System.out.println("File is encrypted!");
                    return true;
                } else if (command.equalsIgnoreCase(DECRYPT)) {
                    //Decode file
                    new Decoder().writeDecodedFile(lines, src, key);
                    System.out.println("File is decrypted!");
                    return true;
                } else {
                    System.out.println("Command is not accepted! Must be " + ENCRYPT + " or " + DECRYPT);
                    return false;
                }
            } else if (args.length == 2) {
                if (command.equalsIgnoreCase(BRUTE)) {
                    // File BRUTE decoding
                    new Brute().writeBruteDecodedFile(lines, src);
                    System.out.println("File is analysed!");
                    return true;
                } else {
                    System.out.println("Command is not accepted! Must be " + BRUTE);
                    return false;
                }
            }
        } else {
            System.out.println("Arguments is clear!");
            return false;
        }
        return false;
    }
}
