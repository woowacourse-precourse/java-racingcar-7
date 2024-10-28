package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
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
        Race race = new Race(gameSettingsInput.carNames(), gameSettingsInput.tryCount());

        startRace(race, new RandomNumberGenerator());
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
        outputView.printStartMessage();

        while (!race.isRaceComplete()) {
            List<Car> raceCars = race.moveAllCarsAndGetStatus(numberGenerator);
            outputView.printRoundResult(raceCars);
        }
    }

    private void endRace(Race race) {
        outputView.printWinners(race.getWinners());
    }
}
