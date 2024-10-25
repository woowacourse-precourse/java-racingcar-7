package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarManager {

    private final List<Car> cars = new ArrayList<>();

    public CarManager(List<String> carNames) {
        for (String name: carNames)
            cars.add(new Car(name));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.go(randomNumber);
        }
    }

    public int getMaximumScore() {
        int maximum = 0;
        for (Car car : cars) {
            if (car.getScore() > maximum)
                maximum = car.getScore();
        }

        return maximum;
    }
}
