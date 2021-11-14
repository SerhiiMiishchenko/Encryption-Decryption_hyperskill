package encryptdecrypt;

public class CipherText {
    private EncryptionDecryption processingData;

    public void setProcessingData(EncryptionDecryption processingData) {
        this.processingData = processingData;
    }

    public String processingDataUnicode(String text, int key) {
        return this.processingData.processingDataUnicode(text, key);
    }

    public String processingDataShift(String text, int key) {
        return this.processingData.processingDataShift(text, key);
    }
}
