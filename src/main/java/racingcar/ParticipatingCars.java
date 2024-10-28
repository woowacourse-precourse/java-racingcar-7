package racingcar;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParticipatingCars {
    private final List<Car> cars;

    public ParticipatingCars(String[] cars) {
        List<Car> carList = Arrays.stream(cars)
                .map(Car::new)
                .collect(Collectors.toList());
        validateDuplicateCarName(carList);
        this.cars = carList;
    }

    public List<Car>racing() {
        return cars.stream()
                .map(Car::forward)
                .collect(Collectors.toList());

    }

    private void validateDuplicateCarName(List<Car> carList) {
        Set<Car> cars = new HashSet<>(carList);
        if (cars.size() != carList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 자동차 이름이 있습니다");
        }
    }
}
