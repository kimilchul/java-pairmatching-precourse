package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CourseTest {
    private static Stream<Arguments> provideCorrectCourseName() {
        return Stream.of(
                Arguments.of("프론트엔드", Course.FRONTEND),
                Arguments.of("백엔드", Course.BACKEND)
        );
    }

    @DisplayName("올바른 문자열이 제공될 시 Course가 생성됨")
    @MethodSource("provideCorrectCourseName")
    @ParameterizedTest
    void CourseCreateTest(String course, Course expectedCourse) {
        assertThat(Course.makeCourse(course)).isEqualTo(expectedCourse);
    }

    private static Stream<Arguments> provideIncorrectCourseName() {
        return Stream.of(
                Arguments.of("프론트드"),
                Arguments.of("백드"),
                Arguments.of("backend"),
                Arguments.of("FRONTEND")
        );
    }

    @DisplayName("올바르지 않은 문자열이 제공될 시 예외가 발생함")
    @MethodSource("provideIncorrectCourseName")
    @ParameterizedTest
    void CourseCreateFailTest(String course) {
        assertThatThrownBy(() -> {
            Course.makeCourse(course);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
