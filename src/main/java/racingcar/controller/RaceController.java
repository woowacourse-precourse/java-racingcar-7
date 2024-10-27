package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RequestRaceDto;
import racingcar.service.RaceService;
import racingcar.service.Validate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService = new RaceService();
    public RequestRaceDto parseInput() {
        OutputView.requestCarName();
        String carNames = InputView.inputCarName();
        OutputView.requestTryNumber();
        String tryNumber = InputView.inputTryNumber();
        return new RequestRaceDto(
                raceService.makeCarList(Validate.validateCarNames(carNames)),
                Validate.validateTryNumber(tryNumber));
    }

    public void play (RequestRaceDto requestRaceDto) {
        for (int index = 0; index < requestRaceDto.getTryNumber(); index++) {
            raceService.race(requestRaceDto.getCarList());
            for (Car car : requestRaceDto.getCarList()) {
                OutputView.printCarState(car.getCarName(), "-".repeat(Math.max(0, car.getLocation())));
            }
            OutputView.printNewLine();
        }
    }
}
