package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidationServiceTest {

    private final InputValidationService inputValidationService = new InputValidationService();

    @DisplayName("자동차 이름 입력 검증 기능")
    @ParameterizedTest(name = "\"{0}\" 입력 : 예외메세지 - \"{1}\"")
    @MethodSource()
    public void 자동차_이름_입력_검증(String rawCarNames, String expectedExceptionMessage) {
        assertThatThrownBy(() -> inputValidationService.validateRawCarNames(rawCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);
    }

    private static Stream<Arguments> 자동차_이름_입력_검증() {
        return Stream.of(
                Arguments.of(null, "null 값이 입력되었습니다."),
                Arguments.of("  ", "비어있는 값이 입력되었습니다."),
                Arguments.of("rc1", "자동차 1대의 이름만 입력되었습이다."),
                Arguments.of("rc1:rc2", "자동차 1대의 이름만 입력되었습이다."),
                Arguments.of(",rc1", "비어있는 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1,", "비어있는 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1,,rc2", "비어있는 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1234,rc1,rc2", "5자 이상의 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1,rc1234,rc2", "5자 이상의 자동차 이름이 입력되었습니다."),
                Arguments.of("rc1,rc2,rc1234", "5자 이상의 자동차 이름이 입력되었습니다.")
        );
    }

    @DisplayName("전진 시도 횟수 입력 검증")
    @ParameterizedTest(name = "\"{0}\" 입력 : 예외메세지 - \"{1}\"")
    @MethodSource()
    public void 전진_시도_횟수_입력_검증(String rawRoundCount, String expectedExceptionMessage) {
        assertThatThrownBy(() -> inputValidationService.validateRawRoundCount(rawRoundCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);
    }

    private static Stream<Arguments> 전진_시도_횟수_입력_검증() {
        return Stream.of(
                Arguments.of(null, "null 값이 입력되었습니다."),
                Arguments.of("  ", "비어있는 값이 입력되었습니다."),
                Arguments.of("two", "숫자가 아닌 값이 입력되었습니다."),
                Arguments.of("9999999999999", "Integer 범위를 벗어난 값이 입력되었습니다."),
                Arguments.of("-9999999999999", "Integer 범위를 벗어난 값이 입력되었습니다."),
                Arguments.of("0", "0보다 작은 값이 입력되었습니다."),
                Arguments.of("-1", "0보다 작은 값이 입력되었습니다.")
        );
    }
}