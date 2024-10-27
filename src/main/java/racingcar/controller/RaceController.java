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
}
