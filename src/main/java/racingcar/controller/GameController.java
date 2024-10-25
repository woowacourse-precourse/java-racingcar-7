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

    public void startGame() {
        CarsRequest carsRequest = inputView.readCarNames();
        int tryCount = inputView.readTryCount();
        Cars cars = playGame(carsRequest, tryCount);
        WinnerResponse winnerResponse = gameService.drawWinner(cars);
        outputView.printWinner(winnerResponse);
    }

    private Cars playGame(CarsRequest carsRequest, int tryCount) {
        System.out.println("\n실행 결과");
        Cars cars = carsRequest.toCars();
        for (int i = 0; i < tryCount; i++) {
            CarsResponse result = gameService.moveCars(cars);
            outputView.printMovement(result);
            System.out.println();
        }
        return cars;
    }
}
