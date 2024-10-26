package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.utils.Utils;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    RacingGame racingGame;

    public void run(){

        List<Car> carList = Validator.validateSameCarName(Utils.inputCarNameToList());

        racingGame = new RacingGame(carList);

        racingGame.runGame(InputView.inputTrialCount());
    }

}
