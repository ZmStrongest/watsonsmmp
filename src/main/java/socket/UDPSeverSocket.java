package socket;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPSeverSocket {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(12345);
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                socket.receive(packet);
                String s = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
                System.out.println(s);

                //响应客户端
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] response = "消息已成功接收!".getBytes(StandardCharsets.UTF_8);
                DatagramPacket dp = new DatagramPacket(response, response.length, address, port);
                socket.send(dp);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
