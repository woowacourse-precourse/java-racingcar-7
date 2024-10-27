package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Car> cars = inputView.inputCarNames();
        int attempts = inputView.inputAttempts();

        Race race = new Race(cars, attempts);
        List<Car> winners = race.start();

        outputView.printRaceStatus(race);
        outputView.announceWinners(winners);
    }
}
