package de.aeschool.hashgenerator.crypto;

import de.aeschool.hashgenerator.log.Log;

import java.security.MessageDigest;

public class Hash {
    public static String md5(byte[] data) {
        return generateHash(data, "MD5");
    }

    public static String sha1(byte[] data) {
        return generateHash(data, "SHA-1");
    }

    public static String sha256(byte[] data) {
        return generateHash(data, "SHA-256");
    }

    private static String generateHash(byte[] data, String hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType);
            md.update(data);

            return toHexString(md.digest());
        } catch (Exception e) {
            Log.e(e);

            return "An error occurred";
        }
    }

    private static String toHexString(byte[] data) {
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(0xFF & data[i]);

            if (hex.length() == 1) {
                hexString.append("0");
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }
}
