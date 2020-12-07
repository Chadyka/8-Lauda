package Binfa;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            Binfa.usage();
            System.exit(-1);
        }
        if (!"-o".equals(args[1])) {
            Binfa.usage();
            System.exit(-1);
        }
        try {
            java.io.FileInputStream beFile = new java.io.FileInputStream(new java.io.File(args[0]));
            java.io.PrintWriter kiFile = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(args[2])));
            byte[] b = new byte[1];
            Binfa binFa = new Binfa();
            while (beFile.read(b) != -1) {
                if (b[0] == 0x0a) {
                    break;
                }
            }
            boolean kommentben = false;
            while (beFile.read(b) != -1) {
                if (b[0] == 0x3e) {
                    kommentben = true;
                    continue;
                }
                if (b[0] == 0x0a) {
                    kommentben = false;
                    continue;
                }
                if (kommentben) {
                    continue;
                }
                if (b[0] == 0x4e) {
                    continue;
                }
                for (int i = 0; i < 8; ++i) {
                    binFa.processBit('0');
                    b[0] <<= 1;
                }
            }
            binFa.writeTree(kiFile);
            kiFile.println("depth = " + binFa.getDepth());
            kiFile.println("mean = " + binFa.getAverage());
            kiFile.println("var = " + binFa.getMean());
            kiFile.close();
            beFile.close();
        } catch (IOException fnfException) {
            fnfException.printStackTrace();
        }
    }
}
