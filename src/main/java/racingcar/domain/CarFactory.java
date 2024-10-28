package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CarFactory {
    private static final int carLimit = 5;

    private static CarFactory instance = new CarFactory();
    private CarFactory() {}
    public static CarFactory getInstance() {
        return instance;
    }

    public List<Car> createCars(String input) {
        List<String> carNames = parseCar(input);
        return carNames.stream()
                        .map(CarFactory::createCar)
                        .collect(Collectors.toList());
    }

    private static List<String> parseCar(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                                        .map(String::trim)
                                        .collect(Collectors.toList());
        validateCount(carNames);
        return carNames;
    }

    private static Car createCar(String name) {
        return new Car(name);
    }

    private static void validateCount(List<String> carNames) {
        if (carNames.size() > carLimit) {
            throw new IllegalArgumentException("자동차의 개수는 5개를 넘을 수 없습니다.");
        }
    }
}
