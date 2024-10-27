package racingcar.controller;

import racingcar.domain.TrialCount;
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
        initCars();
        playRace();
        drawWinner();
    }

    private void initCars() {
        CarsRequest carsRequest = inputView.readCarNames();
        gameService.initializeCars(carsRequest);
    }

    private void playRace() {
        TrialCount trialCount = inputView.readTrialCount();

        while (trialCount.isProgress()) {
            CarsResponse result = gameService.moveCars();
            outputView.printMovement(result);
            trialCount.minusCount();
        }
    }

    private void drawWinner() {
        WinnerResponse winnerResponse = gameService.drawWinner();
        outputView.printWinner(winnerResponse);
    }
}
