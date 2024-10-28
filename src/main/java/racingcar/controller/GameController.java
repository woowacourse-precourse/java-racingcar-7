package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void run() {
        String[] carNames = InputView.inputCarNames();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        int rounds = InputView.inputRounds();
        Race race = new Race(cars);

        System.out.println("\n실행 결과");

        race.move(rounds);
        OutputView.printRaceStatus(cars);

        List<Car> winners = Winner.getWinners(cars);
        OutputView.printWinners(winners);
    }

}
