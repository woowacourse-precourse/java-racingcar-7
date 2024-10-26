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
        String carNames = racingGameInputView.getUserInput();
        List<Car> cars = racingGameSettingService.createCars(carNames);

        racingGameOutputView.printRacingGameRoundInputMessage();
        String roundInput = racingGameInputView.getUserInput();
        RacingGameMaxRound gameMaxRound = racingGameSettingService.createGameRound(roundInput);

        List<RacingGameRoundResult> gameRoundResults = racingGameProgressService.executeRounds(cars, gameMaxRound);
        racingGameOutputView.printRacingRoundResultStartingMessage();
        racingGameOutputView.printRoundResults(gameRoundResults);

        List<String> gameWinners = gameRoundResults.getLast().calculateWinners();
        racingGameOutputView.printRoundWinner(gameWinners);
    }
}
