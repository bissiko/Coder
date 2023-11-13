package serhii.ost.coder.startparams;

import serhii.ost.coder.Coders.Decoder;
import serhii.ost.coder.Coders.Encoder;
import serhii.ost.coder.readwritefile.ReadFile;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class StartCli {
    public void startCli() throws Exception {
        String command = "";
        String src = null;
        int key;
        System.out.println("Enter command: ENCRYPT, DECRYPT or BRUTE_FORCE");
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        while (flag == true) {
            String nameCommand = s.nextLine();
            if (nameCommand.equalsIgnoreCase("ENCRYPT")) {
                command = "ENCRYPT";
                flag = false;
            } else if (nameCommand.equalsIgnoreCase("DECRYPT")) {
                command = "DECRYPT";
                flag = false;
            } else if (nameCommand.equalsIgnoreCase("BRUTE_FORCE")) {
                command = "BRUTE_FORCE";
                flag = false;
            } else {
                System.out.println("Command is not accepted! Must be ENCRYPT, DECRYPT or BRUTE_FORCE");
            }
        }
        System.out.println("Enter absolute Path of File!");
        flag = true;
        while (flag == true) {
            src = s.nextLine();
            if (!Path.of(src).isAbsolute()) {
                flag = false;
                System.out.println("Path is not absolute!");
            } else {
                flag = false;
            }
        }
        System.out.println("Path is OK!");
        ReadFile file = new ReadFile(src);
        List<String> lines = file.readSourceFile(src);

        if (command.equalsIgnoreCase("BRUTE_FORCE")) {

            System.out.println("File is analysyred!");
        } else {
            System.out.println("Enter Number for Coding of File!");
            key = s.nextInt();
            flag = true;
            while (flag == true) {
                if (!(key > 0)) {
                    flag = false;
                    System.out.println("Number must be greater 0!");
                } else {
                    flag = false;
                }
            }
            if (command.equalsIgnoreCase("ENCRYPT")) {
                new Encoder().writeEncodedFile(lines, src, key);
                System.out.println("File is encrypted!");
            } else if (command.equalsIgnoreCase("DECRYPT")) {
                new Decoder().writeDecodedFile(lines, src, key);
                System.out.println("File is decrypted!");
            }
        }
    }
}
