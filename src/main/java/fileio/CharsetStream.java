package fileio;

import java.io.*;

public class CharsetStream {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = null;
        OutputStreamWriter writer = null;
        BufferedReader reader1 = null;
        BufferedWriter writer1 = null;
        long startTime;
        long endTime;

//        startTime = System.currentTimeMillis();
//        singleCharCopy(reader, writer);
//        endTime = System.currentTimeMillis();
//        System.out.println("单字符流复制耗时：" + (endTime - startTime) + "ms");

//        startTime = System.currentTimeMillis();
//        charArrayCopy(reader, writer);
//        endTime = System.currentTimeMillis();
//        System.out.println("字符数组复制耗时：" + (endTime - startTime) + "ms");

//        startTime = System.currentTimeMillis();
//        singleBufferCopy(reader1, writer1);
//        endTime = System.currentTimeMillis();
//        System.out.println("字符流缓冲区单字符复制耗时：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        bufferCopy(reader1, writer1);
        endTime = System.currentTimeMillis();
        System.out.println("字符流缓冲区字符数组复制耗时：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        newBufferCopy(reader1, writer1);
        endTime = System.currentTimeMillis();
        System.out.println("字符数组新功能复制耗时：：" + (endTime - startTime) + "ms");
    }

    //单个字符复制
    public static void singleCharCopy(InputStreamReader reader, OutputStreamWriter writer) throws FileNotFoundException {
        reader = new InputStreamReader(new FileInputStream("/Users/mins.chen/IdeaProjects/watsonsmmp/src/main/java/fileio/CharsetStream.java"));
        writer = new OutputStreamWriter(new FileOutputStream("copy.java"));
        int len = 0;
        try {
            while ((len = reader.read()) != -1) {
                writer.write(len);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //字符数组复制
    public static void charArrayCopy(InputStreamReader reader, OutputStreamWriter writer) throws FileNotFoundException {
        reader = new InputStreamReader(new FileInputStream("/Users/mins.chen/IdeaProjects/watsonsmmp/src/main/java/fileio/CharsetStream.java"));
        writer = new OutputStreamWriter(new FileOutputStream("copy.java"));
        int len = 0;
        char[] chars = new char[1024];
        try {
            while ((len = reader.read(chars)) != -1) {
                writer.write(chars, 0, len);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //字符缓冲区
    public static void singleBufferCopy(BufferedReader reader, BufferedWriter writer) throws IOException {
        reader = new BufferedReader(new FileReader("/Users/mins.chen/IdeaProjects/watsonsmmp/src/main/java/fileio/CharsetStream.java"));
        writer = new BufferedWriter(new FileWriter("copy.java"));
        int len = 0;
        try {
            while ((len = reader.read()) != -1) {
                writer.write(len);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //字符数组缓冲区
    public static void bufferCopy(BufferedReader reader, BufferedWriter writer) throws IOException {
        reader = new BufferedReader(new FileReader("/Users/mins.chen/IdeaProjects/watsonsmmp/src/main/java/fileio/CharsetStream.java"));
        writer = new BufferedWriter(new FileWriter("copy.java"));
        int len = 0;
        char[] chars = new char[1024];
        try {
            while ((len = reader.read(chars)) != -1) {
                writer.write(chars, 0, len);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //字符数组缓冲区新功能
    public static void newBufferCopy(BufferedReader reader, BufferedWriter writer) throws IOException {
        reader = new BufferedReader(new FileReader("/Users/mins.chen/IdeaProjects/watsonsmmp/src/main/java/fileio/CharsetStream.java"));
        writer = new BufferedWriter(new FileWriter("copy.java"));
        String s;
        try {
            while ((s = reader.readLine()) != null) {
                writer.write(s);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {

                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {

                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
