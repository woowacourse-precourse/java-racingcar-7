package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.view.OutputView.printRaceStatus;
import static racingcar.view.OutputView.printWinners;

import java.util.List;

public class Race {
    private List<Car> cars;
    private int attemptCount;

    public Race(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void operate() {
        for (int i = 0; i < attemptCount; i++) {
            cars.forEach(this::moveRandomly);
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
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max()
                .orElseThrow(() -> new IllegalStateException("비어있는 차량 목록"));
        List<String> winners = cars.stream().filter(car -> car.getDistance() == maxDistance).map(Car::getName).toList();
        return winners;
    }
}
