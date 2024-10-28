package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RequestRaceDto;
import racingcar.service.RaceService;
import racingcar.service.Validate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService = new RaceService();
    private RequestRaceDto requestRaceDto;

    public void parseInput() {
        OutputView.requestCarName();
        String carNames = InputView.inputCarName();
        OutputView.requestTryNumber();
        String tryNumber = InputView.inputTryNumber();
        requestRaceDto = new RequestRaceDto(
                raceService.makeCarList(Validate.validateCarNames(carNames)),
                Validate.validateTryNumber(tryNumber));
    }

    public void play () {
        OutputView.printExecutionMessage();
        for (int index = 0; index < requestRaceDto.getTryNumber(); index++) {
            raceService.race(requestRaceDto.getCarList());
            for (Car car : requestRaceDto.getCarList()) {
                OutputView.printCarState(car.getCarName(), "-".repeat(Math.max(0, car.getLocation())));
            }
            OutputView.printNewLine();
        }
    }

    public void declareWinners () {
        OutputView.printWinner(
                raceService.checkWinner(
                        requestRaceDto.getCarList(),
                        raceService.checkMaxLocation(requestRaceDto.getCarList())));
    }
}
