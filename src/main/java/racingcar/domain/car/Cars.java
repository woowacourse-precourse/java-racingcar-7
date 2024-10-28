package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.output.RoundView;
import racingcar.view.output.RacingRoundView;

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

    public void moveAllCarsRandomly() {
        cars.forEach(car -> {
            int number = Randoms.pickNumberInRange(0, 9);
            car.moveCar(number);
        });
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public int size() {
        return cars.size();
    }

    public List<RoundView> createRoundResults() {
        return cars.stream()
                .map(car -> new RacingRoundView(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
