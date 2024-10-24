package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private List<Car> cars = new ArrayList<>();

    public void start() {
        cars = racingGameService.inputCars();
//        int moveCount = inputView.getMoveCount();
//        racingGameService.race(moveCount);
//        outputView.printCurrentStatus(racingGameService.getCars());
//        racingGameService.announceWinners();
    }

    private void announceWinners() {
    }

}
