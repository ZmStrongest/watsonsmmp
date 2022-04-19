package proxy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public interface Service {

    void singleStream(FileInputStream in, FileOutputStream out);

    void arrayStream(FileInputStream in, FileOutputStream out);

    void singleBufferStream(FileInputStream in, FileOutputStream out, BufferedInputStream bis, BufferedOutputStream bos);

    void bufferStream(FileInputStream in, FileOutputStream out, BufferedInputStream bis, BufferedOutputStream bos);

}
