package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RandomNumberGenerator;
import racingcar.service.CarMakerService;
import racingcar.service.GameService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final CarMakerService carMakerService;
    private final GameService gameService;
    private final WinnerService winnerService;
    private final OutputView outputView;

    public RacingCarController(InputView inputView,
                               CarMakerService carMakerService,
                               GameService gameService,
                               WinnerService winnerService,
                               OutputView outputView) {
        this.inputView = inputView;
        this.carMakerService = carMakerService;
        this.gameService = gameService;
        this.winnerService = winnerService;
        this.outputView = outputView;
    }

    public void startGame() {
        String[] carNames = inputView.scanCarNames();
        int tryCount = inputView.scanTryCount();
        playGame(carNames, tryCount);
    }

    private void playGame(String[] carNames, int tryCount) {
        List<Car> cars = carMakerService.makeCars(carNames);

        outputView.printMoveResultMessage();

        for(int i=0; i<tryCount; i++){
            gameService.raceCar(cars);
            outputView.printMovedCars(cars);
            System.out.println();
        }

        printWinner(cars);
    }

    private void printWinner(List<Car> cars){
        List<String> winners = winnerService.findWinner(cars);
        outputView.printWinner(winners);
    }
}
