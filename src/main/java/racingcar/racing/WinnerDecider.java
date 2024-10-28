package racingcar.racing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.car.Car;

public class WinnerDecider {
    public String getRacingWinner(List<Car> cars) {
        List<Car> copyCars = new ArrayList<>(cars);
        int moveDistanceMax = getMoveDistanceMax(copyCars);
        return choseRacingWinner(copyCars, moveDistanceMax);
    }

    private int getMoveDistanceMax(List<Car> cars) {
        cars.sort(Comparator.comparingInt(Car::getMoveDistance).reversed());
        return cars.getFirst().getMoveDistance();
    }

    private String choseRacingWinner(List<Car> cars, int moveDistanceMax) {
        StringBuilder winners = new StringBuilder();

        winners.append(cars.getFirst().getCarName());
        for (int i = 1; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getMoveDistance() != moveDistanceMax) {
                break;
            }
            winners.append(", ").append(car.getCarName());
        }

        return winners.toString();
    }
}
