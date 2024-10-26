package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarGameManager;

public class CarService {
    public Car car;
    public CarGameManager carGameManager;

    public CarService(CarGameManager carGameManager) {
        this.carGameManager = carGameManager;
    }

    public void start(String[] names, int times) {
        carGameManager.start(names, times);
    }


}
