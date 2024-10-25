package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarService {

    private static final int FORWARD_CONDITION = 4;

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5 || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다");
            }
            cars.add(new Car(name));
        }
        return cars;
    }

    private boolean canMove() {
        if (Randoms.pickNumberInRange(0, 9) >= FORWARD_CONDITION) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.goForward();
            }
        }
    }

}
