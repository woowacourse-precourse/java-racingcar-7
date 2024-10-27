package racingcar.view.input.service.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.input.service.InputService;
import racingcar.view.input.validator.racingcar.RacingCarValidator;
import racingcar.view.output.service.InfoOutputViewService;

public class CarInputView implements InputService {
    private final InfoOutputViewService infoOutputViewService;
    public CarInputView(InfoOutputViewService infoOutputViewService) {
        this.infoOutputViewService = infoOutputViewService;
    }
    @Override
    public String input() {
        infoOutputViewService.info();
        String input = Console.readLine();
        RacingCarValidator.validator(input);
        return input;
    }
}
