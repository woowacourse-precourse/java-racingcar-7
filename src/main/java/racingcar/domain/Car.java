package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 최대 " + MAX_NAME_LENGTH + "자까지 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public static List<Car> createCarsFromNames(String names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 목록이 비어 있습니다.");
        }

        String[] nameArray = names.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : nameArray) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }
}