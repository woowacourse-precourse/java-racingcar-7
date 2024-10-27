package racingcar.service.input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Input;

class InputServiceTest {

    @Test
    @DisplayName("Input 타입 객체 생성")
    void createInput() {
        String test = "testInput";
        InputService inputService = new InputService();

        Input testInput = inputService.receive(test);

        assertEquals(test, testInput.getInput());
    }
}