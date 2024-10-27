package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRacingGame;
import racingcar.model.InputVal;
import racingcar.service.RacingService;
import racingcar.util.InputParser;
import racingcar.util.WinnerAggregater;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

import java.util.List;

public class RacingController {

    private final RacingInputView racingInputView;
    private final RacingService racingService;


    public RacingController(RacingInputView racingInputView, RacingService racingService) {
        this.racingInputView = racingInputView;
        this.racingService = racingService;
    }

    public void run() {
        InputVal inputVal = racingInputView.inputProcess();
        List<Car> carList = InputParser.parseInput(inputVal.getInputString());
        CarRacingGame carRacingGame = CarRacingGame.createRacingGame(inputVal.getInputCount(), carList);
        racingService.carRacingGameStart(carRacingGame);
        String winner = WinnerAggregater.getWinner(carList);
        RacingOutputView.printWinnerResult(winner);
    }
}
