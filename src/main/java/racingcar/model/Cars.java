package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Validator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    private void validate() {
        Validator.containDuplicate(extractCarNames(cars));
    }

    public void allMove() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Integer> getCarsPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getDistance());
        }
        return positions;
    }


    public List<String> extractCarNames(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }


    public List<String> getCarNames() {
        return extractCarNames(cars);
    }


}
