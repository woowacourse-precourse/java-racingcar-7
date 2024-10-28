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
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        inputValidator.validateCarNames(input);
        racingGameService.createCars(input);
    }
}


