package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void doGame() {
        Cars cars = makeCars(inputView.askCarName());
        Rounds rounds = new Rounds(inputView.askNumberOfRounds());
        for (int i = 0; i < rounds.rounds(); i++) {
            doRace(cars);
        }
    }

    public Cars makeCars(String initialInput) {
        List<String> carNames = Arrays.asList(initialInput.split(","));
        Cars cars = new Cars(carNames);
        return cars;
    }

    public void doRace(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.getCar(i).randomGo();
            outputView.printProgress();
        }
    }
}

