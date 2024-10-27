package racingcar.model.infrastructure;

import racingcar.model.domain.RaceFind;
import racingcar.model.domain.Vehicle;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.enumerate.OutputConstant.PRINT_RUNNING_RESULT_SENTENCE;

public class CarRace implements RaceFind {
    private final int tryTimes;
    private final List<Vehicle> cars;
    private final static Integer CAR_INIT_DISTANCE = 0;
    public CarRace(int tryTimes, List<Car> cars) {
        this.tryTimes = tryTimes;
        this.cars = new ArrayList<>(cars);
    }

    public static CarRace init(List<String> carNames, int tryTimes) {
        List<Car> newCarInRace = carNames.stream()
                .map(name -> new Car(name, CAR_INIT_DISTANCE,CarMoveDecider.getInstance()))
                .toList();
        return new CarRace(tryTimes, newCarInRace);
    }

    @Override
    public void runSingleRound() {
        cars.forEach(Vehicle::move);
    }

    @Override
    public void runFullRace(OutputView outputView) {
        outputView.print(PRINT_RUNNING_RESULT_SENTENCE);
        for (int perTime = 0; perTime < tryTimes; perTime++) {
            runSingleRound();
            outputView.printRaceResultPerGame(cars);
        }
    }

    @Override
    public List<String> getWinners() {
        int maxDistance = getMaxDistanceBetweenCars();
        return findWinner(maxDistance);
    }

    private List<String> findWinner(int maxDistance) {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Vehicle::getName)
                .toList();
    }

    private int getMaxDistanceBetweenCars() {
        return cars.stream()
                .mapToInt(Vehicle::getDistance)
                .max()
                .orElse(0);
    }
}
