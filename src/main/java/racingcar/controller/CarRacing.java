package racingcar.controller;

import java.util.List;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class CarRacing {
    public void race() {
        String carNames = InputView.inputCarNames();
        Cars cars = CarFactory.createCars(carNames);

        int tryCount = InputView.inputTryCount();

        for (int count = 1; count <= tryCount; count++) {
            System.out.println(cars.decideMoving());
        }

        List<String> winners = cars.findWinners();
        ResultView.showWinners(winners);
    }
}
