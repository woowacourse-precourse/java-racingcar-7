package racingcar.model;

import java.util.List;
import racingcar.util.RandomUtil;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void racing() {
        for (Car car : cars) {
            int randomNum = RandomUtil.makeRandom();
            car.carMove(randomNum);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
