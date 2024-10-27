package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars;  // 자동차 리스트

    public Game(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            boolean isForward = randomValue >= 4;
            car.move(isForward);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
