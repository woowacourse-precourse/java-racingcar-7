package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.model.Race;
import racingcar.validator.RaceRoundsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final RaceRoundsValidator raceRoundsValidator;
    private final CarManager carManager;
    private final OutputView outputView;
    private Race race;

    public GameController(InputView inputView, RaceRoundsValidator raceRoundsValidator, CarManager carManager,
                          OutputView outputView) {
        this.inputView = inputView;
        this.raceRoundsValidator = raceRoundsValidator;
        this.carManager = carManager;
        this.outputView = outputView;
    }

    public void startGame() {
        List<Car> cars = processCarNames();
        int validRaceRounds = processRaceRounds();

        race = new Race(cars, validRaceRounds);
        processRace(race);
    }

    public Race getRace() {
        return race;
    }

    private List<Car> processCarNames() {
        String carNames = inputView.inputCarNames();
        return carManager.processCarName(carNames);
    }

    private int processRaceRounds() {
        String raceRounds = inputView.inputRaceRounds();
        return raceRoundsValidator.validateRoundsInput(raceRounds);
    }

    private void processRace(Race race) {
        outputView.printRoundResultsHeader();
        int totalRounds = race.getTotalRounds();
        List<Car> participatingCars = race.getParticipatingCars();

        for (int i = 0; i < totalRounds; i++) {
            List<Car> roundCarResult = race.startEachRound(participatingCars);
            outputView.printRoundResults(roundCarResult);
        }

        List<String> winners = race.getWinners(participatingCars);
        outputView.printWinner(String.join(", ", winners));
    }
}
