package racingcar;

import java.util.List;
import util.NumberGenerator;

public class Racing {

    private final Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public void playRacing(NumberGenerator numberGenerator) {
        cars.playRacing(numberGenerator);
    }

    public List<Car> getCarList() {
        return cars.getCars();
    }
}
