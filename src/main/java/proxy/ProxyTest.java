package proxy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ProxyTest {

    public static void main(String[] args) {
        FileInputStream in1 = null;
        FileInputStream in2 = null;
        FileInputStream in3 = null;
        FileInputStream in4 = null;
        FileOutputStream out1 = null;
        FileOutputStream out2 = null;
        FileOutputStream out3 = null;
        FileOutputStream out4 = null;
        BufferedInputStream bis1 = null;
        BufferedInputStream bis2 = null;
        BufferedOutputStream bos1 = null;
        BufferedOutputStream bos2 = null;

        Serviceimpl serviceimpl = new Serviceimpl();
        Service proxyService = ProxyService.getProxy(serviceimpl);
        proxyService.bufferStream(in1, out1, bis1, bos1);

    }

}
