package racingcar;

import java.util.List;

public class Racing {

    private final Input input;

    public Racing(Input input) {
        this.input = input;
    }

    public void ready() {
        String rawCarNames = input.readCarNames();
        Cars cars = new Cars(rawCarNames);

        start(cars);
    }

    private void start(Cars cars) {
        int lap = 5;
        for (int i = 0; i < lap; i++) {
            cars.moveAll();
        }

        
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
