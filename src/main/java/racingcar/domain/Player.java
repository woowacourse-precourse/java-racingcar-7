package racingcar.domain;

import java.util.List;

public class Player {
    private final List<Car> carList;

    private Player(List<Car> carList) {
        this.carList = carList;
    }

    public static Player from(List<Car> carList) {
        return new Player(carList);
    }

    public void play() {
        carList.stream()
                .filter(car -> RuleChecker.canMove())
                .forEach(Car::run);
    }
}
