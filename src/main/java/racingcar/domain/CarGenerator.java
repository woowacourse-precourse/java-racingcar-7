package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarGenerator {

    private final String[] carNames;
    private final int maximumGenerate;

    public CarGenerator(String[] carNames, int maximumGenerate) {
        this.maximumGenerate = maximumGenerate;
        validateNumberOfCars(carNames);
        this.carNames = carNames;
    }

    public List<Car> generate() {
        return Arrays.stream(carNames)
            .map(Car::new)
            .toList();
    }

    private void validateNumberOfCars(String[] carNames) {
        if (carNames.length > maximumGenerate) {
            throw new IllegalArgumentException("100개 이하의 자동차만 입력 가능합니다.");
        }
    }
}
