package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.util.SplitterUtil;

public class Cars {

    private static final String DUPLICATE_CAR_NAME = "중복된 이름이 존재합니다.";


    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Cars(String carName, MoveStrategy moveStrategy) {
        this.cars = createCars(carName);
        this.moveStrategy = moveStrategy;
        validateDuplicateCarNames(carName);
    }

    public void moveAllCars() {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> createCars(String carNames) {
        String[] splitCarNames = SplitterUtil.splitCarNames(carNames);

        return Arrays.stream(splitCarNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateDuplicateCarNames(String carNames) {
        String[] splitCarNames = SplitterUtil.splitCarNames(carNames);
        List<String> carNameList = Arrays.asList(splitCarNames);
        int uniqueCarNames = new HashSet<>(carNameList).size();

        if (uniqueCarNames != cars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
