package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> winners;

    public Winner() {
        winners = new ArrayList<>();
    }

    public Winner(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public void addWinner(List<Car> cars) {
        int highestPoint = 0;

        for (Car car : cars) {
            if (car.getPoint() > highestPoint) {
                highestPoint = car.getPoint();
            }
        }

        for (Car car : cars) {
            if (car.getPoint() == highestPoint) {
                winners.add(car);
            }
        }
    }
}
