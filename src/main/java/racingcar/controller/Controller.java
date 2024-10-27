package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGame;
import racingcar.utils.Utils;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.List;

public class Controller {

    RacingGame racingGame;

    public void run(){

        List<Car> carList = Validator.validateSameCarName(Utils.inputCarNameToList());

        racingGame = new RacingGame(carList);

        racingGame.runGame(InputView.inputTrialCount());
    }

}
