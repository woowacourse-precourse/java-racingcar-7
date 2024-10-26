package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars = new ArrayList<>();

    Race(List<String> carNames) {
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    private List<String> getWinnerNames() {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void play(int times) {
        if (times < 1) {
            throw new IllegalArgumentException("Times should be at least 1.");
        }
        System.out.println("실행 결과");
        while (times > 0) {
            cars.forEach(Car::randomGo);
            cars.forEach(Car::print);
            System.out.println();
            times--;
        }
        System.out.println("최종 우승자 : " + String.join(", ", getWinnerNames()));
    }
}
