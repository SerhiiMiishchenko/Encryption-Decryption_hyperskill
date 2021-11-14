package encryptdecrypt;

import java.io.IOException;

public class ConsoleOutput {
    public static String[] parseData(String[] input) {
        String mode = "enc";
        String data = "";
        String key = "0";
        String inFileName = "";
        String outFileName = "";
        String alg = "shift";

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i].equals("-mode")) {
                mode = input[i + 1];
            }
            if (input[i].equals("-data")) {
                data = input[i + 1].replace("\"", "");
            }
            if (input[i].equals("-key")) {
                key = input[i + 1];
            }
            if (input[i].equals("-in")) {
                inFileName = input[i + 1];
            }
            if (input[i].equals("-out")) {
                outFileName = input[i + 1];
            }
            if (input[i].equals("-alg")) {
                alg = input[i + 1];
            }
        }
        return new String[]{mode, data, key, inFileName, outFileName, alg};
    }

    public static void printData(String[] args) {
        CipherText cipherText = new CipherText();
        String[] strings = parseData(args);
        String mode = strings[0];
        String data = strings[1];
        int key = Integer.parseInt(strings[2]);
        String inFileName = strings[3];
        String outFileName = strings[4];
        String alg = strings[5];
        String result;

        try {
            cipherText.setProcessingData(mode.equals("enc") ? new Encryption() : new Decryption());
            data = inFileName.isEmpty() ? data : new Encryption().readingFile(inFileName);
            result = alg.equals("shift") ? cipherText.processingDataShift(data, key) : cipherText.processingDataUnicode(data, key);

            if (!outFileName.isEmpty()) {
                new Encryption().writingFile(outFileName, result);
            } else {
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println("Error!" + e.getMessage());
        }
    }
}
