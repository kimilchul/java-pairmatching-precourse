package pairmatching;

public enum Mission {
    CAR_RACE("자동차경주",Level.LEVEL1),
    LOTTERY("로또",Level.LEVEL1),
    NUMBER_BASEBALL("숫자야구게임",Level.LEVEL1),
    WISHLIST("장바구니",Level.LEVEL2),
    PAYMENT("결제",Level.LEVEL2),
    SUBWAY_MAP("지하철노선도",Level.LEVEL2),
    PERFORMANCE_IMPROVEMENT("성능개선",Level.LEVEL4),
    DEPLOY("배포",Level.LEVEL4);

    private String mission;
    private Level level;

    Mission(String mission,Level level){
        this.mission = mission;
        this.level = level;
    }

    public static Mission makeMission(String mission){
        for (Mission target : Mission.values()) {
            String missionName = target.mission;
            if (missionName.equals(mission)) {
                return target;
            }
        }

        throw new IllegalArgumentException("[ERROR] 존재하지 않는 미션입니다.");
    }
}
