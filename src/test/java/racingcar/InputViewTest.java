package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;


class InputViewTest {
    @ParameterizedTest
    @MethodSource("invalidInputs")
    void inputNumberOfAttempts(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertThatThrownBy(() -> InputView.inputNumberOfAttempts())
                .isInstanceOf(IllegalArgumentException.class);

    }
    static Stream<String> invalidInputs() {
        return Stream.of("-1"," ","$","adf");
    }

}