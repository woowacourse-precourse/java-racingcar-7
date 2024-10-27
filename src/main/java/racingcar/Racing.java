package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {

    public void ready() {
        List<String> carNames = List.of("pobi", "woni");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        start(cars);
    }

    private void start(List<Car> cars) {
        int lap = 5;
        for (int i = 0; i < lap; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (randomNumber >= 4) {
                    car.move();
                }
            }
        }

        finish(cars);
    }

    private void finish(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }
}
