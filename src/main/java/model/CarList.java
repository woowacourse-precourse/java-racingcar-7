package model;

import error.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    public void addCar(String newCarName) {
        Car car = new Car(newCarName);
        carList.add(car);
    }

    public List<Car> getCars() {
        return carList;
    }

    public void setCarList(List<String> carNames) {
        for (String carName : carNames) {
            if (isCarExist(carName)) {
                throw new IllegalArgumentException(ExceptionMessage.CAR_ALEADY_EXIST);
            }
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public boolean isCarExist(String newCarName) {
        for (Car car : carList) {
            String existingName = car.getName();
            if (existingName.equals(newCarName)) {
                return true;
            }
        }
        return false;
    }
}
