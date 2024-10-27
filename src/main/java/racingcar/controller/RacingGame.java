package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.MovementDecider;
import racingcar.domain.Race;
import racingcar.domain.RandomMovementDecider;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

public class RacingGame {
    public void exec() {
        Race race = settingRace();
        playGame(race);
    }

    private static Race settingRace() {
        OutputHandler.displayCarsNameInputMessage();
        List<Car> cars = InputHandler.requestCarNames().stream().
                map(carName -> new Car(carName)).toList();

        MovementDecider movementDecider = new RandomMovementDecider();
        return new Race(cars,movementDecider);
    }

    private static void playGame(Race race) {
        OutputHandler.displayTotalRoundsInputMessage();
        int totalRounds = InputHandler.requestTotalRounds();

        OutputHandler.displayExecResultMessage();
        for (int i = 0; i < totalRounds; i++) {
            race.start();
            OutputHandler.displayRoundResult(race.getRoundResult());
        }
        OutputHandler.displayWinners(race.getFinalWinners());
    }
}
