package racingcar.racingcar.service.create.impl;

import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.service.create.RacingCarCreateService;
import racingcar.view.input.handler.InputHandlerService;

import java.util.function.Function;

public class RacingCarCreator implements RacingCarCreateService {
    private final InputHandlerService inputHandlerService;
    public RacingCarCreator(InputHandlerService inputHandlerService) {
        this.inputHandlerService = inputHandlerService;
    }
    @Override
    public RacingCarInfo create(Function<String, RacingCarInfo> function) {
       return inputHandlerService.receive(function);
    }
}
