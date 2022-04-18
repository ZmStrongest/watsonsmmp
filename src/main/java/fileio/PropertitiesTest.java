package fileio;

import java.io.*;
import java.util.Properties;

public class PropertitiesTest {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
//        properties.setProperty("MMP","会员中台");
//        properties.setProperty("eFun","预付卡系统");
//        properties.setProperty("myStore","云店");
//
//        properties.store(new FileWriter("config.properties"),"配置文件");

        properties.load(new FileReader("config.properties"));
        System.out.println(properties.get("MMP"));
        System.out.println(properties.get("eFun"));
        System.out.println(properties.getProperty("myStore"));


    }

}
