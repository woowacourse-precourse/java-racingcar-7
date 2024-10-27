package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    public void run(){
        InputView inputView = new InputView();
        String carNamesString = inputView.promptCarNames();
        String[] carNamesArray = carNamesString.split(",");








    }


}
