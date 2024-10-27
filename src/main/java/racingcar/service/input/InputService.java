package racingcar.service.input;

import racingcar.domain.Input;

public class InputService {
    public Input receive(String input) {
        return new Input(input);
    }
}
