package racingcar.controller;

import java.util.ArrayList;
import java.util.stream.IntStream;
import racingcar.model.Race;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        ArrayList<String> carNames = inputView.readCarNames();
        int repeatCount = inputView.readRepeatCount();

        race(repeatCount, carNames);
        announceWinner();
    }

    private void race(int repeatCount, ArrayList<String> carNames) {
        race = new Race(carNames, new RandomNumberGenerator());
        outputView.printResultMessage();
        IntStream.range(0, repeatCount).forEach(i -> playSingleRound());
    }

    private void playSingleRound() {
        race.playSingleRound();
        outputView.printRoundResult(race.getSingleRoundResult());
    }

    private void announceWinner() {
        Winner winner = new Winner(race.getCars());
        outputView.printWinningCars(winner.getWinningCars());
    }
}
