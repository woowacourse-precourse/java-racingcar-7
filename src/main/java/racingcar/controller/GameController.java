package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.dto.request.CarsRequest;
import racingcar.dto.response.CarsResponse;
import racingcar.dto.response.WinnerResponse;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(GameService gameService, InputView inputView, OutputView outputView) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarsRequest carsRequest = inputView.readCarNames();
        int tryCount = inputView.readTryCount();
        gameService.initializeCars(carsRequest);
        playGame(tryCount);
        WinnerResponse winnerResponse = gameService.drawWinner();
        outputView.printWinner(winnerResponse);
    }

    private void playGame(int tryCount) {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            CarsResponse result = gameService.moveCars();
            outputView.printMovement(result);
        }
    }
}
