package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsFrom(String names) {
        List<Car> carList = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        validateDuplicate(carList);

        return new Cars(carList);
    }

    private static void validateDuplicate(List<Car> cars) {
        long distinctCarNameCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (distinctCarNameCount != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public void pickRandomNumberAndMoveCar() {
        cars.forEach(car -> {
            int number = Randoms.pickNumberInRange(0, 9);
            car.moveCar(number);
        });
    }

    public List<String> findWinners() {
        return null;
    }

    private int findMaxPosition() {
        return 0;
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
