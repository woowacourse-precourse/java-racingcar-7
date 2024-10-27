package racingcar.manager;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;

public class GameManager {
    public List<Car> judgeWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int longest = 0;
        for(Car car : cars) {
            if (car.getPosition() > longest) {
                longest = car.getPosition();
            }
        }

        for(Car car : cars) {
            if (car.getPosition() == longest) {
                winners.add(car);
            }
        }
        return winners;
    }
}
