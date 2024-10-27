package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    public static String delimiter = ",";

    private final List<Car> cars;

    public Cars(String inputCars) {
        this.cars = createCars(inputCars);
    }

    private List<Car> createCars(String inputCars) {
        List<Car> carsList = new ArrayList<>();
        Set<String> carNamesSet = new HashSet<>();
        String[] carNames = inputCars.split(delimiter);

        for (String carName : carNames) {
            String trimmedName = carName.trim();
            if (carNamesSet.contains(trimmedName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + trimmedName);
            }
            carNamesSet.add(trimmedName);
            carsList.add(new Car(new CarName(trimmedName)));
        }
        return carsList;
    }

    public List<Car> getCars() {
        return cars;
    }
}