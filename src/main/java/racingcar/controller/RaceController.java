package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.race.Race;
import racingcar.domain.random.DefaultRandomNumberGenerator;
import racingcar.ui.ConsoleInputView;
import racingcar.ui.ConsoleOutputView;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class RaceController {

    private final Race race;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController() {
        this.race = new Race(new DefaultRandomNumberGenerator());
        this.inputView = new ConsoleInputView();
        this.outputView = new ConsoleOutputView();
    }

    public void run() {
        String carNames = inputView.inputCarNames();
        Integer repetitions = inputView.inputRepetitions();

        Cars cars = new Cars(carNames);
        startRace(cars, repetitions);

        List<String> winners = cars.winners();

        outputView.printWinners(winners);
    }

    private void startRace(Cars cars, Integer repetitions) {
        for (int i = 0; i < repetitions; i++) {
            race.racing(cars);
            outputView.printRaceStatus(cars);
        };
    }
}
