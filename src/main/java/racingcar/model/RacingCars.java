package racingcar.model;

import racingcar.exception.ExceptionFactory;
import racingcar.service.dependency.random_maker.RandomNumberMaker;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.exception.ExceptionType.DUPLICATED_CARS;
import static racingcar.exception.ExceptionType.EMPTY_CARS;

public class RacingCars {

    private final List<RacingCar> values;

    public RacingCars(List<RacingCar> values) {
        validate(values);
        this.values = values.stream()
                .map(RacingCar::new)
                .toList();
    }

    public RacingCars(RacingCars other) {
        this(other.values);
    }

    public void move(RandomNumberMaker randomNumberMaker) {
        values.forEach(racingCar -> racingCar.move(randomNumberMaker.makeRandomNumber()));
    }

    public String getJoinedNames(String delimiter) {
        return values.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(delimiter));
    }

    public LinkedHashMap<String, Integer> getCarNamesAndPositions() {
        LinkedHashMap<String, Integer> carNameAndPosition = new LinkedHashMap<>();

        values.forEach(rC -> carNameAndPosition.putAll(rC.getCarNameAndPosition()));

        return carNameAndPosition;
    }

    public RacingCars getMaxPositionCars() {
        int maxPosition = getMaxPosition();

        return new RacingCars(values.stream()
                .filter(rC -> rC.getPosition() == maxPosition)
                .map(RacingCar::new)
                .toList());
    }

    private int getMaxPosition() {
        return values.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    private void validate(List<RacingCar> values) {
        validateEmpty(values);
        validateDuplication(values);
    }

    private void validateEmpty(List<RacingCar> values) {
        if (values.isEmpty()) {
            throw ExceptionFactory.createException(EMPTY_CARS);
        }
    }

    private void validateDuplication(List<RacingCar> values) {
        if (values.size() != values.stream()
                .map(RacingCar::getName)
                .distinct()
                .count()) {

            throw ExceptionFactory.createException(DUPLICATED_CARS);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RacingCars that = (RacingCars) o;

        return values.equals(that.values);
    }

    @Override
    public int hashCode() {
        return values.hashCode();
    }
}
