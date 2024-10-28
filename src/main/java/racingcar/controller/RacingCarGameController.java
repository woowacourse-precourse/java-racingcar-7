package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarNamesInput;
import racingcar.dto.GameSettingsInput;
import racingcar.dto.TryCountInput;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        GameSettingsInput gameSettingsInput = initializeGameSettings();
        Cars cars = new Cars(gameSettingsInput.carNames());
        Count count = Count.newInstance(gameSettingsInput.tryCount());
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        Race race = new Race(cars, count);

        startRace(race, numberGenerator);
        endRace(race);
    }

    private GameSettingsInput initializeGameSettings() {
        outputView.printCarNamesRequest();
        CarNamesInput carNamesInput = inputView.readCarNames();

        outputView.printTryCountRequest();
        TryCountInput tryCountInput = inputView.readTryCount();

        return GameSettingsInput.of(carNamesInput, tryCountInput);
    }

    private void startRace(Race race, NumberGenerator numberGenerator) {
        while (!race.isRaceComplete()) {
            List<Car> raceCars = race.moveAllCarsAndGetStatus(numberGenerator);
            outputView.printRoundResult(raceCars);
        }
    }

    private void endRace(Race race) {
        outputView.printWinners(race.getWinners());
    }
}
