package racingcar.controller;

import java.util.Set;
import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.view.RacingView;

public class RacingController {

    private final RacingService racingService;
    private final RacingView racingView;

    public RacingController(RacingService racingService, RacingView racingView) {
        this.racingService = racingService;
        this.racingView = racingView;
    }

    public void run() {
        String namesInput = racingView.requestNamesInput();

        Set<Car> cars = racingService.createCars(namesInput);
    }
}
