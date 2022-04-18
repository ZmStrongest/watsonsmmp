package generic;

public class ArgsDemo {
    public static void main(String[] args) {
        int a = 0;
        int b = 2;
        System.out.println("a:" + a + " b:" + b);
        changeArgs(a, b);
        System.out.println("a:" + a + " b:" + b);
    }

    public static void changeArgs(int a, int b) {
        a = 5;
        b = 5;
        System.out.println("a:" + a + " b:" + b);
    }
}
