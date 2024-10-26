package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winners;

    public Winner() {
        winners = new ArrayList<>();
    }

    public List<String> findWinner(List<Car> cars) {
        int maxMovedNumber = findMaxMovedNumber(cars);
        for (Car car : cars) {
            if(car.isWinner(maxMovedNumber)){
                this.winners.add(car.getName());
            }
        }
        return this.winners;
    }

    private int findMaxMovedNumber(List<Car> cars) {
        int maxMovedNumber = -1;
        for (Car car : cars) {
            maxMovedNumber = Math.max(maxMovedNumber, car.getMovedNumber());
        }
        return maxMovedNumber;
    }
}
