package racingcar.domain.factory;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarFactory {
    private final String delimiter;

    public CarFactory(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<Car> getCars(String input) {
        String[] carNames = input.split(delimiter);
        if (hasDuplicateName(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
        return Arrays.stream(carNames).map(Car::new).toList();
        //이름 중복 검사
    }

    private boolean hasDuplicateName(String[] names) {
        Set<String> nameSet = Arrays.stream(names).collect(Collectors.toSet());
        return names.length != nameSet.size();
    }
}
