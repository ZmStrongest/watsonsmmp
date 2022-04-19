package proxy;

import java.io.*;

public class Serviceimpl implements Service{

    public void singleStream(FileInputStream in, FileOutputStream out) {
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

    public  void arrayStream(FileInputStream in, FileOutputStream out) {
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

    public  void singleBufferStream(FileInputStream in, FileOutputStream out, BufferedInputStream bis, BufferedOutputStream bos) {

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

    public  void bufferStream(FileInputStream in, FileOutputStream out, BufferedInputStream bis, BufferedOutputStream bos) {

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
