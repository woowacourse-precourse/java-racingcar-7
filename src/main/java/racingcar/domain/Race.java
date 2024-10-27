package racingcar.domain;

import racingcar.util.ParseStringUtil;
import racingcar.util.RandomNumUtil;

import java.util.Comparator;
import java.util.List;

public class Race {

    private final List<Car> raceCars;

    private Race(final List<Car> raceCars) {
        this.raceCars = raceCars;
    }

    public List<Car> getRaceCars() {
        return raceCars;
    }

    public static Race setupRace(final String carNames) {
        return new Race(getCarNamesList(carNames).stream()
                .map(Race::createCar)
                .toList());
    }

    private static List<String> getCarNamesList(final String input) {
        return ParseStringUtil.parseCarNames(input);
    }

    private static Car createCar(final String carName) {
        return new Car(carName);
    }

    public void doRace() {
        raceCars.forEach(this::moveForward);
    }

    private void moveForward(final Car car) {
        if (getRandomNum() >= 4)
            car.moveForward();
    }

    private int getRandomNum() {
        return RandomNumUtil.getRandomNum();
    }

    private int getHighestPosition() {
        return raceCars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("Race car not found."))
                .getPosition();
    }

    public List<String> getWinners() {
        int highestPosition = getHighestPosition();
        return raceCars.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::getName)
                .toList();
    }

}
