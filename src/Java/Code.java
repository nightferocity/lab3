package Java;

import java.util.Arrays;

public class Code {
    public String encode(String s, String key) {
        String[] keys = key.split(" ");
        String[] hex = codeToHex(s).split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < hex.length; i++) {
            res.append(Integer.toHexString(Integer.parseInt(hex[i], 16) ^ Integer.parseInt(keys[i], 16)));
            if(i != s.length() - 1)
                res.append(" ");
        }
        return res.toString();
    }

    public String codeToHex(String code) {
        StringBuilder sb = new StringBuilder();
        char[] chars = code.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(Integer.toHexString(chars[i]));
            if (i != chars.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public String decode(String s, String key) {
        String[] keys = key.split(" ");
        String[] hex = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < hex.length; i++) {
            res.append((char) (Integer.parseInt(hex[i], 16) ^ Integer.parseInt(keys[i], 16)));
        }
        return res.toString();
    }

    public String generateKey(int length){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            sb.append(Integer.toHexString((int) (Math.random() * 0xFFF)));
            if(i != length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public String[] generateKeySet(int keyLength, int keysCount){
        String[] keySet = new String[keysCount];
        String[] firstKey = generateKey(keyLength).split(" ");
        for(int i = 0; i < keysCount; i++){
            String random = Integer.toHexString((int) (Math.random() * 0xFFF));
            keySet[i] = random + " ";
            for (String s : firstKey) {
                keySet[i] += Integer.toHexString(Integer.parseInt(s, 16) ^ Integer.parseInt(random, 16));
                if (i != firstKey.length - 1)
                    keySet[i] += " ";
            }
        }
        return keySet;
    }

    public String keyRecovery(String key){
        StringBuilder sb = new StringBuilder();
        String[] keyPieces = key.split(" ");
        for(int i = 1; i < keyPieces.length; i++){
            String random = keyPieces[0];
            sb.append(Integer.toHexString(Integer.parseInt(keyPieces[i], 16) ^ Integer.parseInt(random, 16)));
            if (i != keyPieces.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

}
