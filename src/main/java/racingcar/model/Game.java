package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void oneRoundGame(Cars cars) {
        Move move = new Move();
        List<Car> carGroup = cars.getCarGroup();
        for (Car car : carGroup) {
            move.moveFoward(car);
        }
    }

    private int findWinningCarPosition(List<Car> carGroup) {
        int maximumPositon = 0;
        for (Car car : carGroup) {
            int carPosition = car.getPosition();
            if (maximumPositon < carPosition)
                maximumPositon = carPosition;
        }
        return maximumPositon;
    }

    public List<Car> findWinningCars(Cars cars) {
        List<Car> carGroup = cars.getCarGroup();
        List<Car> winningCarGroup = new ArrayList<>();
        int maximumPosition = findWinningCarPosition(carGroup);
        for (Car car : carGroup) {
            if (maximumPosition == car.getPosition()) {
                winningCarGroup.add(car);
            }
        }
        return winningCarGroup;
    }
}
