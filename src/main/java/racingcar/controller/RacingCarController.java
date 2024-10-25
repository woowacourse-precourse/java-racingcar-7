package racingcar.controller;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.ProgressView;

public class RacingCarController {
    private final InputView inputView;
    private final ProgressView progressView;
    private final Cars cars;

    public RacingCarController(InputView inputView, ProgressView progressView, Cars cars) {
        this.inputView = inputView;
        this.progressView = progressView;
        this.cars = cars;
    }

    public void start() {
        initializeCars();
        final long racingRound = settingRacingRound();
        startRace(racingRound);
    }

    private void initializeCars() {
        inputView.printCarNameInputGuide();
        String carNames = inputView.getCarNameInput();
        registerCars(carNames);
    }

    private long settingRacingRound() {
        inputView.printCarMovementCountInputGuide();
        return inputView.getCarMovementCount();
    }

    private void registerCars(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            cars.saveCar(carName);
        }
    }

    public void startRace(final long racingRound) {
        progressView.printFirstProgressMessage();
        for (int round = 1; round <= racingRound; round++) {
            cars.moveCars();
            List<CarDto> carDtoList = cars.getCarDtoList();
            progressView.printProgressMessage(carDtoList);
        }
    }
}
