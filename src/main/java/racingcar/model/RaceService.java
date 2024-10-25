package racingcar.model;

import static racingcar.constant.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Car;

public class RaceService {

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void raceOnce(List<Car> cars) {
        for (Car car : cars) {
            moveConditionally(car);
        }
    }

    private void moveConditionally(Car car) {
        int random = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (random >= MOVE_THRESHOLD) {
            car.increaseDistance();
        }
    }
}
