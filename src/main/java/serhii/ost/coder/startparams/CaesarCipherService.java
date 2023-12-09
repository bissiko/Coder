package serhii.ost.coder.startparams;

import serhii.ost.coder.coders.Brute;
import serhii.ost.coder.coders.Decoder;
import serhii.ost.coder.coders.Encoder;
import serhii.ost.coder.readwritefile.ReadFile;

import java.io.IOException;
import java.util.List;

import static serhii.ost.coder.constants.Constants.*;

public class CaesarCipherService {
    // run with arguments
    public void runWithArgs() throws IOException {
        ReadArgs args = new ReadArgs();

        ReadFile file = new ReadFile(args.src);
        List<String> lines = file.readSourceFile(args.src);

        switch (args.command) {
            case ENCRYPT -> {
                new Encoder().writeEncodedFile(lines, args.src, args.key);
                System.out.println("File is encrypted!");
            }
            case DECRYPT -> {
                new Decoder().writeDecodedFile(lines, args.src, args.key);
                System.out.println("File is decrypted!");
            }
            case BRUTE -> {
                new Brute().writeBruteDecodedFile(lines, args.src);
                System.out.println("File is analysed!");
            }
        }
    }
}
