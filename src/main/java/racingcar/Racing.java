package racingcar;

import java.util.List;

public class Racing {

    private final Cars cars;

    public Racing(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public void playRacing() {
        cars.playRacing();
    }

    public List<String> racingInfo() {
        return cars.getForwardInfos();
    }
}
