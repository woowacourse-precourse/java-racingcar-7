package racingcar.exception;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private static final InputValidator inputvalidator = new InputValidator();

    @ParameterizedTest
    @DisplayName("공백이 입력될 경우 에러가 발생한다.")
    @MethodSource("generateWhiteSpacesInput")
    void whiteSpacesInputThrowException(List<String> input) {
        assertThatThrownBy(() -> inputvalidator.validateWhiteSpaces(input.getFirst(), input.getLast()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백이 입력되지 않으면 에러가 발생하지 않는다.")
    void whiteSpacesInputNotThrowException() {
        assertThatCode(() -> inputvalidator.validateWhiteSpaces("pobi,woni,jun", "5"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("이름의 길이가 5를 넘어갈 경우 예외가 발생한다.")
    @ValueSource(strings = {"maxwell", "pascal", "turing"})
    void invalidCarNameThrowException(String carName) {
        assertThatThrownBy(() -> inputvalidator.validateInvalidCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이름의 길이가 5를 넘어가지 않을 경우 예외가 발생하지 않는다.")
    @ValueSource(strings = {"pobi", "woni", "jun", "tesla"})
    void validCarNameNotThrowException(String carName) {
        assertThatCode(() -> inputvalidator.validateInvalidCarName(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("이동 횟수 입력 시 숫자가 아닌 문자가 들어오는 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "---", "a-b"})
    void invalidRepeatTimesThrowException(String repeatTimes) {
        assertThatThrownBy(() -> inputvalidator.validateRepeatTimesNotDigit(repeatTimes))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이동 횟수 입력 시 정상적으로 숫자가 들어오는 경우 예외가 발생하지 않는다.")
    @ValueSource(strings = {"10", "50", "100"})
    void validRepeatTimesNotThrownException(String repeatTimes) {
        assertThatCode(() -> inputvalidator.validateRepeatTimesNotDigit(repeatTimes))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> generateWhiteSpacesInput() {
        return Stream.of(
                Arguments.of(Arrays.asList("", "")),
                Arguments.of(Arrays.asList("", "5")),
                Arguments.of(Arrays.asList("pobi,woni,jun", ""))
        );
    }
}