package efun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class GenPWDTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = (ArrayList<String>) getPwd(6,2);
        System.out.println(arrayList);
    }

    public static List<String> getPwd(int length, int num) {
        ArrayList<String> pwdArrays = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            String str = "";
            for (int j = 0; j < length; j++) {
                String strOrNum = String.valueOf(random.nextInt(2) % 2 == 0 ? "Char":"Num");
                if (strOrNum.equals("Num")){
                    str += random.nextInt(10);
                }else{
                    char randomChar = (char) (random.nextInt(2) % 2 == 0 ? 65 : 97);
                    str += (char)(randomChar + random.nextInt(26));
                }

            }
            pwdArrays.add(str);
        }
        return pwdArrays;
    }
}
