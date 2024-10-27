package racingcar.validate;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("null이 입력되서는 안됩니다.")
    @Test
    void noNull() {
        String inputCarNames = null;

        assertThrows(IllegalArgumentException.class, () -> inputValidator.noNull(inputCarNames));
    }

    @DisplayName("빈 문자열, 공백이 입력되서는 안됩니다.")
    @MethodSource("provideNoBlankTestCases")
    @ParameterizedTest(name = "입력값: \"{0}\"")
    void noBlank(String inputCarNames) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.noBlank(inputCarNames));
    }

    @DisplayName("영어(소문자, 대문자)와 쉼표(\",\")만 입력할 수 있습니다.")
    @MethodSource("provideContainsOnlyEnglishAndCommaTestCases")
    @ParameterizedTest(name = "입력값: \"{0}\"")
    void containsOnlyEnglishAndCommaTestCases(String inputCarNames) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.containsOnlyEnglishAndComma(inputCarNames));
    }

    @DisplayName("입력한 문자열은 쉼표(\",\")로 시작해서는 안됩니다.")
    @Test
    void noStartWithComma() {
        String inputCarNames = ",pobi";

        assertThrows(IllegalArgumentException.class, () -> inputValidator.noStartWithComma(inputCarNames));
    }

    @DisplayName("입력한 문자열은 쉼표(\",\")로 끝나서는 안됩니다.")
    @Test
    void noEndWithComma() {
        String inputCarNames = "jun,";

        assertThrows(IllegalArgumentException.class, () -> inputValidator.noEndWithComma(inputCarNames));
    }

    @DisplayName("입력한 문자열은 쉼표(\",\"가 연속으로 입력되서는 안됩니다.")
    @Test
    void hasNoContinuousComma() {
        String inputCarNames = "pobi,woni,,jun";

        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.hasNoContinuousComma(inputCarNames));
    }

    @DisplayName("시도 횟수는 숫자만 입력 가능합니다.")
    @MethodSource("provideOnlyInputNumberTestCases")
    @ParameterizedTest(name = "입력값: \"{0}\"")
    void onlyInputNumber(String inputAttemptCount) {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidator.onlyInputNumber(inputAttemptCount)
        );
    }

    private static Stream<Arguments> provideNoBlankTestCases() {
        return Stream.of(
                Arguments.of(""), // 빈 문자열
                Arguments.of(" ") // 공백
        );
    }

    private static Stream<Arguments> provideContainsOnlyEnglishAndCommaTestCases() {
        return Stream.of(
                Arguments.of("pobi woni jun"), // 띄어쓰기
                Arguments.of("pobi.woni?jun"), // 다른 문자
                Arguments.of("포비,워니,준")
        );
    }

    private static Stream<Arguments> provideOnlyInputNumberTestCases() {
        return Stream.of(
                Arguments.of("pobi"), // 문자열
                Arguments.of("5.3"),          // 소수점
                Arguments.of("-5"),           // 음수
                Arguments.of("")              // empty
        );
    }
}
