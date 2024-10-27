package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
    private final InputView inputView;
    private final ResultView resultView;

    public GameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        List<String> carNames = inputView.getCarNames();
        int rounds = inputView.getNumberOfRounds();

        Race race = initializeRace(carNames);

        for (int i = 0; i < rounds; i++) {
            race.playRound();
            resultView.printRoundResult(race.getCars());
        }

        List<Car> winners = race.getWinners();
        resultView.printWinners(winners);
    }

    private Race initializeRace(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Race(cars);
    }
}
