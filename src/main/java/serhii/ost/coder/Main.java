package serhii.ost.coder;

import serhii.ost.coder.startparams.StartCli;
import serhii.ost.coder.startparams.Starter;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean isArg = new Starter().starter(args);
        if (!isArg) {
            new StartCli().startCli();
        }
        /*
        C:\Users\ASUS\IdeaProjects\SerhiiOstroushko.coder\out\artifacts\SerhiiOstroushko_coder_jar\SerhiiOstroushko.coder.jar
        String src = "C:\\Users\\ASUS\\IdeaProjects\\SerhiiOstroushko.coder\\src\\main\\resources\\byron.txt";
        C:\Users\ASUS\IdeaProjects\SerhiiOstroushko.coder\src\main\resources\byron.txt
        */
    }
}
