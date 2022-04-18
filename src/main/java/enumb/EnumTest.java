package enumb;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Tier.BASE.getSegmentNo());
        for(Tier e : Tier.values()){
            System.out.println(e.getDescription());
        }
    }
}
