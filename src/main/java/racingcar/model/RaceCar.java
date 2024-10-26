package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceCar {
    private final List<Car> cars;

    public RaceCar(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxStatus = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            int status = car.getStatus();

            if (maxStatus < status) {
                maxStatus = status;
                winners.clear();
                winners.add(car.getName());
            } else if (maxStatus == status) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void move() {
        cars.forEach(this::moveEach);
    }

    private void moveEach(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.moveCar();
        }
    }

}
