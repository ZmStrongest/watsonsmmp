package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSeverSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        while (true) {
            simpleSocketTest(ss);
//            receiveFiles(ss);
//            uploadByThread(ss);
            System.out.println("2222");
        }


    }


    //常规socket练习
    public static void simpleSocketTest(ServerSocket ss) throws IOException {
        System.out.println("11");
        Socket s = ss.accept();
        new Thread(() -> {
            try {
                InputStream inputStream = s.getInputStream();
                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    //接收文件上传
    public static void receiveFiles(ServerSocket ss) throws IOException {
        Socket s = ss.accept();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Copy.jpg"));
        InputStream in = s.getInputStream();

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
            bos.flush();
        }

        //发送服务端反馈
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        writer.write("文件上传成功!");
        writer.newLine();
        writer.flush();

    }

    //多线程防阻塞文件上传
    public static void uploadByThread(ServerSocket ss) throws IOException {

        Socket s = ss.accept();
        new Thread(() -> {
            try {
                File file = new File("Copy.jpg");
                int count = 0;
                while (file.exists()) {
                    file = new File("Cppy[" + count + "].jpg");
                    count++;
                }
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                InputStream in = s.getInputStream();

                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = in.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                    bos.flush();
                }

                //发送服务端反馈
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                writer.write("文件上传成功!");
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

    }

}
