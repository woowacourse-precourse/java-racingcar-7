package racingcar.domain.winner.entity;

import racingcar.domain.car.entity.Car;

import java.util.List;

public class Winner {
    private final List<Car> winningCars;

    public Winner(List<Car> winningCars) {
        this.winningCars = winningCars;
    }

    public List<Car> getWinningCars() {
        return winningCars;
    }
}
