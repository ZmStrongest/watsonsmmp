package fileio;

import java.io.*;

public class CopyDirectory {
    public static void main(String[] args) {
        File in = new File("/Users/mins.chen/Documents/eFun卡");
        File out = new File("/Users/mins.chen/Downloads");
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        copyDirectory(in, out);
        endTime = System.currentTimeMillis();
        System.out.println("复制文件夹耗时：" + (endTime - startTime) + "ms");
    }

    //复制文件夹
    public static void copyDirectory(File existFiles, File copyFiles) {
        if (existFiles.isDirectory()) {
            String srcName = existFiles.getName();
            File newFolder = new File(copyFiles, srcName);
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }
            File[] files = existFiles.listFiles();
            for (File file : files) {
                copyDirectory(file, newFolder);
            }
        } else {
            File newFile = new File(copyFiles, existFiles.getName());
            copyFiles(existFiles, newFile);
        }


    }

    //复制文件
    public static void copyFiles(File existFile, File copyFiles) {
        FileInputStream in = null;
        FileOutputStream out = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            in = new FileInputStream(existFile);
            out = new FileOutputStream(copyFiles);
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
