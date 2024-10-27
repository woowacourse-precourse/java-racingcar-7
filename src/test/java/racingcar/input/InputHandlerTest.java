package racingcar.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.output.OutputHandler;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputHandlerTest {

    private static final String CAR_NAMES = "pobi,woni,jun";
    private static final String ATTEMPT_COUNT = "3";
    private static final String EMPTY_STRING = "";

    @Test
    @DisplayName("올바른 입력을 하면 예외가 발생하지 않고, 입력 값이 정상적으로 저장된다.")
    void 올바른입력() {
        // given
        InputHandler inputHandler = new InputHandler(new OutputHandler());
        String simulatedInput = CAR_NAMES + "\n" + ATTEMPT_COUNT + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // when
        UserInput userInput = inputHandler.inputCarNamesAndAttemptCount();

        // then
        assertEquals(CAR_NAMES, userInput.carNames());
        assertEquals(ATTEMPT_COUNT, userInput.attemptCount());
    }

    @Test
    @DisplayName("빈 문자열을 입력하면 예외가 발생하지 않고, 빈 값이 저장된다.")
    void 빈문자열입력() {
        // given
        InputHandler inputHandler = new InputHandler(new OutputHandler());
        String simulatedInput = EMPTY_STRING + "\n" + EMPTY_STRING + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // when
        UserInput userInput = inputHandler.inputCarNamesAndAttemptCount();

        // then
        assertEquals(EMPTY_STRING, userInput.carNames());
        assertEquals(EMPTY_STRING, userInput.attemptCount());
    }
}