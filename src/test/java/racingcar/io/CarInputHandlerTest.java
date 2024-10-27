package racingcar.io;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarInputHandlerTest {

    CarInputHandler carInputHandler = new CarInputHandler();

    @DisplayName("이름이 입력되지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",,"})
    void 공백입력_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> carInputHandler.splitNamesByComma(input));
    }

    @DisplayName("공백이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void 아무것도_입력되지_않는_경우(String input) {
        assertThrows(IllegalArgumentException.class, () -> carInputHandler.splitNamesByComma(input));
    }


    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 숫자가_입력될_경우() {
        assertThrows(IllegalArgumentException.class, () -> carInputHandler.convertToInt("!"));
    }
}
