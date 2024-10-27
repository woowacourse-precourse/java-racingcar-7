package racingcar.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class CarScores {
    private static final String CARS_DELIMITER = ",";

    private LinkedHashMap<CarName, Distances> carScores;

    public CarScores(String cars) {
        isBlank(cars);
        carScores = new LinkedHashMap<>(Arrays.stream(cars.split(CARS_DELIMITER))
                .map(String::strip)
                .collect(Collectors.toMap(CarName::new, element -> new Distances(0))));
    }

    public CarScores(LinkedHashMap<CarName, Distances> carScores) {
        this.carScores = carScores;
    }

    public static void isBlank(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }
    }

    public LinkedHashMap<CarName, Distances> getCarScores() {
        return carScores;
    }
}
