package racingcar.controller;

import racingcar.common.util.StringUtil;
import racingcar.domain.CarDomain;
import racingcar.domain.CarDomains;
import racingcar.view.InputView;
import racingcar.view.impl.ConsoleInputView;

public class InputController {

    private final InputView inputView = new ConsoleInputView();

    public CarDomains getCarNameRequest() {
        String inputCarNames = inputView.displayCarNameRequest();
        return CarDomains.create(StringUtil.splitStringToList(inputCarNames).stream()
                .map(name -> CarDomain.create(name, 0))
                .toList());
    }

    public Integer getRoundRequest() {
        String inputRound = inputView.displayRoundRequest();
        return Integer.valueOf(inputRound);
    }
}
