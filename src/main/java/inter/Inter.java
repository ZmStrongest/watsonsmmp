package inter;

public interface Inter {
    void show1();

    void show2();

    default void show3(){
        System.out.println("Interface show Three");
    }
}
