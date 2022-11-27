package pairmatching;

import java.util.regex.Pattern;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public static Course makeCourse(String course) {
        validate(course);

        for (Course target : Course.values()) {
            String name = target.name;
            if (name.equals(course)) {
                return target;
            }
        }

        throw new IllegalArgumentException("[ERROR] 존재하지 않는 과정입니다.");
    }

    private static void validate(String course) {
        if (!Pattern.matches("^[가-힣]*$", course)) {
            throw new IllegalArgumentException("[ERROR] 과정명으로 한글만 입력해 주세요.");
        }
    }
}