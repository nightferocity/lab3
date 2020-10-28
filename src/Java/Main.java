package Java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Code cd = new Code();
        String text = "mama";
        String[] key = cd.generateKeySet(text.length(),5);
        String hex = cd.encode(text, cd.keyRecovery(key[0]));
        System.out.println(key[0] + "\n" + hex);
        System.out.println(key[2] + "\n" + cd.decode(hex, cd.keyRecovery(key[2])));
    }
}