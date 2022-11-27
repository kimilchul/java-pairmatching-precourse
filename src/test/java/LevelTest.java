import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.Course;
import pairmatching.Level;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LevelTest {
    private static Stream<Arguments> provideCorrectLevel() {
        return Stream.of(
                Arguments.of("레벨1", Level.LEVEL1),
                Arguments.of("레벨3", Level.LEVEL3),
                Arguments.of("레벨5", Level.LEVEL5)
        );
    }

    @DisplayName("올바른 문자열이 제공될 시 Level이 생성됨")
    @MethodSource("provideCorrectLevel")
    @ParameterizedTest
    void LevelCreateTest(String level, Level expectedLevel) {
        assertThat(Level.makeLevel(level)).isEqualTo(expectedLevel);
    }

    private static Stream<Arguments> provideIncorrectLevel() {
        return Stream.of(
                Arguments.of("레벨"),
                Arguments.of("레벨0벨"),
                Arguments.of("수리검"),
                Arguments.of("LEVEL1")
        );
    }

    @DisplayName("올바르지 않은 문자열이 제공될 시 예외가 발생함")
    @MethodSource("provideIncorrectLevel")
    @ParameterizedTest
    void LevelCreateFailTest(String level) {
        assertThatThrownBy(() -> {
            Level.makeLevel(level);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
