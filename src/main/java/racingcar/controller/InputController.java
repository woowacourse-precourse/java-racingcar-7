package racingcar.controller;

import racingcar.common.util.StringUtil;
import racingcar.domain.CarDomain;
import racingcar.domain.CarDomains;
import racingcar.view.InputView;

public class InputController {
    private static InputController INSTANCE;

    private final InputView inputView;

    private InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public static synchronized InputController getInstance(InputView inputView) {
        if (INSTANCE == null) {
            INSTANCE = new InputController(inputView);
        }
        return INSTANCE;
    }

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
