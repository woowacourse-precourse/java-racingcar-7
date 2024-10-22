package racingcar.view.input.handler.impl;

import racingcar.view.input.handler.InputHandlerService;
import racingcar.view.input.service.InputService;

import java.util.function.Function;

public class InputHandler implements InputHandlerService {
    private final InputService inputService;
    public InputHandler(InputService inputService) {
        this.inputService = inputService;
    }
    @Override
    public <R> R receive(Function<String, R> function) {
        String input = inputService.input();
        return function.apply(input);
    }
}
