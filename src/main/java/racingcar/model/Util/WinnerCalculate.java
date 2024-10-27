package racingcar.model.Util;

import racingcar.model.Car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WinnerCalculate {

    public List<Car> winnerCars(List<Car> cars) {
        Car winner = findWinners(cars);
        return getWinnerCars(cars, winner.getMoveCount());
    }

    private Car findWinners(List<Car> cars) {
        PriorityQueue<Car> pq = new PriorityQueue<>(cars);
        return pq.poll();
    }

    private List<Car> getWinnerCars(List<Car> cars, int winningMoveCount) {
        List<Car> winnerCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMoveCount() == winningMoveCount) {
                winnerCars.add(car);
            }
        }

        return winnerCars;
    }
}
