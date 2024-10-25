package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ProgressView;

public class RacingCarController {
    private final InputView inputView;
    private final ProgressView progressView;
    private final OutputView outputView;
    private final Cars cars;

    public RacingCarController(InputView inputView, ProgressView progressView, OutputView outputView, Cars cars) {
        this.inputView = inputView;
        this.progressView = progressView;
        this.outputView = outputView;
        this.cars = cars;
    }

    public void start() {
        initializeCars();
        final long racingRound = settingRacingRound();
        startRace(racingRound);
        finalizeRace();
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

    private void startRace(final long racingRound) {
        progressView.printFirstProgressMessage();
        for (int round = 1; round <= racingRound; round++) {
            cars.moveCars();
            List<CarDto> carDtoList = cars.getCarDtoList();
            progressView.printProgressMessage(carDtoList);
        }
    }

    private void finalizeRace() {
        List<CarDto> winnerList = cars.calculateFarthestCars();
        List<String> winnerNameList = getCarNameList(winnerList);
        outputView.printWinnerMessage(winnerNameList);
    }

    private List<String> getCarNameList(List<CarDto> carDtoList) {
        List<String> carNameList = new ArrayList<>();
        for (CarDto carDto : carDtoList) {
            String carName = carDto.name();
            carNameList.add(carName);
        }
        return carNameList;
    }
}
