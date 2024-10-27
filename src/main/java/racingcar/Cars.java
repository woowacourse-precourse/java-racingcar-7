package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(String rawCarNames) {
        this.cars = parseCarNames(rawCarNames);
    }

    private List<Car> parseCarNames(String rawCarNames) {
        return Stream.of(rawCarNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }
}
