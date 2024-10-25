package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class CarService {

    private static final int FORWARD_CONDITION = 4;

    public List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames).map(String::trim).peek(name -> {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다");
            }
        }).map(Car::new).toList();
    }

    private boolean canMove() {
        if (Randoms.pickNumberInRange(0, 9) >= FORWARD_CONDITION) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void moveCars(List<Car> cars) {
        cars.stream().filter(car -> canMove()).forEach(Car::goForward);
    }

}
