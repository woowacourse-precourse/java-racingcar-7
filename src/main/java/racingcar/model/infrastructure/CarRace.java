package racingcar.model.infrastructure;

import racingcar.model.domain.RaceFind;
import racingcar.model.domain.Rule;
import racingcar.model.domain.Vehicle;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.enumerate.OutputConstant.PRINT_RUNNING_RESULT_SENTENCE;

public class CarRace implements RaceFind {
    private final static Integer CAR_INIT_DISTANCE = 0;
    private final int tryTimes;
    private final List<Vehicle> cars;
    private final Rule rule;

    public CarRace(int tryTimes, List<Car> cars, Rule rule) {
        this.tryTimes = tryTimes;
        this.cars = new ArrayList<>(cars);
        this.rule = rule;
    }

    public static CarRace init(List<String> carNames, int tryTimes, Rule rule) {
        List<Car> newCarInRace = initCars(carNames);
        return new CarRace(tryTimes, newCarInRace, rule);
    }

    private static List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, CAR_INIT_DISTANCE, CarMoveDecider.getInstance()))
                .toList();
    }

    @Override
    public void runSingleRound() {
        int playScore = rule.play();
        cars.forEach(vehicle -> vehicle.move(playScore));
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
