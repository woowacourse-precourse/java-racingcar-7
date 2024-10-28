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
import racingcar.wrapper.RaceCount;

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
        String Count = InputView.inputRaceCount();
        RaceCount raceCount = RaceCount.of(Count);

        List<RoundResultDto> raceStatus = playRace(cars, raceCount);
        OutputView.printRoundResults(raceStatus);
        WinnerDto winners = getWinnerNames(cars);
        OutputView.printWinners(winners);
        InputView.closeStream();
    }

    private List<RoundResultDto> playRace(Cars cars, RaceCount raceCount) {
        return raceService.playRace(cars, raceCount);
    }

    private WinnerDto getWinnerNames(Cars cars) {
        return carsService.getWinnerNames(cars);
    }

    private Cars createCars(String carNames) {
        return carsService.createCars(carNames, moveStrategy);
    }

}
