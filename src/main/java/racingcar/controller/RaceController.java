package racingcar.controller;

import java.util.ArrayList;
import java.util.stream.IntStream;
import racingcar.model.Race;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void run() {
        ArrayList<String> carNames = InputView.readCarNames();
        int repeatCount = InputView.readRepeatCount();

        Race race = new Race(carNames,new RandomNumberGenerator());
        OutputView.printResultMessage();
        IntStream.range(0, repeatCount)
                .forEach(i -> {race.playOneRound();
                    OutputView.printRoundResult(race.getOneRoundResult());
                });
        Winner winner = new Winner(race.getCars());
        OutputView.printWinningCars(winner.getWinningCars());
    }
}
