package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingGameService;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();
    private List<Car> cars = new ArrayList<>();

    public void start() {
        cars = racingGameService.inputCars();
        int moveCount = racingGameService.inputMoveCount();
        racingGameService.race(cars, moveCount);
        racingGameService.announceWinners(cars);
    }

}
