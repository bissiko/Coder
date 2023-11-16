package serhii.ost.coder.startparams;

import serhii.ost.coder.coders.Brute;
import serhii.ost.coder.coders.Decoder;
import serhii.ost.coder.coders.Encoder;
import serhii.ost.coder.readwritefile.ReadFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static serhii.ost.coder.constants.Constants.*;

// Run with client dialog
public class StartCli {
    public void startCli() throws IOException {
        String command = "";
        String src = null;
        int key;
        System.out.printf("Enter command: $s1, $s2 or $s3", ENCRYPT, DECRYPT, BRUTE);
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String nameCommand = s.nextLine();
            if (nameCommand.equalsIgnoreCase(ENCRYPT)) {
                command = "ENCRYPT";
                flag = false;
            } else if (nameCommand.equalsIgnoreCase(DECRYPT)) {
                command = "DECRYPT";
                flag = false;
            } else if (nameCommand.equalsIgnoreCase(BRUTE)) {
                command = "BRUTE_FORCE";
                flag = false;
            } else {
                System.out.println("Command is not accepted! Must be ENCRYPT, DECRYPT or BRUTE_FORCE");
            }
        }
        System.out.println("Enter absolute Path of File!");
        flag = true;
        while (flag) {
            src = s.nextLine();
            if (!Path.of(src).isAbsolute()) {
                System.out.println("Path is not absolute!");
            } else {
                flag = false;
                System.out.println("Path is OK!");
            }
        }
        ReadFile file = new ReadFile(src);
        List<String> lines = file.readSourceFile(src);

        if (command.equalsIgnoreCase("BRUTE_FORCE")) {
            new Brute().writeBruteDecodedFile(lines, src);
            System.out.println("File is analysed!");
        } else {
            System.out.println("Enter Key for Coding of File!");
            key = getKey();
            if (command.equalsIgnoreCase(ENCRYPT)) {
                new Encoder().writeEncodedFile(lines, src, key);
                System.out.println("File is encrypted!");
            } else if (command.equalsIgnoreCase(DECRYPT)) {
                new Decoder().writeDecodedFile(lines, src, key);
                System.out.println("File is decrypted!");
            }
        }
    }
    public int getKey () { // Read the Key
        int key = 0;
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            key = s.nextInt();
            if ((key <= 0)) {
                System.out.println("Key must be greater 0!");
            } else {
                flag = false;
            }
        }
        return key;
    }
}
