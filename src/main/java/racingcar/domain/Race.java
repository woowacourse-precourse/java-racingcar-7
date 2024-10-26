package racingcar.domain;

import racingcar.util.ParseStringUtil;

import java.util.List;

public class Race {

    private final List<Car> raceCars;

    private Race(List<Car> raceCars) {
        this.raceCars = raceCars;
    }

    public List<Car> getRaceCars() {
        return raceCars;
    }

    public static Race setupRace(String carNames) {
        return new Race(getCarNamesList(carNames).stream()
                .map(Race::createCar)
                .toList());
    }

    private static List<String> getCarNamesList(String input) {
        return ParseStringUtil.parseCarNames(input);
    }

    private static Car createCar(String carName) {
        return new Car(carName, 0);
    }

}
