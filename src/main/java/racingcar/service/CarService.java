package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.controller.CarController;
import racingcar.domain.Car;
import racingcar.util.Utils;

public class CarService {
    private static CarService carService;

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService();
        }
        return carService;
    }

    public List<Car> makeCarInstance(String[] carNames){
        List<Car> cars = new ArrayList<Car>();
        for(String carName : carNames){
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public void advanceCar(List<Car> cars, int num) {
    }
}
