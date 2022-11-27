package pairmatching;

import java.util.regex.Pattern;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public static Level makeLevel(String level){
        for (Level target : Level.values()) {
            String name = target.name;
            if (name.equals(level)) {
                return target;
            }
        }

        throw new IllegalArgumentException("[ERROR] 존재하지 않는 레벨입니다.");
    }
}