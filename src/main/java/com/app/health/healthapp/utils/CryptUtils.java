package com.app.health.healthapp.utils;

import org.apache.commons.codec.binary.Base64;

public class CryptUtils {
    public static String encrypt(String original) {
        String encryptedString = null;
        try {
            byte[] encodedBytes = Base64.encodeBase64(original.getBytes());
            encryptedString = new String(encodedBytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return encryptedString;
    }

    public static String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
            byte[] encodedBytes = encryptedString.getBytes();
            decryptedText = new String(Base64.decodeBase64(encodedBytes));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return decryptedText;
    }
}
