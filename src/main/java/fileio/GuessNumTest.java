package fileio;

import com.sun.javafx.binding.StringFormatter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class GuessNumTest {
    public static void main(String[] args) {
        GuessNum game = new GuessNum();

        Properties properties = new Properties();
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("config.properties");
            properties.load(reader);
            int count = Integer.parseInt(properties.getProperty("count"));
            if (count > 2) {
                System.out.println("游戏试用次数不足(小于3)，请充值");
            }
            if (count >= 0 && count < 3) {
                boolean isGameOver = false;
                while (!isGameOver) {
                    System.out.println("请输入数字:");
                    Scanner scanner = new Scanner(System.in);
                    try {
                        int guessNum = scanner.nextInt();
                        isGameOver = game.startGame(guessNum);
                    } catch (InputMismatchException e) {
                        System.out.println("请输入正确的数字!");
                        isGameOver = false;
                    }
                }
                properties.setProperty("count", String.valueOf(count + 1));
                writer = new FileWriter("config.properties");
                properties.store(writer, "游戏次数");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
