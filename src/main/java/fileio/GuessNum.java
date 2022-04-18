package fileio;

import java.util.Random;

public class GuessNum {
    private int targetNum;

    public GuessNum() {
        Random random = new Random();
        this.targetNum = random.nextInt(100) + 1;
    }

    public boolean startGame(int guessNum) {
        if (guessNum > 100 || guessNum < 0) {
            System.out.println("请输入1-100范围的数字");
            return false;
        }
        if (guessNum > targetNum) {
            System.out.println("数字:" + guessNum + "比目标数字大");
            return false;
        } else if (guessNum < targetNum) {
            System.out.println("数字:" + guessNum + "比目标数字小");
            return false;
        } else {
            System.out.println("恭喜你猜对了!");
            return true;
        }
    }

}
