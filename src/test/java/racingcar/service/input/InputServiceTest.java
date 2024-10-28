package racingcar.service.input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Input;
import racingcar.view.constant.Request;

class InputServiceTest {

    @Test
    @DisplayName("Input 타입 객체 생성")
    void createInput() {
        String request = Request.CAR_NAMES.toString();
        String test = "testInput";

        InputService inputService = new InputService();

        Input testInput = inputService.receive(request, test);

        assertEquals(test, testInput.getInput());
    }
}