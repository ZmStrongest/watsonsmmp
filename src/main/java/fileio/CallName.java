package fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CallName {

    public static void main(String[] args) throws IOException {
        ArrayList<String> stuList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("点名册.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            stuList.add(line);
        }
        reader.close();

        Random random = new Random();
        int stuIndex = random.nextInt(stuList.size());
        System.out.println(stuList.get(stuIndex)+"同学请回答问题。");

    }
}
