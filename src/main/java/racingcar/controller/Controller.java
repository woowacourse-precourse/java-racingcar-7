package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    RacingGame racingGame;

    public void run(){

        List<Car> carList = Validator.validateSameCarName(inputCarNameToList());
        int trialCount = InputView.inputTrialCount();

        racingGame = new RacingGame(carList);

        racingGame.runGame(trialCount);
    }

    private List<Car> inputCarNameToList(){

        return InputView.inputCarName()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
