package racingcar;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private String name;
    private int distance;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public void addDistance() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static List<Car> createCars(String carsName) {

        List<String> carNames = List.of(carsName.split(","));
        validateDuplicate(carNames);

        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void validateDuplicate(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);

        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
