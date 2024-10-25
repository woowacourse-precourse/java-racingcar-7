package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceManager {

    private ArrayList<Car> cars = new ArrayList<>();

    public void setCarName(String input) {
        List<String> carName;
        try {
            carName = Arrays.asList(input.replace(" ", "").split(","));
            NameValidator.carNameLengthChecker(carName);
            for (String name : carName) {
                Car car = new Car();
                car.nameCar(name);
                cars.add(car);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(); // exception
        }
    }

    public void showProgressOfGame() {
        for (Car car : cars) {
            car.printForwardLevel();
        }
    }

    public ArrayList<Car> getCarList() {
        return cars;
    }

}
