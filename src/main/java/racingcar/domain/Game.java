package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars = new ArrayList<>();

    public List<Car> createCars(List<String> names) {
        validateDuplicated(names);
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
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
