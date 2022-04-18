package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClientSocket {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getLocalHost(), 12345);
        simpleTcpTest(s);
//        uploadFiles(s);
    }

    //常规TCP练习
    public static void simpleTcpTest(Socket s) {
        OutputStream outputStream = null;
        try {
            outputStream = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (br.lines() != null) {
                String line = br.readLine();
                if ("886".equals(line))
                    break;
                byte[] bytes = line.getBytes(StandardCharsets.UTF_8);
                outputStream.write(bytes, 0, bytes.length);


            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //上传文件到服务端
    public static void uploadFiles(Socket s) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("GOMS正向订单流程图.jpg"));
        byte[] bytes = new byte[1024];
        int len = 0;
        OutputStream out = s.getOutputStream();
        while ((len = bis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
            out.flush();
        }

        s.shutdownOutput();

        //接收服务端反馈
        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
        s.close();
    }


}
