package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameRounds;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public RacingCarGame(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void run() {
        outputView.printStartMessage();
        String inputString = inputView.getInput();
        Cars cars = gameService.generateCarList(inputString);

        outputView.printTryCountMessage();
        int tryCount = Integer.parseInt(inputView.getInput());

        GameRounds gameRounds = gameService.startGame(cars, tryCount);
        outputView.printGameRounds(gameRounds);
        outputView.printWinner(cars.getWinnerList());
    }


}
