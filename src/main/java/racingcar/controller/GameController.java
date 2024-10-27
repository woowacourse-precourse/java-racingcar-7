package racingcar.controller;

import java.util.List;
import racingcar.factory.CarFactory;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.rule.RaceRule;
import racingcar.rule.RandomAboveFourRule;

public class GameController {

    private final InputHandler inputHandler = new InputHandler();
    private final RaceRule raceRule = new RandomAboveFourRule();
    private final OutputHandler outputHandler = new OutputHandler();

    public void startGame() {
        List<String> carNames = inputHandler.getCarNames();
        int totalRounds = inputHandler.getRounds();

        List<Car> cars = CarFactory.createCars(carNames);

        Race race = new Race(cars, totalRounds, raceRule);
        while (!race.isRaceOver()) {
            race.playRound();
            outputHandler.printRoundResult(race);
        }
        outputHandler.printFinalWinners(race);
    }

}
