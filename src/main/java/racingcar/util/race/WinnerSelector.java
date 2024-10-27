package racingcar.util.race;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerSelector {
    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return winnerListAdd(cars, maxPosition);
    }

    private List<Car> winnerListAdd(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            isMaxPosition(winners, car, maxPosition);
        }
        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }


    private void isMaxPosition(List<Car> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }
}
