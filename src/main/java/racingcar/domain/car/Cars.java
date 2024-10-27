package racingcar.domain.car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Name;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RaceException;
import racingcar.util.RandomValue;

public class Cars {

    private static final int RACE_THRESHOLD = 1;

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = generateCars(Validator.validate(names));
    }

    private List<Car> generateCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.process(RandomValue.generate());
        }
    }

    public List<Name> findWinners() {
        return findSamePositionCar(getMaxPosition()).stream()
                .map(Car::name)
                .toList();
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

    private static class Validator {

        private static List<String> validate(List<String> names) {
            validateParticipant(names);
            validateDuplicateName(names);

            return names;
        }

        private static void validateParticipant(List<String> cars) {
            if (isOne(cars)) {
                throw new RaceException(ErrorMessage.INVALID_RACE_LIST_SIZE);
            }
        }

        private static boolean isOne(List<String> cars) {
            return cars.size() == RACE_THRESHOLD;
        }

        private static void validateDuplicateName(List<String> names) {
            if (hasDuplicateName(names)) {
                throw new RaceException(ErrorMessage.INVALID_SAME_NAME);
            }
        }

        private static boolean hasDuplicateName(List<String> names) {
            return names.size() != getUniqueNameCount(names);
        }

        private static int getUniqueNameCount(List<String> names) {
            return names.stream()
                    .map(String::toString)
                    .collect(Collectors.toSet())
                    .size();
        }
    }
}
