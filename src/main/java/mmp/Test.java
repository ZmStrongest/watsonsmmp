package mmp;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
//        System.out.println(("12006198749".hashCode() & Integer.MAX_VALUE) % 80);
        String cardNo = "612001032418720666";
        String subCardNo = cardNo.substring(6,14);
        long realNo = Long.parseLong(subCardNo);
        System.out.println(subCardNo);
        System.out.println(realNo % 20);


    }
}
