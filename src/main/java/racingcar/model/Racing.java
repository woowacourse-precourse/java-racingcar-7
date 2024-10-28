package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> carList;

    public Racing(List<Car> carList) {
        validateDuplicate(carList);
        this.carList = carList;
    }

    public static Racing of(String cars) {
        return new Racing(Arrays.stream(cars.split(","))
                .map(Car::new)
                .toList());
    }

    private void validateDuplicate(List<Car> carList) {
        Set<String> nonDuplicateNames = new HashSet<>(carList.stream().map(Car::getName).toList());
        if (carList.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void runRound() {
        carList.forEach(Car::move);
    }

    public int calcMaxDistance() {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }

    public List<Car> getWinner() {
        return carList.stream()
                .filter(c -> c.getDistance() == calcMaxDistance())
                .toList();
    }

    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
