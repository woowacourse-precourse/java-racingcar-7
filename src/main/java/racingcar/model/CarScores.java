package racingcar.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class CarScores {
    private static final String CARS_SEPARATOR = ",";

    private LinkedHashMap<CarName, Distance> carScores;

    public CarScores(String cars) {
        isBlank(cars);
        carScores = new LinkedHashMap<>(Arrays.stream(cars.split(CARS_SEPARATOR))
                .map(String::strip)
                .collect(Collectors.toMap(CarName::new, element -> new Distance(0))));
    }

    public CarScores(LinkedHashMap<CarName, Distance> carScores) {
        this.carScores = carScores;
    }

    public static void isBlank(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }
    }

    public LinkedHashMap<CarName, Distance> getCarScores() {
        return carScores;
    }
}
