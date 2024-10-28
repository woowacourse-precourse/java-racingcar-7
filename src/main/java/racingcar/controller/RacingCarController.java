package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.dto.RoundResultDto;
import racingcar.dto.WinnerDto;
import racingcar.service.CarsService;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final CarsService carsService;
    private final RaceService raceService;
    private final MoveStrategy moveStrategy;

    public RacingCarController() {
        this.carsService = new CarsService();
        this.raceService = new RaceService();
        this.moveStrategy = new RandomMoveStrategy();
    }

    public void run() {
        String carNames = InputView.inputCarNames();
        Cars cars = createCars(carNames);
        int tryCount = InputView.inputTryCount();

        List<RoundResultDto> raceStatus = playRace(cars, tryCount);
        OutputView.printRoundResults(raceStatus);
        WinnerDto winners = getWinnerNames(cars);
        OutputView.printWinners(winners);
    }

    private List<RoundResultDto> playRace(Cars cars, int tryCount) {
        return raceService.playRace(cars, tryCount);
    }

    private WinnerDto getWinnerNames(Cars cars) {
        return carsService.getWinnerNames(cars);
    }

    private Cars createCars(String carNames) {
        return carsService.createCars(carNames, moveStrategy);
    }


}
