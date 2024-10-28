package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import racingcar.validator.InputValidator;

public class RacingGameController {
    private final InputValidator inputValidator;

    public RacingGameController(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void start() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        inputValidator.validateCarNames(input);
    }
}

