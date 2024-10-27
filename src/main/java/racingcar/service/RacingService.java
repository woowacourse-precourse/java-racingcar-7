package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    private RacingGame racingGame;

    public RacingService() {
    }

    public void initGame(List<Car> cars, int num) {
        racingGame = new RacingGame(cars, num);
    }

    public List<Car> generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    public List<Car> playOneGame() {
        List<Car> carList = racingGame.getCarList();

        for (Car car : carList) {
            car.move();
        }

        return carList;
    }

    public RacingGame getRacingGame() {
        return racingGame;
    }
}
