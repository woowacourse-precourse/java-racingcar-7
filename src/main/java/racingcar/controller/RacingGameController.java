package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;

public class RacingGameController {
    private final InputValidator inputValidator;
    private final RacingGameService racingGameService;

    public RacingGameController(InputValidator inputValidator, RacingGameService racingGameService) {
        this.inputValidator = inputValidator;
        this.racingGameService = racingGameService;
    }

    public void start() {
        System.out.print("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();

        inputValidator.validateCarNames(cars);
        racingGameService.createCars(cars);

        System.out.println("시도할 횟수");
        String rounds = Console.readLine();
        inputValidator.validateRounds(rounds);
        racingGameService.setRounds(rounds);

        racingGameService.startRace();
    }
}


