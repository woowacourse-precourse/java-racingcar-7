package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RaceRound;
import racingcar.dto.RaceDto;

public class CarService {

    private final WinnerService winnerService;
    private final RaceRunnerService raceRunnerService;

    public CarService() {
        this.winnerService = new WinnerService();
        this.raceRunnerService = new RaceRunnerService();
    }

    public RaceDto playGame(String carNames, int count) {
        List<Car> cars = CarFactory.createCars(carNames);
        List<RaceRound> rounds = raceRunnerService.runRaces(cars, count).getRounds();
        return RaceDto.of(rounds, winnerService.calculateWinners(cars));
    }

}
