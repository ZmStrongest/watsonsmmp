package mmp;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AESUtil8 {

    private static final String AES_CIPHER = "AES/GCM/NoPadding";

    private static final String AES_ALGORITHM = "AES";

    private static final int GCM_TAG_LENGTH = 128;

    public static byte[] encrypt(byte[] plainTextBytes, String key, String iv) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance(AES_CIPHER);

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), AES_ALGORITHM);

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv.getBytes());

        // Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Encryption
        return cipher.doFinal(plainTextBytes);
    }

    public static String encrypt(String plainText, String key, String iv)
            throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(encrypt(plainText.getBytes("utf-8"), key, iv));
    }

    public static byte[] decrypt(byte[] cipherTextBytes, String key, String iv) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance(AES_CIPHER);

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), AES_ALGORITHM);

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv.getBytes());

        // Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Decryption
        return cipher.doFinal(cipherTextBytes);
    }

    public static String decrypt(String cipherText, String key, String iv) throws
            NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        return new String(decrypt(Base64.getDecoder().decode(cipherText), key, iv), "utf-8");
    }

    public static void main(String[] args) throws Exception {
        List<String> objects = new ArrayList<>();
        //objects.add("O1HF1pHVNZwTEcQhRtlaJj/mn3poX78KNqZt6VM1ELD96kJHn2Gus6DZpoJP4DjlzJ8b8A==");
        //objects.add("OHu01ZP4LcMXRoMgQckEICT9nyc1Iso/A9sNqipSEPfn+1UNazuf0Kvj6Ke6QR5iTpriw3P+fyw=");
        //objects.add("O1HFy5HVNZwTEbkvQNlaGRLLsWg7HLUPNtYf1GkmIfzd4FcPUGIXi3yp7AqgLqUZTSReZw==");
        objects.add("O1G00pP4St0ZEYMgQNlZIkPVkydIVdIOHqVy0HFfE/P41w5FoTmJ3YajNHhUCMc6bepcrA==");
        //objects.add("O1G00pP4St0ZEYMgQNlZIkPVkydIVdIOHqVy0HFfE/P41w5FoTmJ3YajNHhUCMc6bepcrA==");

        //uat密钥
//        String a = "v6DhzUGM8G2k3TvVtYN4S7Q6qyAW84X8";
//        String b = "scwUhZHYP6ZnLhnTq6sgXtuLT54JUFZ5";
//        String c = "Tna8BYnb3ZCoatMF2rDjmaaNhjtbVEAC";
//        String d = "yf38LzBC6BF4U4Bvb6Q7pC3DSdbs8Fiw";

        //prd密钥
        String a = "mN98mTjOtV4PkNaD5WnyGCSkRvl5GLcF";
        String b = "1Qu4Bd8CnaxGp6wfCm2oVYSf4Nl2vybb";
        String c = "UuIxqZGqG90uq7P0UbgN6ay8WY4ctfSC";
        String d = "dJaxWQNXVpr5fwPejVNd3ws0JL8LVMCA";

        for (String s : objects) {
            System.out.println(decrypt(decrypt(s, c, d), a, b));
        }

    }


}
