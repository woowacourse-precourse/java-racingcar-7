package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    public void run() {
        OutputView.printCarNamesPrompt();
        InputView inputView = new InputView();

        String carInput = inputView.input();
        String[] carInputs = carInput.split(",");

        List<Car> carNames = new ArrayList<>();
        for (int i = 0; i < carInputs.length; i++) {
            carNames.add(new Car(carInputs[i]));
        }

        OutputView.printAttemptCountPrompt();
        int tryCount = Integer.parseInt(inputView.input());
        Cars cars = new Cars(carNames);

        OutputView.printRacingResult();

        for (int i = 0; i < tryCount; i++) {
            cars.allMove();
            OutputView.printCarDistances(cars.getCarNames(), cars.getCarsPositions());
        }

        List<String> raceWinners = cars.findRaceWinners();
        OutputView.printWinners(raceWinners);
    }

}
