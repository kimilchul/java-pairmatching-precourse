package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    private void shuffledCrews(){
        this.crews = Randoms.shuffle(this.crews);
    }

    public List<List<String>> matchMaking(){
        shuffledCrews();
        List<List<String>> matchedCrews = new LinkedList<>();
        Stack<String> stack = new Stack();
        Iterator<String> crew = crews.listIterator();
        while (crew.hasNext()){
            stack.push(crew.next());
            if (stack.size()==2){
                List<String> pair = List.of(stack.pop(),stack.pop());
                matchedCrews.add(pair);
            }
        }
        if (!stack.isEmpty()){
            matchedCrews.get(matchedCrews.size()-1).add(stack.pop());
        }
        return  matchedCrews;
    }
}
