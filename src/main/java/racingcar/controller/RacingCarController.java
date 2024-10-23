package racingcar.controller;

import java.util.List;
import racingcar.model.*;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = InputView.getInstance();
    private final Race race;
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.race = new Race(setCars(), setRaceCount());
        this.racingCarService = racingCarService;
    }

    public void run() {
        racingCarService.raceStart(race);
    }


    private Cars setCars() {
        List<String> carNames = inputView.inputCarNames();
        Cars cars = new Cars();

        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }
        return cars;
    }
    private Integer setRaceCount() {
        return inputView.inputCount();
    }
}
