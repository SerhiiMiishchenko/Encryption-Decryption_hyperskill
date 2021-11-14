package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface EncryptionDecryption {

    String processingDataUnicode(String text, int key);
    String processingDataShift(String text, int key);

    default String readingFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Path.of(fileName)));
    }

    default void writingFile(String fileName, String data) {
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.printf("Error!%s", e.getMessage());
        }
    }
}
