package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private InputView inputView = new InputView();
    static private String DELIMITER=",";

    public String[] splitCarNames(String carNamesStr) {
        String[] racingCarsName = carNamesStr.split(DELIMITER);
        return racingCarsName;
    }
}
