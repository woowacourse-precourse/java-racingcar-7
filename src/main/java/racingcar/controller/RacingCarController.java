package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.global.enums.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = InputView.getInstance();
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
            validateName(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private Integer setRaceCount() {
        return inputView.inputCount();
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NOT_ALLOWED_EMPTY_SPACE.getMessage());
        }
    }
}
