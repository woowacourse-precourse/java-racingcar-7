package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

class InputHandlerTest {

    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @NullSource
    @ParameterizedTest
    @CsvSource(value = {"'     '", "''", "''"})
    void 문자열_null이거나_비어있는_경우_예외처리(String input) {
        assertThatThrownBy(() -> inputHandler.checkEmpty(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"'pobi,pobi,jun'", "'123,pobi,123'", "'k1,k1'"})
    void 중복된_이름이_있으면_예외처리(String input) {
        assertThatThrownBy(() -> inputHandler.validateUniqueNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @NullSource
    @ParameterizedTest
    @CsvSource(value = {"'     '", "''", "pobi"})
    void 숫자가_입력되지_않은_경우_예외처리(String input) {
        assertThatThrownBy(() -> inputHandler.validateNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "-1"})
    @DisplayName("1미만의 숫자면 예외처리")
    void testCheckMinimumCount(int input) {
        assertThatThrownBy(() -> inputHandler.checkMinimumCount(input)).isInstanceOf(IllegalArgumentException.class);
    }
}