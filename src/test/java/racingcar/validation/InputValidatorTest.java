package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.validation.ErrorMessage.*;

public class InputValidatorTest {

    private static Stream<Arguments> provideCarNameCases() {
        return Stream.of(
                Arguments.of("abcd,abc", List.of("abcd", "abc")),
                Arguments.of("ads,abc,dsd,123", List.of("ads", "abc", "dsd", "123")),
                Arguments.of("abcd,abc,2323", List.of("abcd", "abc", "2323")),
                Arguments.of("ad,abc,12345", List.of("ad", "abc", "12345")),
                Arguments.of("ad,abc,김bc1", List.of("ad", "abc", "김bc1"))
        );
    }

    private static Stream<Arguments> provideCarNameExceptionCases() {
        return Stream.of(
                Arguments.of("abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc,abc", CAR_NAME_COUNT_ERROR),
                Arguments.of("abc,abc", CAR_NAME_COUNT_ERROR),
                Arguments.of("abc", CAR_NAME_COUNT_ERROR),
                Arguments.of("", CAR_NAME_COUNT_ERROR),
                Arguments.of("abc,", CAR_NAME_COUNT_ERROR),
                Arguments.of("abcdef", CAR_NAME_COUNT_ERROR),
                Arguments.of("abc,abcdefg", CAR_NAME_LENGTH_ERROR),
                Arguments.of("abc,a bc", CAR_NAME_FORMAT_ERROR),
                Arguments.of("1###,1@,1\n234", CAR_NAME_FORMAT_ERROR)
        );
    }

    private static Stream<Arguments> provideGameCountCases() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("2", 2),
                Arguments.of("9999", 9999)
        );
    }

    private static Stream<Arguments> provideGameCountExceptionCases() {
        return Stream.of(
                Arguments.of("abc", GAME_COUNT_FORMAT_ERROR),
                Arguments.of("#DE,", GAME_COUNT_FORMAT_ERROR),
                Arguments.of("-1", GAME_COUNT_RANGE_ERROR),
                Arguments.of("0", GAME_COUNT_RANGE_ERROR),
                Arguments.of("99999999", GAME_COUNT_RANGE_ERROR)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCarNameCases")
    @DisplayName("자동차 이름 입력 검증 테스트")
    public void validateCarNameTest(String test, List<String> expected) {
        assertEquals(expected, InputValidator.validateCarNameAndReturn(test));
    }

    @ParameterizedTest
    @MethodSource("provideCarNameExceptionCases")
    @DisplayName("자동차 이름 입력 에러메시지 테스트")
    public void validateCarNameExceptionTest(String test, String expected) {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNameAndReturn(test));
        assertEquals(expected, thrownException.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideGameCountCases")
    @DisplayName("시도할 횟수 입력 검증 테스트")
    public void validateGameCountTest(String test, int expected){
        assertEquals(expected, InputValidator.validateGameCountAndReturn(test));
    }

    @ParameterizedTest
    @MethodSource("provideGameCountExceptionCases")
    @DisplayName("시도할 횟수 입력 에러메시지 테스트")
    public void validateGameCountExceptionTest(String test, String expected) {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameCountAndReturn(test));
        assertEquals(expected, thrownException.getMessage());
    }
}
