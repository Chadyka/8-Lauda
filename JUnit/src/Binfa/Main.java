package Binfa;

import java.io.*;

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
            FileInputStream inFile = new FileInputStream(args[0]);
            PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter(args[2])));
            byte[] b = new byte[1];
            Binfa binFa = new Binfa();
            while (inFile.read(b) != -1) {
                if (b[0] == 0x0a) {
                    break;
                }
            }
            boolean com = false;
            while (inFile.read(b) != -1) {
                if (b[0] == 0x3e) {
                    com = true;
                    continue;
                }
                if (b[0] == 0x0a) {
                    com = false;
                    continue;
                }
                if (com) {
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
            binFa.writeTree(outFile);
            outFile.println("depth = " + binFa.getDepth());
            outFile.println("mean = " + binFa.getAverage());
            outFile.println("var = " + binFa.getMean());
            outFile.close();
            inFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
