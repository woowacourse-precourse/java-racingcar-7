package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.power.PowerGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        duplicateValidationName(names);

        this.cars = names.stream()
                .map(Name::new)
                .map(Car::new)
                .toList();
    }

    private void duplicateValidationName(List<String> name) {
        if (new HashSet<>(name).size() != name.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public void move(PowerGenerator powerGenerator) {
        cars.forEach(car -> car.move(powerGenerator.generatorPower()));
    }

    public String getForwardStatuses() {
        return cars.stream()
                .map(Car::forwardStatus)
                .collect(Collectors.joining("\n"));
    }

    public String getWinnerNames() {
        return cars.stream()
                .filter(car -> car.isMaxPosition(getMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(0, Integer::max);
    }

}
