package racingcar.controller;

import racingcar.view.InputView;

public class GameController {
    private InputView inputView = new InputView();
    static private String DELIMITER=",";

    private String[] splitCarNames(String racingCarNames) {
        String[] CarNames = racingCarNames.split(DELIMITER);
        for (String carName : CarNames) {
            carName = carName.trim();
        }
        return CarNames;
    }
}
