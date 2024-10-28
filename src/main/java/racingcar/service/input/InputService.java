package racingcar.service.input;

import java.util.function.Function;
import racingcar.domain.Input;
import racingcar.repository.InputRepository;
import racingcar.view.constant.Request;

public class InputService {

    private final InputRepository inputRepository;

    public InputService() {
        this.inputRepository = InputRepository.connect();
    }

    public void saveInput(Input userInput, Function<String, String> validation) {
        validatedInput(userInput, validation);
        inputRepository.save(userInput.getRequest(), userInput);
    }

    public Input receive(String request, String input) {
        return new Input(request, input);
    }

    private void validatedInput(Input userInput, Function<String, String> validation) {
        validation.apply(userInput.getInput());
    }
}
