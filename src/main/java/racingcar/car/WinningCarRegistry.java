package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class WinningCarRegistry {

    private final List<Car> winningCars = new ArrayList<>();

    private boolean isWinner(long maxScore, Car car) {
        return car.status == maxScore;
    }

    public void registerWinningCar(List<Car> cars, long maxScore) {
        cars.forEach(car -> {
            if (isWinner(maxScore, car)) {
                winningCars.add(car);
            }
        });
    }

    public List<Car> collectWinningCars() {
        return winningCars;
    }
}
