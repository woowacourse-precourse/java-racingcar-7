package racingcar;

import java.util.List;

public class Round {

    public static void play(final List<Car> cars, final List<Integer> randomNumbers) {
        if (cars.size() != randomNumbers.size()) {
            throw new IllegalArgumentException("자동차 컬렉션의 크기와 난수 컬렉션의 크기가 일치하지 않습니다.");
        }
        for (int round=0; round<randomNumbers.size(); round++) {
            Car car = cars.get(round);
            car.execute(randomNumbers.get(round));
        }
    }

    public static void printRoundResult(final List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
