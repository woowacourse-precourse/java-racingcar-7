package racingcar.ui;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputCarNamesTest {

    @ParameterizedTest
    @MethodSource("legalArguments")
    void 자동차이름_입력형식(final String input) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> InputCarNames.of(input));
    }

    @ParameterizedTest
    @MethodSource("illegalArguments")
    void 자동차이름_입력형식_에러(final String input) {
        Assertions.assertThatThrownBy(() -> InputCarNames.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> legalArguments() {
        return Stream.of(
                Arguments.of("test,12,34"),
                Arguments.of(" test, 12 ,34")
        );
    }

    static Stream<Arguments> illegalArguments() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("  "),
                Arguments.of(","),
                Arguments.of(",, ,"),
                Arguments.of(" , "),
                Arguments.of(", ,")
        );
    }
}