package fileio;

import java.io.*;

public class FileIOTest {

    public static void main(String[] args) {

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

        new Thread(()->{
            FileInputStream in1 = null;
            long startTime1 = System.currentTimeMillis();
            FileIOTest.singleStream(in1, out1);
            long endTime1 = System.currentTimeMillis();
            System.out.println("不使用缓冲区单字节复制耗时:" + (endTime1 - startTime1) + "ms");
        }).start();

        new Thread(()->{
            long startTime2 = System.currentTimeMillis();
            FileIOTest.arrayStream(in2, out2);
            long endTime2 = System.currentTimeMillis();
            System.out.println("不使用缓冲区字节数组复制耗时:" + (endTime2 - startTime2) + "ms");
        }).start();

        new Thread(()->{
            long startTime3 = System.currentTimeMillis();
            FileIOTest.singleBufferStream(in3, out3, bis1, bos1);
            long endTime3 = System.currentTimeMillis();
            System.out.println("使用缓冲区单字节复制耗时:" + (endTime3 - startTime3) + "ms");
        }).start();

       new Thread(()->{
           long startTime4 = System.currentTimeMillis();
           FileIOTest.bufferStream(in4, out4, bis2, bos2);
           long endTime4 = System.currentTimeMillis();
           System.out.println("使用缓冲区字节数组复制耗时:" + (endTime4 - startTime4) + "ms");
       }).start();


    }

    public static void singleStream(FileInputStream in, FileOutputStream out) {
        try {
            in = new FileInputStream("GOMS正向订单流程图.jpg");
            out = new FileOutputStream("Copy1.jpg");
            int len = 0;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void arrayStream(FileInputStream in, FileOutputStream out) {
        try {
            in = new FileInputStream("GOMS正向订单流程图.jpg");
            out = new FileOutputStream("Copy2.jpg");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void singleBufferStream(FileInputStream in, FileOutputStream out, BufferedInputStream bis, BufferedOutputStream bos) {

        try {
            in = new FileInputStream("GOMS正向订单流程图.jpg");
            out = new FileOutputStream("Copy3.jpg");
            bis = new BufferedInputStream(in);
            bos = new BufferedOutputStream(out);
            int len = 0;
            while ((len = bis.read()) != -1) {
                bos.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void bufferStream(FileInputStream in, FileOutputStream out, BufferedInputStream bis, BufferedOutputStream bos) {

        try {
            in = new FileInputStream("GOMS正向订单流程图.jpg");
            out = new FileOutputStream("Copy4.jpg");
            bis = new BufferedInputStream(in);
            bos = new BufferedOutputStream(out);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
