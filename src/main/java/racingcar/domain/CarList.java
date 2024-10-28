package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Parser;

public class CarList {
    private List<Car> carList;

    public CarList(String inputString) {
        this.carList = new ArrayList<>();
        String[] carNames = Parser.parseName(inputString);
        for(String name : carNames) {
            Validator.validateName(name);
            addCar(new Car(name));
        }
    }

    public void addCar(Car car) {
        carList.add(car);
    }
    public List<Car> getCarList() {
        return carList;
    }
}
