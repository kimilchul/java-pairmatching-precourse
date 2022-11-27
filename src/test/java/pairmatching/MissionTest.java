package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MissionTest {
    private static Stream<Arguments> provideCorrectMission() {
        return Stream.of(
                Arguments.of("자동차경주", Mission.CAR_RACE),
                Arguments.of("장바구니", Mission.WISHLIST),
                Arguments.of("성능개선", Mission.PERFORMANCE_IMPROVEMENT)
        );
    }

    @DisplayName("올바른 문자열이 제공될 시 Mission이 생성됨")
    @MethodSource("provideCorrectMission")
    @ParameterizedTest
    void LevelCreateTest(String mission, Mission expectedMission) {
        assertThat(Mission.makeMission(mission)).isEqualTo(expectedMission);
    }

    private static Stream<Arguments> provideIncorrectMission() {
        return Stream.of(
                Arguments.of("장바"),
                Arguments.of("구니"),
                Arguments.of("성능 개선"),
                Arguments.of("PERFORMANCE_IMPROVEMENT")
        );
    }

    @DisplayName("올바르지 않은 문자열이 제공될 시 예외가 발생함")
    @MethodSource("provideIncorrectMission")
    @ParameterizedTest
    void LevelCreateFailTest(String mission) {
        assertThatThrownBy(() -> {
            Mission.makeMission(mission);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
