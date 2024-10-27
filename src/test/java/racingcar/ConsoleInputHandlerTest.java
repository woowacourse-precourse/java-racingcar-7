package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.io.ConsoleInputHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleInputHandlerTest {

    private ConsoleInputHandler consoleInputHandler;

    @BeforeEach
    void setUp() {
        consoleInputHandler = new ConsoleInputHandler();
    }

    @Test
    @DisplayName("자동차 이름을 입력받고 올바르게 파싱한다.")
    void testGetCarInput() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<String> carNames = consoleInputHandler.parseCarInput(input);

        // then
        assertEquals(List.of("pobi", "woni", "jun"), carNames);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 예외를 던진다.")
    void testInvalidCarNameLength() {
        // given
        String input = "pobiwoni,jun";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            consoleInputHandler.parseCarInput(input);
        });
    }
}
