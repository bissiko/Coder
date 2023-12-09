package serhii.ost.coder;

import serhii.ost.coder.startparams.CLIService;
import serhii.ost.coder.startparams.CaesarCipherService;
import serhii.ost.coder.startparams.ReadArgs;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean isArg2 = new ReadArgs().readArgs(args);
        if (isArg2) {
            new CaesarCipherService().runWithArgs(); // run with arguments
        } else {
            new CLIService().runCLI(); // Run with client dialog
        }
    }
}
