package racingcar.application;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.car.value.Name;
import racingcar.domain.refree.Referee;
import racingcar.domain.refree.value.SingleResult;
import racingcar.domain.refree.value.TotalResult;
import racingcar.domain.refree.value.WinnerNames;

import java.util.List;

public class RacingCarService {

    private final CarRepository carRepository;

    public RacingCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCars(List<Name> names) {
        List<Car> cars = names.stream()
                .map(Car::create)
                .toList();

        carRepository.saveAll(cars);
    }

    public TotalResult startRace(int count) {

        List<Car> cars = carRepository.findAll();
        Referee referee = new Referee();

        List<SingleResult> results = referee.startGame(cars, count);
        WinnerNames winnerNames = referee.decideWinners(results.getLast());
        return new TotalResult(results, winnerNames);
    }
}
