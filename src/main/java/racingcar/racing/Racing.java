package racingcar.racing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {

    Set<Car> cars = new HashSet<>();

    public Racing(List<String> cars) {
        this.cars.addAll(Car.to(cars));
    }

    public List<String> race() {
        return cars.stream().map(car -> {
            car.move();
            return car.toString();
        }).toList();
    }

    public List<String> getWinners() {
        int max = findMaxDistance();

        return cars.stream()
            .filter(car -> isDistanceMax(car, max)) // distance가 max와 일치할 경우
            .map(Car::getName) // car의 이름을 리스트에 담아 반환
            .toList();
    }

    private int findMaxDistance() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0); // distance의 max값 찾기
    }

    private boolean isDistanceMax(Car car, int max) {
        return car.getDistance() == max;
    }
}
