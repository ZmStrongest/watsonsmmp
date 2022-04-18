package enumb;

public enum Tier {
    ELITE_PLUS(7,"时尚教主","黑卡会员"),
    ELITE(8, "时尚达人", "目前已合并至黑卡会员"),
    BASE(4, "潮流小主", "绿卡会员"),
    TRIAL_CARD(111, "试用会员", "试用会员"),
    FANS_CARD(12, "粉丝卡", "裸卡改名为粉丝卡");


    private final int segmentNo;
    private final String segmentName;
    private final String description;

    Tier(int segmentNo, String segmentName, String description) {
        this.segmentNo = segmentNo;
        this.segmentName = segmentName;
        this.description = description;
    }

    public int getSegmentNo() {
        return segmentNo;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public String getDescription() {
        return description;
    }
}
