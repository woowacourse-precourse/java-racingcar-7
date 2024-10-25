package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.view.OutputView.printRaceStatus;
import static racingcar.view.OutputView.printWinners;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private int attemptCount;

    public Race(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void operate() {
        for (int i = 0; i < attemptCount; i++) {
            cars.stream().forEach(this::moveRandomly);
            printRaceStatus(cars);
        }
        printWinners(findWinners(cars));
    }

    private void moveRandomly(Car car) {
        if (pickNumberInRange(0, 9) >= 4) {
            car.moveForward();
        }
    }

    private List<String> findWinners(List<Car> cars) {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        List<String> winners = cars.stream().filter(car -> car.getDistance() == maxDistance).map(Car::getName)
                .collect(Collectors.toList());
        return winners;
    }
}
