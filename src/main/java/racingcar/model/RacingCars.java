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
        values.forEach(racingCar ->
                carNameAndPosition.put(racingCar.getName(), racingCar.getPosition())
        );

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
        if (values.stream().distinct().count() != values.size()) {
            throw ExceptionFactory.createException(DUPLICATED_CARS);
        }
    }
}
