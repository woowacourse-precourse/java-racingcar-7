package racingcar.controller;

import racingcar.global.util.Validator;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final InputView inputView = InputView.getInstance();
    private final Validator validator = Validator.getInstance();
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        Race race = new Race(setCars(), setRaceCount());
        racingCarService.raceStart(race);
    }


    public Cars setCars() {
        List<String> carNames = inputView.inputCarNames();
        List<Car> carList = setCarsName(carNames);
        return new Cars(carList);
    }

    public List<Car> setCarsName(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            validator.validateName(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private Integer setRaceCount() {
        return inputView.inputCount();
    }
}
