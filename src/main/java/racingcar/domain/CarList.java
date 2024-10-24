package racingcar.domain;

import java.util.List;
import racingcar.utils.RandomGenerator;

public class CarList {
    private final List<Car> carList;
    private final RandomGenerator randomGenerator;

    public CarList(List<Car> carList, RandomGenerator randomGenerator) {
        this.carList = carList;
        this.randomGenerator = randomGenerator;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveAll() {
        int randonNumber = randomGenerator.generate();
        carList.forEach(car -> car.move(randonNumber));
    }
}
