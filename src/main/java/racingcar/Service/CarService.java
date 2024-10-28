package racingcar.Service;

import racingcar.Model.Car;

import java.util.ArrayList;

public class CarService {

    public ArrayList<Car> separateCarNames(String carNames) {
        String[] cars = carNames.split(",");
        ArrayList<Car> carList = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            carList.add(new Car(cars[i]));
        }

        return carList;
    }
}
