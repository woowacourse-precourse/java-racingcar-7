package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> createCars(List<Name> names, NumberGenerator NumberGenerator) {
        validateDuplicateNames(names);
        return names.stream()
                .map(name -> new Car(name, NumberGenerator))
                .collect(Collectors.toList());
    }

    private static void validateDuplicateNames(List<Name> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
