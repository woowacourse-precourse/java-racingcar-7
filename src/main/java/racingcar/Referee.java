package racingcar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Referee {
    public ArrayList<Car> selectWinners(ArrayList<Car> cars) {
        ArrayList<Car> winners = new ArrayList<>();
        int max = Collections.max(cars).getLocation();
        for (Car car : cars) {
            selectWinner(winners, car, max);
        }
        return winners;
    }

    public void selectWinner(ArrayList<Car> winners, Car car, int max) {
        if (car.getLocation() == max) {
            winners.add(car);
        }
    }
}
