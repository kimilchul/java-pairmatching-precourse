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

    private static Stream<Arguments> providedCorrectCourseName() {
        return Stream.of(
                Arguments.of("프론트엔드", Course.FRONTEND),
                Arguments.of("백엔드", Course.BACKEND)
        );
    }

    @DisplayName("올바른 문자열이 제공될 시 Course가 생성됨")
    @MethodSource("providedCorrectCourseName")
    @ParameterizedTest
    void CourseCreateTest(String course, Course expectedCourse) {
        assertThat(Course.makeCourse(course)).isEqualTo(expectedCourse);
    }
}
