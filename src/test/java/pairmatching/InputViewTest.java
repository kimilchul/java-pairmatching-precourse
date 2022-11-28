package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    InputView inputView = new InputView();

    static InputStream generateUserInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    private static Stream<Arguments> provideMatchingDtoInput() {
        return Stream.of(
                Arguments.of("백엔드, 레벨1, 자동차경주", new PairMatchingDto(Course.BACKEND,Level.LEVEL1,Mission.CAR_RACE))
        );
    }

    @DisplayName("사용자 입력에 따라 PairMatchingDto가 생성")
    @ParameterizedTest
    @MethodSource("provideMatchingDtoInput")
    void makePairMatchingDtoTest(String input,PairMatchingDto expectedDto){
        //given
        InputStream in = generateUserInput(input);
        System.setIn(in);

        //when
        PairMatchingDto inputDto = inputView.readPairMatching();

        //then
        assertThat(inputDto.getCourse()).isEqualTo(expectedDto.getCourse());
        assertThat(inputDto.getLevel()).isEqualTo(expectedDto.getLevel());
        assertThat(inputDto.getMission()).isEqualTo(expectedDto.getMission());
    }
}
