package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CrewRepositoryTest {
    @DisplayName("테스트 파일을 불러와 줄 단위로 리스트에 저장한다")
    @Test
    void loadFileAndSaveIntoList() {
        //given
        CrewRepository crewRepository = new CrewRepository();
        List<String> answer = List.of("보노",
                "시저",
                "쉐리",
                "신디",
                "다비",
                "덴버",
                "이브",
                "제시",
                "라라",
                "린다",
                "리사",
                "니콜",
                "로드",
                "윌터",
                "제키");

        //when
        List<String> frontendCrews = crewRepository.getCrews("frontend-crew.md");

        //then
        assertThat(frontendCrews).isEqualTo(answer);
    }
}
