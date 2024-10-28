package racingcar;

import java.util.List;

public class Round {

    final List<Car> cars;

    public Round(final List<Car> cars) {
        this.cars = cars;
    }

    public void play(final List<Integer> randomNumbers) {
        if (cars.size() != randomNumbers.size()) {
            throw new IllegalArgumentException("자동차 컬렉션의 크기와 난수 컬렉션의 크기가 일치하지 않습니다.");
        }
        for (int round=0; round<randomNumbers.size(); round++) {
            Car car = cars.get(round);
            car.execute(randomNumbers.get(round));
        }
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        for (Car car: cars) {
            result.append(car.toString()).append("\n");
        }
        System.out.println(result);
    }

    public String roundResult() {
        StringBuilder builder = new StringBuilder();
        for (Car car: cars) {
            builder.append(car).append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }
}
