package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.Input;
import racingcar.domain.Output;
import racingcar.parser.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private final InputView inputView;
    private final InputParser inputParser;
    private final OutputView outputView;

    public RacingGame(InputView inputView, InputParser inputParser, OutputView outputView) {
        this.inputView = inputView;
        this.inputParser = inputParser;
        this.outputView = outputView;
    }

    public void startRace() {
        Input carNames = inputView.readRacingCarNames();
        List<Car> carList = inputParser.splitCarsToList(carNames);
        Input tryCountString = inputView.readRacingTryCount();
        int tryCount = inputParser.parseTryCount(tryCountString);

        Game game = Game.carListFrom(carList);
        Output outPut = Output.getInstance();

        outputView.printResultText();
        for (int i = 0; i < tryCount; i++) {
            game.moveForward();
            List<String> carMoveResultList = outPut.getAllCarProgress(carList);
            outputView.printMoveResult(carMoveResultList);
        }

        String winnerNames = game.getWinner();
        outputView.printWinners(winnerNames);
    }

}
