package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;

    public RacingController(InputView inputView,
                            OutputView outputView,
                            CarService carService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
    }

    public void run(){
        outputView.printInputCarName();
        String playersName = inputView.getPlayer();
        outputView.printInputMoveCount();
        int moveCount = inputView.getMoveCount();

        outputView.printResult();
        List<Car> winners = carService.playRounds(playersName,moveCount);
        outputView.printWinners(winners);
    }
}
