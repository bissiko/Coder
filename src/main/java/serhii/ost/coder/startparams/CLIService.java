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
public class CLIService {
    String command = "";
    String src = null;
    int key;
    Scanner s = new Scanner(System.in);
    public void runCLI() throws IOException {
        System.out.printf("Enter command: %s, %s or %s \n", ENCRYPT, DECRYPT, BRUTE);
        getScannerCommand();
        getScannerPath();
        writeFile();
    }

    private void writeFile() throws IOException {
        ReadFile file = new ReadFile(src);
        List<String> lines = file.readSourceFile(src);

        if (command.equalsIgnoreCase(BRUTE)) {
            new Brute().writeBruteDecodedFile(lines, src);
            System.out.println("File is analysed!");
        } else {
            key = getKey();
            if (command.equalsIgnoreCase(ENCRYPT)) {
                new Encoder().writeEncodedFile(lines, src, key);
                System.out.println("File is encrypted!");
            } else {
                new Decoder().writeDecodedFile(lines, src, key);
                System.out.println("File is decrypted!");
            }
        }
    }

    private void getScannerPath() {
        boolean flag;
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
    }

    private void getScannerCommand() {
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
                System.out.printf("Command is not accepted! Must be %s, %s or %s \n", ENCRYPT, DECRYPT, BRUTE);
            }
        }
    }

    public int getKey() { // Read the Key
        int key = 0;
        boolean flag = true;
        System.out.println("Enter Key for Coding of File!");
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
