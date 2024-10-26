package racingcar.controller;

import java.util.ArrayList;
import java.util.stream.IntStream;
import racingcar.model.Race;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Winner;
import racingcar.view.InputView;

public class RaceController {

    public void run() {
        ArrayList<String> carNames = InputView.readCarNames();
        int repeatCount = InputView.readRepeatCount();
        Race race = new Race(carNames,new RandomNumberGenerator());
        IntStream.range(0, repeatCount).forEach(i -> race.playOneRound());
        Winner winner = new Winner(race.getCars());
    }
}
