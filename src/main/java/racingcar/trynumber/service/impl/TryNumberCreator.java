package racingcar.trynumber.service.impl;

import racingcar.trynumber.service.TryNumberCreateService;
import racingcar.trynumber.domain.TryNumber;
import racingcar.view.input.handler.InputHandlerService;

import java.util.function.Function;

public class TryNumberCreator implements TryNumberCreateService {
    private final InputHandlerService inputHandlerService;
    public TryNumberCreator(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
    @Override
    public TryNumber create(Function<String, TryNumber> function) {
        return inputHandlerService.receive(function);
    }
}
