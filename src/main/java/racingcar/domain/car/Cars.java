package racingcar.domain.car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RaceException;
import racingcar.util.RandomValue;

public class Cars {

    private static final int ONE = 1;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = validate(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.process(RandomValue.generate());
        }
    }

    public List<Car> win() {
        return findSamePositionCar(getMaxPosition());
    }

    private int getMaxPosition() {
        return getMaxPositionCar().getPosition();
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get();
    }

    private List<Car> findSamePositionCar(int position) {
        return cars.stream()
                .filter(car -> car.isEqualPosition(position))
                .toList();
    }

    private List<Car> validate(List<Car> cars) {
        validateParticipant(cars);
        validateDuplicateName(cars);

        return cars;
    }

    private void validateParticipant(List<Car> cars) {
        if (isOne(cars)) {
            throw new RaceException(ErrorMessage.INVALID_RACE_LIST_SIZE);
        }
    }

    private boolean isOne(List<Car> cars) {
        return cars.size() == ONE;
    }

    private void validateDuplicateName(List<Car> cars) {
        if (hasDuplicateName(cars)) {
            throw new RaceException(ErrorMessage.INVALID_SAME_NAME);
        }
    }

    private boolean hasDuplicateName(List<Car> cars) {
        return cars.size() != getUniqueNameCount(cars);
    }

    private int getUniqueNameCount(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet())
                .size();
    }
}
