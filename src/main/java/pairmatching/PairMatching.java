package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class PairMatching {
    private Course course;
    private Level level;
    private Mission mission;

    private List<String> crews;

    CrewRepository crewRepository = new CrewRepository();

    public PairMatching(PairMatchingDto dto){
            this.course = dto.getCourse();
            this.level = dto.getLevel();
            this.mission = dto.getMission();

            this.crews = crewRepository.getCrews(course.getFileName());
    }

    public List<String> getShuffledCrews(){
        return Randoms.shuffle(this.crews);
    }
}
