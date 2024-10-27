package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGameMaxRound;
import racingcar.model.RacingGameRoundResult;
import racingcar.service.RacingGameProgressService;
import racingcar.service.RacingGameSettingService;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameInputView racingGameInputView = new RacingGameInputView();
    private final RacingGameOutputView racingGameOutputView = new RacingGameOutputView();
    private final RacingGameSettingService racingGameSettingService = new RacingGameSettingService();
    private final RacingGameProgressService racingGameProgressService = new RacingGameProgressService();

    public void startGame() {
        racingGameOutputView.printRacingGameStartingMessage();
        List<Car> cars = initializeCars();
        RacingGameMaxRound gameMaxRound = initializeGameRound();

        List<RacingGameRoundResult> gameRoundResults = racingGameProgressService.executeRounds(cars, gameMaxRound);
        displayRoundResults(gameRoundResults);
    }

    private List<Car> initializeCars() {
        String carNames = racingGameInputView.getUserInput();
        return racingGameSettingService.createCars(carNames);
    }

    private RacingGameMaxRound initializeGameRound() {
        racingGameOutputView.printRacingGameRoundInputMessage();
        String roundInput = racingGameInputView.getUserInput();
        return racingGameSettingService.createGameRound(roundInput);
    }

    private void displayRoundResults(List<RacingGameRoundResult> gameRoundResults) {
        racingGameOutputView.printRacingRoundResultStartingMessage();
        racingGameOutputView.printRoundResults(gameRoundResults);

        List<String> gameWinners = gameRoundResults.get(gameRoundResults.size() - 1).calculateWinners();
        racingGameOutputView.printRoundWinner(gameWinners);
    }
}
