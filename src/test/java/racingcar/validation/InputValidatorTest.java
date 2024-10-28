package racingcar.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeAll
    static void setup() {
        inputValidator = new InputValidator();
    }

    @DisplayName("빈 입력값이나 공백 입력값에 대해 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidInputData")
    void validateEmptyOrWhitespaceInput(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.carNames(List.of(input)))
                .withMessage(ErrorMessage.NAME_CANNOT_BE_EMPTY.getMessage());
    }

    @DisplayName("잘못된 구분자가 연속으로 올 때 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidDelimiterData")
    void validateInvalidDelimiterUsage(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.checkDelimiter(input))
                .withMessage(ErrorMessage.DELIMITER_CANNOT_BE_CONSECUTIVE.getMessage());
    }

    @DisplayName("자동차 이름의 길이가 초과되거나 중복된 이름에 대해 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidCarNamesData")
    void validateCarNamesLengthAndDuplication(List<String> carNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.carNames(carNames));
    }

    @DisplayName("음수 시도 횟수에 대해 예외를 던진다")
    @ParameterizedTest
    @MethodSource("negativeAttemptCounts")
    void validateNegativeAttemptCount(int attempts) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.attemptCount(attempts))
                .withMessage(ErrorMessage.INVALID_ATTEMPT_COUNT.getMessage());
    }

    @DisplayName("최대 시도 횟수를 초과할 경우 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidAttemptCounts")
    void validateAttemptCount(int attempts) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.attemptCount(attempts))
                .withMessage(ErrorMessage.MAX_ATTEMPTS_EXCEEDED.getMessage());
    }

    static Stream<Arguments> invalidInputData() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("   ")
        );
    }

    static Stream<Arguments> invalidDelimiterData() {
        return Stream.of(
                Arguments.of("car1,,car2"),
                Arguments.of(",,car1,car2"),
                Arguments.of("car1,car2,,")
        );
    }

    static Stream<Arguments> invalidCarNamesData() {
        return Stream.of(
                Arguments.of(List.of("car1", "car1", "car2")),
                Arguments.of(List.of("car12345", "car2")),
                Arguments.of(List.of("car1", "car2", "car3", "car4", "car5", "car6"))
        );
    }

    static Stream<Arguments> invalidAttemptCounts() {
        return Stream.of(
                Arguments.of(11),
                Arguments.of(20)
        );
    }

    static Stream<Arguments> negativeAttemptCounts() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-10),
                Arguments.of(-100)
        );
    }
}
