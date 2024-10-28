package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int moveCount;

    public Race(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            cars.forEach(car -> car.move(generateRandomNumber()));
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> getWinners() {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);

        return cars.stream().filter(car -> car.getDistance() == maxDistance).collect(Collectors.toList());
    }
}
