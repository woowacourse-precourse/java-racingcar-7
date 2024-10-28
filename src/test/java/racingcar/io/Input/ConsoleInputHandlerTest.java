package racingcar.io.Input;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.exceptions.InvalidRoundValueException;

class ConsoleInputHandlerTest {

    @Test
    void 라운드_입력_숫자_변환_예외_테스트() {
        // Given
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        String invalidInput = "a";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));

        // When & Then
        assertThrows(InvalidRoundValueException.class, inputHandler::inputRoundNumber);
    }
}
