package racingcar.util;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    // String 리스트로 Car 리스트 생성
    public static List<Car> createCars(List<String> names) {
        return names.stream()
                .map(Car::new) // Car 객체 생성
                .collect(Collectors.toList());
    }
}
