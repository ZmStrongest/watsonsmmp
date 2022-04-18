package fileio;

import java.io.*;

public class SerialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Student s = new Student("林青霞", 30);
//        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("student.txt"));
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
//        objectOutputStream.writeObject(s);
//        objectOutputStream.close();

        BufferedInputStream in = new BufferedInputStream(new FileInputStream("student.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Student s = (Student) objectInputStream.readObject();
        System.out.println(s.getName()+" "+s.getAge());
    }


}
