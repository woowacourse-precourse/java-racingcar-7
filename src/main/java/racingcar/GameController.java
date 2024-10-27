package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public List<Car> mapToCarArray(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }

    public void moveCars(List<Car> cars, int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }
}
