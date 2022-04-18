package socket;

import org.omg.CORBA.portable.InputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClientSocket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket socket = new DatagramSocket();
        while (br.lines() != null) {
            String line = br.readLine();
            byte[] bytes = line.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 12345);
            if ("886".equals(line)) {
                socket.close();
                break;
            }
            try {
                socket.send(packet);

                //接收服务端响应
                byte[] bytes1 = new byte[1024];
                DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length);
                socket.receive(packet1);
                System.out.println(new String(packet1.getData(), 0, packet1.getLength(), StandardCharsets.UTF_8));
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
