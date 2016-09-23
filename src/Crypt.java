import java.util.Scanner;

/**
 * Created by magnus on 2016-09-23.
 */
public class Crypt {
    public static void main(String[] args) {
        String text;
        int key;
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv in text som ska krypteras:");
        text = in.nextLine();
        System.out.println("Ange den nyckel som ska användas i krypteringen:");
        key = in.nextInt();

        String crypted = crypt(text, key);
        System.out.println("Den krypterade texten:\n" + crypted);

        String decrypted = decrypt(crypted, key);
        System.out.println("Den dekrypterade texten:\n" + decrypted);
    }

    private static String decrypt(String crypted, int key) {
        String result = "";
        for (int i = 0; i < crypted.length(); i++) {
            char char_text = crypted.charAt(i);
            if (char_text == 197) {
                char_text = (char) (91);
            }
            else if (char_text == 196) {
                char_text = (char) (92);
            }
            else if (char_text == 214) {
                char_text = (char) (93);
            }
            else if (char_text == 229) {
                char_text = (char) (123);
            }
            else if (char_text == 228) {
                char_text = (char) (124);
            }
            else if (char_text == 246) {
                char_text = (char) (125);
            }

            if (char_text > 125) {
                char_text = (char) (97 + key);
            }
            result += (char) (char_text - key);
        }
            return result;
        }


    private static String crypt(String text, int key) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char char_text = text.charAt(i);
            if (char_text + key == 91) {
                char_text = (char) (197 - key);
            }
            else if (char_text + key == 92) {
                char_text = (char) (196 - key);
            }
            else if (char_text + key == 93) {
                char_text = (char) (214 - key);
            }
            else if (char_text + key == 123) {
                char_text = (char) (229 - key);
            }
            else if (char_text + key == 124) {
                char_text = (char) (228 - key);
            }
            else if (char_text + key == 125) {
                char_text = (char) (246 - key);
            }

            if (char_text + key > 125) {
                char_text = (char) (97 - key);
            }
            result += (char) (char_text + key);
        }
        return result;
    }
}
