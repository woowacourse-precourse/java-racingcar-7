package racingcar.view.input.service.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.input.service.InputService;
import racingcar.view.input.validator.trynumber.TryNumberValidator;
import racingcar.view.output.service.InfoOutputViewService;

public class TryNumberInputView implements InputService {
    private final InfoOutputViewService tryNumberInfoOutputView;
    public TryNumberInputView(InfoOutputViewService tryNumberInfoOutputView) {
        this.tryNumberInfoOutputView = tryNumberInfoOutputView;
    }
    @Override
    public String input() {
        tryNumberInfoOutputView.info();
        String input = Console.readLine();
        TryNumberValidator.validator(input);
        return input;
    }
}
