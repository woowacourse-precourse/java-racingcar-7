package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Validator;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void allMove(int tryCount){
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    private void validate() {
        Validator.containDuplicate(extractCarNames(cars));
    }

    private List<String> extractCarNames(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
