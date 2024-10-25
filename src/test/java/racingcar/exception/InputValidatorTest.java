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

    static Stream<Arguments> generateWhiteSpacesInput() {
        return Stream.of(
                Arguments.of(Arrays.asList("", "")),
                Arguments.of(Arrays.asList("", "5")),
                Arguments.of(Arrays.asList("pobi,woni,jun", ""))
        );
    }
}