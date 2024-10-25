package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<Car> cars;
    private List<String> winners;
    private int maxPosition = 0;

    public Winner(List<Car> cars) {
        this.cars = cars;
        this.winners = selectWinners();
    }

    private List<String> selectWinners() {
        List<String> winners = new ArrayList<>();

        findMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private void findMaxPosition() {
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
