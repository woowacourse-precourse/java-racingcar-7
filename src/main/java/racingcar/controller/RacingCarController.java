package racingcar.controller;

import java.util.List;
import racingcar.model.*;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = InputView.getInstance();
    private final Race race;

    public RacingCarController() {
        this.race = new Race(setCars(), setRaceCount());
    }

    public void run() {
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
