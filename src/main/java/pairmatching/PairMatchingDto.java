package pairmatching;

public class PairMatchingDto {
    private Course course;
    private Level level;
    private Mission mission;

    public PairMatchingDto(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }
}
