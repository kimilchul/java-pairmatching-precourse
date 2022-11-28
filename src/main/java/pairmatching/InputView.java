package pairmatching;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;

public class InputView {
    //과정, 레벨, 미션을 입력받음 : 프론트엔드, 레벨1, 자동차경주
    public PairMatchingDto readPairMatching(){
        StringTokenizer st = new StringTokenizer(Console.readLine());

        Course course = Course.makeCourse(st.nextToken());
        Level level = Level.makeLevel(st.nextToken());
        Mission mission = Mission.makeMission(st.nextToken());

        return new PairMatchingDto(course,level,mission);
    }
}
