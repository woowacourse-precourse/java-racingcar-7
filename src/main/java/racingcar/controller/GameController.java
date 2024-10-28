package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private Race race;
    private InputView inputView;
    private OutputView outputView;

    public GameController(Race race, InputView inputView, OutputView outputView) {
        this.race = race;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        String names = inputView.inputCarNames();

        race.setCars(names);

        int tryCount = inputView.inputTryCount();

        race.setTryCount(tryCount);

        for (int i = 0; i < race.getTryCount(); i++) {
            race.moveCars();
            outputView.printRoundResult(race.getCars());
        }

        List<Car> winners = race.getWinners();

        outputView.printWinner(winners);

    }
}
