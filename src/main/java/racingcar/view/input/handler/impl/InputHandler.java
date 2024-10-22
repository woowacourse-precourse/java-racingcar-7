package racingcar.view.inputView.handler.impl;

import racingcar.view.inputView.handler.InputHandlerService;

import java.util.function.Function;

public class CarInputHandler implements InputHandlerService {
    private final I
    @Override
    public <R> R receive(Function<String, R> function) {
        return function.apply();
    }
}
