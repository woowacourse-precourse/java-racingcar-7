package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RaceCar {
    private final List<Car> cars;

    public RaceCar(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int attempts) {
        while (attempts-- > 0) {
            move();
        }
    }

    public void move() {
        cars.forEach(this::moveEach);
    }

    public void moveEach(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.moveCar();
        }
    }

}
