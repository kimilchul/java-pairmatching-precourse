package pairmatching;

import java.util.regex.Pattern;

public enum Course {
    BACKEND("백엔드","backend-crew.md"),
    FRONTEND("프론트엔드","frontend-crew.md");

    private String name;
    private String fileName;

    Course(String name,String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public String getFileName(){
        return fileName;
    }

    public static Course makeCourse(String course) {
        for (Course target : Course.values()) {
            String name = target.name;
            if (name.equals(course)) {
                return target;
            }
        }

        throw new IllegalArgumentException("[ERROR] 존재하지 않는 과정입니다.");
    }
}