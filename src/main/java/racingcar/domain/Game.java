package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final List<Car> cars;
    private final Map<Car, String> results;

    public Game() {
        this.cars = new ArrayList<>();
        this.results = new HashMap<>();
    }

    public List<Car> createCars(List<String> names) {
        validateDuplicated(names);
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public Map<Car, String> play(List<String> names) {
        createCars(names);
        for (Car car : cars) {
            int randNum = Randoms.pickNumberInRange(0, 9);
            car.move(randNum >= 4);
        }
        return judge();
    }

    private Map<Car, String> judge() {
        cars.stream()
                .filter(car -> car.getPosition() == cars.stream()
                        .mapToInt(Car::getPosition)
                        .max()
                        .orElse(0))
                .forEach(car -> results.put(car, car.getName()));
        return results;
    }

    private void validateDuplicated(List<String> names) {
        long nonDuplicatedSize = names.stream()
                .distinct()
                .count();
        if (nonDuplicatedSize != names.size()) {
            throw new IllegalArgumentException("이름이 중복되었습니다.");
        }
    }
}
