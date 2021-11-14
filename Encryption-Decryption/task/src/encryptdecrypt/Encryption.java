package encryptdecrypt;

class Encryption implements EncryptionDecryption {
    @Override
    public String processingDataUnicode(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append((char) (text.charAt(i) + key));
        }
        return result.toString();
    }

    @Override
    public String processingDataShift(String text, int key) {
        StringBuilder sb = new StringBuilder();
        char a, z;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLowerCase(text.charAt(i))) {
                a = 'a';
                z = 'z';
            } else {
                a = 'A';
                z = 'Z';
            }
            sb.append(getShiftChar(a, z, text.charAt(i), key));
        }
        return sb.toString();
    }

    private static char getShiftChar(char a, char z, char ch, int key) {
        int temp = (ch + key - 1) % z + a;
        if (ch < a || ch > z) {
            return ch;
        }
        if (ch + key <= z) {
            return (char) (ch + key);
        } else {
            return (char) temp;
        }
    }
}
