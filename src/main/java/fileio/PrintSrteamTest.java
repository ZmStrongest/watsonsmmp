package fileio;

import java.io.*;

public class PrintSrteamTest {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("output.java"),true);
        writer.println(545);
        writer.write("fdsf");
        writer.close();
    }
}
