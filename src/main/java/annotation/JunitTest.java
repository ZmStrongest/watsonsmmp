package annotation;

@MyJunit(value = "测试类", count = 4)
public class JunitTest {

    @MyJunit(value = "测试类show1", count = 4)
    public void showTest01(String value, int count) {
        for (int i = 1; i <= count; i++)
            System.out.println(value + "执行第" + i + "次");
    }

    @MyJunit(value = "测试类show2", count = 3)
    public void showTest02(String value, int count) {
        for (int i = 1; i <= count; i++)
            System.out.println(value + "执行第" + i + "次");
    }

    public void showTest03() {
        System.out.println("无注解标记");
    }


}
