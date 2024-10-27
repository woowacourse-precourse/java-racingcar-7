package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;

public class ProcessService {
    public ArrayList<Car> getWinnerCar(Game game) {
        List<Car> candidates = game.getRacingCarArray();
        int max = getMaxDistance(candidates);
        return getWinner(candidates, max);
    }

    private int getMaxDistance(List<Car> candidates) {
        int max = 0;
        for (Car car : candidates) {
            if (car.getDistance() > max) {
                max = car.getDistance();
            }
        }
        return max;
    }

    private ArrayList<Car> getWinner(List<Car> candidates, int max) {
        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : candidates) {
            if (car.getDistance() == max) {
                winners.add(car);
            }
        }
        return winners;
    }
}
