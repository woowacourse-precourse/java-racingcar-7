package racingcar.controller;

import racingcar.service.RegisterService;

public class RacingGameController {
    private final RegisterService registerService;

    public RacingGameController(RegisterService registerService) {
        this.registerService = registerService;
    }

    public void start() {
        registerService.registerCars();
    }

}
