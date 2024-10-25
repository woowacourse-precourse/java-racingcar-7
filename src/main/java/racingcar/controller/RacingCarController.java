package racingcar.controller;

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
        return setCarsName(carNames);
    }

    public Cars setCarsName(List<String> carNames) {
        Cars cars = new Cars();

        for (String carName : carNames) {
            validateName(carName);
            cars.addCar(new Car(carName));
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
