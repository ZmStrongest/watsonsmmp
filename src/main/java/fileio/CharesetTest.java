package fileio;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class CharesetTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = "中国".getBytes("GBK");

        for (byte b : bytes) {
            System.out.print((int) b + " ");
        }

    }
}
