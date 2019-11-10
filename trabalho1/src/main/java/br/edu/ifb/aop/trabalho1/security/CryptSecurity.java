package br.edu.ifb.aop.trabalho1.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptSecurity {

    private static CryptSecurity cryptSecurity;

    private CryptSecurity() {
    }

    public static CryptSecurity getInstance() {
        if (cryptSecurity == null)
            cryptSecurity = new CryptSecurity();
        return cryptSecurity;
    }

    public String sha256(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] messageDigest = digest.digest(s.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        return hexString.toString();
    }

}
