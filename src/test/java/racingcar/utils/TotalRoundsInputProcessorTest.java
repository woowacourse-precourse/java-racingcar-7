package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.*;
import static racingcar.utils.TotalRoundsInputProcessor.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class TotalRoundsInputProcessorTest {

    @DisplayName("입력 값이 빈 문자열 또는 공백인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlankInput(String input) {
        assertThatThrownBy(() -> parseTotalRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_ROUNDS_ERROR);
    }


    @DisplayName("입력 값이 0 또는 음수인 경우  - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-2", "-100"})
    void testZeroOrNegativeInput(String input) {
        assertThatThrownBy(() -> parseTotalRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_POSITIVE_ROUNDS_ERROR);
    }


    @DisplayName("입력 값이 문자인 경우  - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"아이", "2년", "1임"})
    void testStringInput(String input) {
        assertThatThrownBy(() -> parseTotalRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_ERROR);
    }


    @DisplayName("입력 값이 유효한 경우 - Integer 반환")
    @ParameterizedTest
    @MethodSource("provideValidCount")
    void testValidCount(String input, int expected) {
        Integer result = parseTotalRounds(input);
        assertEquals(expected, result);

    }

    static Stream<Arguments> provideValidCount() {
        return Stream.of(
                Arguments.of("21", 21),
                Arguments.of("1", 1),
                Arguments.of("100", 100)
        );
    }


}
