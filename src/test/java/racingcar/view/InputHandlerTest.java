package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputHandlerTest {
    @ParameterizedTest
    @CsvSource(value = {"'pobi,pobi,jun'", "'123,pobi,123'", "'k1,k1'"})
    void 중복된_이름이_있는_경우_예외처리(String input) {
        InputHandler inputHandler = new InputHandler();

        assertThatThrownBy(() ->
                inputHandler.validateUniqueNames(input)).isInstanceOf(IllegalArgumentException.class);
    }
}