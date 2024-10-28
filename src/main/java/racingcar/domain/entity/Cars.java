package racingcar.domain.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.util.SplitterUtil;
import racingcar.validator.CarNameValidator;

public class Cars {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Cars(String carName, MoveStrategy moveStrategy) {
        this.cars = createCars(carName);
        this.moveStrategy = moveStrategy;
        CarNameValidator.validateDuplicateCarNames(carName);
    }

    private List<Car> createCars(String carNames) {
        String[] splitCarNames = SplitterUtil.splitCarNames(carNames);

        return Arrays.stream(splitCarNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public void moveAll() {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }

}
