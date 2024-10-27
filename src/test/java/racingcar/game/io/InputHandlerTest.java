package racingcar.game.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {
    private final InputHandler inputHandler = new InputHandler();

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3", "abc,def,ghi", "car1"})
    @DisplayName("자동차 이름 입력 성공 케이스")
    void getCarNames_ValidInput(String input) {
        assertDoesNotThrow(() -> inputHandler.validateInputCarNames(input));
    }

    @Test
    @DisplayName("자동차 이름 입력 예외 케이스 - 빈 문자열")
    void getCarNames_BlankInput() {
        assertThrows(IllegalArgumentException.class, () -> inputHandler.validateInputCarNames(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    @DisplayName("시도 횟수 입력 성공 케이스")
    void getRacingCount_ValidInput(String input) {
        assertEquals(Integer.parseInt(input), inputHandler.convertToInteger(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "", "!!"})
    @DisplayName("시도 횟수 입력 예외 케이스")
    void getRacingCount_InvalidInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> inputHandler.convertToInteger(input));
    }
}