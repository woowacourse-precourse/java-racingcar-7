package racingcar.entity;

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
